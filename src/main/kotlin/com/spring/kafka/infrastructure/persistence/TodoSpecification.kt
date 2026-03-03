package com.spring.kafka.infrastructure.persistence

import com.spring.kafka.domain.entity.Todo
import org.springframework.data.jpa.domain.Specification

object TodoSpecification {

    fun hasTitle(title: String?) = Specification<Todo> { root, _, cb ->
        title?.let {
            cb.like(cb.lower(root.get("title")), "%${it.lowercase()}%")
        } ?: cb.conjunction()
    }
}