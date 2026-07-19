package com.spring.kafka.infrastructure.messaging.kafka.dto

data class CreateTodoKafkaCommand(
    val title: String = ""
)
