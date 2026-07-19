package com.spring.kafka.domain.publisher

import com.spring.kafka.domain.event.TodoCompletedEvent
import com.spring.kafka.domain.event.TodoCreatedEvent

interface TodoEventPublisher {
    fun publishCreated(event: TodoCreatedEvent)
    fun publishCompleted(event: TodoCompletedEvent)
}
