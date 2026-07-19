package com.spring.kafka.infrastructure.messaging.kafka.dto

import java.util.UUID

data class CompleteTodoKafkaCommand(
    val id: UUID? = null
)
