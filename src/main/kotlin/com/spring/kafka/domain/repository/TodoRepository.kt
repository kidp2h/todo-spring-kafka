package com.spring.kafka.domain.repository

import com.spring.kafka.application.dto.TodoResponse
import com.spring.kafka.application.dto.TodoSearchDto
import com.spring.kafka.domain.entity.Todo
import org.springframework.data.domain.Page
import java.util.Optional
import java.util.UUID

interface TodoRepository {
    fun save(todo: Todo): Todo
    fun findById(id: UUID): Todo?
    fun search(searchDto: TodoSearchDto): Page<Todo>
}