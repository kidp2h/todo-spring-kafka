package com.spring.kafka.infrastructure.persistence.mapper

import com.spring.kafka.domain.entity.Todo
import com.spring.kafka.infrastructure.persistence.entity.TodoJpaEntity

object TodoMapper {
    fun toDomain(entity: TodoJpaEntity): Todo = Todo(
        id = entity.id,
        title = entity.title,
        completed = entity.completed,
        createdAt = entity.createdAt
    )

    fun toEntity(domain: Todo): TodoJpaEntity = TodoJpaEntity(
        id = domain.id,
        title = domain.title,
        completed = domain.completed,
        createdAt = domain.createdAt
    )
}
