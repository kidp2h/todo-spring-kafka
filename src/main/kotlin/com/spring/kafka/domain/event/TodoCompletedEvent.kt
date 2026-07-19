package com.spring.kafka.domain.event

import java.time.LocalDateTime
import java.util.UUID

data class TodoCompletedEvent(
    val id: UUID,
    val title: String,
    val completedAt: LocalDateTime = LocalDateTime.now()
)
