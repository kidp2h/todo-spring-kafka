package com.spring.kafka.domain.entity

import java.time.LocalDateTime
import java.util.UUID

class Todo(
    val id: UUID? = null,
    var title: String,
    var completed: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun complete() {
        if (completed) {
            throw IllegalStateException("Todo already completed")
        }
        completed = true
    }
}