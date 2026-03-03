package com.spring.kafka.infrastructure.persistence

import com.spring.kafka.application.dto.TodoSearchDto
import com.spring.kafka.domain.entity.Todo
import com.spring.kafka.domain.repository.TodoRepository
import com.spring.kafka.infrastructure.persistence.TodoSpecification.hasTitle
import com.spring.kafka.infrastructure.persistence.repository.SpringDataTodoRepository
import org.springframework.data.domain.Page
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class TodoRepositoryImpl(
    private val jpaRepository: SpringDataTodoRepository
) : TodoRepository {

    override fun save(todo: Todo): Todo {
        val entity = toEntity(todo)
        val saved = jpaRepository.save(entity)
        return toDomain(saved)
    }

    override fun findById(id: UUID): Todo? {
        return jpaRepository.findById(id)
            .map { toDomain(it) }
            .orElse(null)
    }

    override fun search(searchDto: TodoSearchDto): Page<Todo> {
        val spec = Specification
            .where(hasTitle(searchDto.title))

        return jpaRepository.findAll(spec, searchDto.pageable)
    }

    private fun toEntity(todo: Todo) =
        Todo(
            id = todo.id,
            title = todo.title,
            completed = todo.completed
        )

    private fun toDomain(entity: Todo) =
        Todo(
            id = entity.id,
            title = entity.title,
            completed = entity.completed
        )
}