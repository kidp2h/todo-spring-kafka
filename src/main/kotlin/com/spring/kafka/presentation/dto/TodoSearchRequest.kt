package com.spring.kafka.presentation.dto

import com.spring.kafka.application.dto.TodoSearchQuery

data class TodoSearchRequest(
    val title: String? = null,
    val page: Int = 0,
    val size: Int = 10
) {
    fun toQuery(): TodoSearchQuery = TodoSearchQuery(
        title = title,
        page = page,
        size = size
    )
}
