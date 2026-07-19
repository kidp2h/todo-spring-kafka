package com.spring.kafka.infrastructure.persistence.repository

import com.spring.kafka.infrastructure.persistence.entity.TodoJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.UUID

interface SpringDataTodoRepository : JpaRepository<TodoJpaEntity, UUID>, JpaSpecificationExecutor<TodoJpaEntity>