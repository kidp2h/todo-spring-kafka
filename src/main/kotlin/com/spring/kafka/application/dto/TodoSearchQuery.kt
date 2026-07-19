package com.spring.kafka.application.dto

import com.spring.kafka.domain.repository.TodoSearchCriteria

data class TodoSearchQuery(
    val title: String? = null,
    val page: Int = 0,
    val size: Int = 10
) {
    fun toCriteria(): TodoSearchCriteria = TodoSearchCriteria(
        title = title,
        page = page,
        size = size
    )
}
