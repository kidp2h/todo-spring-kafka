package com.spring.kafka.application.service

import com.spring.kafka.application.dto.TodoSearchDto
import com.spring.kafka.domain.entity.Todo
import com.spring.kafka.domain.repository.TodoRepository
import jakarta.transaction.Transactional
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class TodoService(
    private val todoRepository: TodoRepository
)  {
    @Transactional
    fun create(title: String): Todo {
        val todo = Todo(null, title, false)
        return todoRepository.save(todo)
    }

    fun complete(id: UUID) {
        val todo = todoRepository.findById(id)
            ?: throw IllegalArgumentException("Todo not found")
        todo.complete();
        todoRepository.save(todo);
    }
    fun search(searchDto: TodoSearchDto): Page<Todo> {

        return todoRepository.search(searchDto)
    }
}