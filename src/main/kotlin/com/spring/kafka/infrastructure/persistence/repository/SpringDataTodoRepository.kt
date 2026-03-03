package com.spring.kafka.infrastructure.persistence.repository

import com.spring.kafka.domain.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.UUID

interface SpringDataTodoRepository:  JpaRepository<Todo, UUID>, JpaSpecificationExecutor<Todo>{
    fun save(todo: Todo): Todo
}