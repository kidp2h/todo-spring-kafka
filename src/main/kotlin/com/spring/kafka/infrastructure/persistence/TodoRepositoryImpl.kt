package com.spring.kafka.infrastructure.persistence

import com.spring.kafka.domain.common.PageResult
import com.spring.kafka.domain.entity.Todo
import com.spring.kafka.domain.repository.TodoRepository
import com.spring.kafka.domain.repository.TodoSearchCriteria
import com.spring.kafka.infrastructure.persistence.TodoSpecification.hasTitle
import com.spring.kafka.infrastructure.persistence.mapper.TodoMapper
import com.spring.kafka.infrastructure.persistence.repository.SpringDataTodoRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class TodoRepositoryImpl(
    private val jpaRepository: SpringDataTodoRepository
) : TodoRepository {

    override fun save(todo: Todo): Todo {
        val entity = TodoMapper.toEntity(todo)
        val saved = jpaRepository.save(entity)
        return TodoMapper.toDomain(saved)
    }

    override fun findById(id: UUID): Todo? {
        return jpaRepository.findById(id)
            .map { TodoMapper.toDomain(it) }
            .orElse(null)
    }

    override fun search(criteria: TodoSearchCriteria): PageResult<Todo> {
        val spec = Specification.where(hasTitle(criteria.title))
        val pageable = PageRequest.of(criteria.page, criteria.size)
        val page = jpaRepository.findAll(spec, pageable)

        return PageResult(
            content = page.content.map { TodoMapper.toDomain(it) },
            page = page.number,
            size = page.size,
            totalElements = page.totalElements,
            totalPages = page.totalPages
        )
    }
}