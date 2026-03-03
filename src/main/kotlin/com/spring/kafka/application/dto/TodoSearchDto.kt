package com.spring.kafka.application.dto

import com.spring.kafka.presentation.common.AbstractSearchDto
import org.springframework.data.domain.Pageable

class TodoSearchDto(pageable: Pageable, val title: String?) : AbstractSearchDto(pageable) {
}