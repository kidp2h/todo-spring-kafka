package com.spring.kafka.infrastructure.messaging.kafka.publisher

import com.spring.kafka.domain.event.TodoCompletedEvent
import com.spring.kafka.domain.event.TodoCreatedEvent
import com.spring.kafka.domain.publisher.TodoEventPublisher
import com.spring.kafka.infrastructure.messaging.kafka.config.KafkaConfig
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaTodoEventPublisher(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) : TodoEventPublisher {

    override fun publishCreated(event: TodoCreatedEvent) {
        kafkaTemplate.send(KafkaConfig.TOPIC_TODO_CREATED, event.id.toString(), event)
    }

    override fun publishCompleted(event: TodoCompletedEvent) {
        kafkaTemplate.send(KafkaConfig.TOPIC_TODO_COMPLETED, event.id.toString(), event)
    }
}
