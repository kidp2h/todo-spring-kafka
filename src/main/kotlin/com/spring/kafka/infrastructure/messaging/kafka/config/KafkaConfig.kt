package com.spring.kafka.infrastructure.messaging.kafka.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.support.converter.JsonMessageConverter
import org.springframework.kafka.support.converter.RecordMessageConverter

@Configuration
class KafkaConfig {

    companion object {
        const val TOPIC_TODO_CREATE = "todo-create-topic"
        const val TOPIC_TODO_COMPLETE = "todo-complete-topic"
        const val TOPIC_TODO_CREATED = "todo-created-topic"
        const val TOPIC_TODO_COMPLETED = "todo-completed-topic"
    }

    @Bean
    fun jsonMessageConverter(): RecordMessageConverter = JsonMessageConverter()

    @Bean
    fun todoCreateTopic(): NewTopic = TopicBuilder.name(TOPIC_TODO_CREATE)
        .partitions(1)
        .replicas(1)
        .build()

    @Bean
    fun todoCompleteTopic(): NewTopic = TopicBuilder.name(TOPIC_TODO_COMPLETE)
        .partitions(1)
        .replicas(1)
        .build()

    @Bean
    fun todoCreatedTopic(): NewTopic = TopicBuilder.name(TOPIC_TODO_CREATED)
        .partitions(1)
        .replicas(1)
        .build()

    @Bean
    fun todoCompletedTopic(): NewTopic = TopicBuilder.name(TOPIC_TODO_COMPLETED)
        .partitions(1)
        .replicas(1)
        .build()
}
