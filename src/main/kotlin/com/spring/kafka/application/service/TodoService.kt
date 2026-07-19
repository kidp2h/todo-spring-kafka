package com.spring.kafka.application.service

import com.spring.kafka.application.dto.TodoSearchQuery
import com.spring.kafka.domain.common.PageResult
import com.spring.kafka.domain.entity.Todo
import com.spring.kafka.domain.event.TodoCompletedEvent
import com.spring.kafka.domain.event.TodoCreatedEvent
import com.spring.kafka.domain.publisher.TodoEventPublisher
import com.spring.kafka.domain.repository.TodoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class TodoService(
    private val todoRepository: TodoRepository,
    private val todoEventPublisher: TodoEventPublisher
) {
    @Transactional
    fun create(title: String): Todo {
        val todo = Todo(title = title)
        val savedTodo = todoRepository.save(todo)

        savedTodo.id?.let { id ->
            todoEventPublisher.publishCreated(
                TodoCreatedEvent(
                    id = id,
                    title = savedTodo.title,
                    createdAt = savedTodo.createdAt
                )
            )
        }

        return savedTodo
    }

    @Transactional
    fun complete(id: UUID) {
        val todo = todoRepository.findById(id)
            ?: throw IllegalArgumentException("Todo not found")
        todo.complete()
        val savedTodo = todoRepository.save(todo)

        savedTodo.id?.let { todoId ->
            todoEventPublisher.publishCompleted(
                TodoCompletedEvent(
                    id = todoId,
                    title = savedTodo.title
                )
            )
        }
    }

    @Transactional(readOnly = true)
    fun search(query: TodoSearchQuery): PageResult<Todo> {
        return todoRepository.search(query.toCriteria())
    }
}