package com.spring.kafka.domain.event

import java.time.LocalDateTime
import java.util.UUID

data class TodoCreatedEvent(
    val id: UUID,
    val title: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
