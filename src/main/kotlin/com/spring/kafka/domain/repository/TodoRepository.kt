package com.spring.kafka.domain.repository

import com.spring.kafka.domain.common.PageResult
import com.spring.kafka.domain.entity.Todo
import java.util.UUID

data class TodoSearchCriteria(
    val title: String? = null,
    val page: Int = 0,
    val size: Int = 10
)

interface TodoRepository {
    fun save(todo: Todo): Todo
    fun findById(id: UUID): Todo?
    fun search(criteria: TodoSearchCriteria): PageResult<Todo>
}