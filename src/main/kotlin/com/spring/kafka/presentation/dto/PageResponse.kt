package com.spring.kafka.presentation.dto

import com.spring.kafka.domain.common.PageResult

data class PageResponse<T>(
    val content: List<T>,
    val page: Int,
    val size: Int,
    val totalElements: Long,
    val totalPages: Int
) {
    companion object {
        fun <T, R> from(pageResult: PageResult<T>, mapper: (T) -> R): PageResponse<R> {
            return PageResponse(
                content = pageResult.content.map(mapper),
                page = pageResult.page,
                size = pageResult.size,
                totalElements = pageResult.totalElements,
                totalPages = pageResult.totalPages
            )
        }
    }
}
