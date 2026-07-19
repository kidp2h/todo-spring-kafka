package com.spring.kafka.infrastructure.messaging.kafka.listener

import com.spring.kafka.application.service.TodoService
import com.spring.kafka.infrastructure.messaging.kafka.config.KafkaConfig
import com.spring.kafka.infrastructure.messaging.kafka.dto.CompleteTodoKafkaCommand
import com.spring.kafka.infrastructure.messaging.kafka.dto.CreateTodoKafkaCommand
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class TodoKafkaListener(
    private val todoService: TodoService
) {

    @KafkaListener(topics = [KafkaConfig.TOPIC_TODO_CREATE], groupId = "todo-group")
    fun handleCreateTodo(command: CreateTodoKafkaCommand) {
        todoService.create(command.title)
    }

    @KafkaListener(topics = [KafkaConfig.TOPIC_TODO_COMPLETE], groupId = "todo-group")
    fun handleCompleteTodo(command: CompleteTodoKafkaCommand) {
        command.id?.let { todoId ->
            todoService.complete(todoId)
        }
    }
}
