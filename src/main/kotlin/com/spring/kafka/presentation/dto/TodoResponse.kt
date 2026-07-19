package com.spring.kafka.presentation.dto

import com.spring.kafka.domain.entity.Todo
import java.util.UUID

data class TodoResponse(
    val id: UUID?,
    val title: String,
    val completed: Boolean
) {
    companion object {
        fun from(todo: Todo): TodoResponse =
            TodoResponse(
                id = todo.id,
                title = todo.title,
                completed = todo.completed
            )
    }
}
