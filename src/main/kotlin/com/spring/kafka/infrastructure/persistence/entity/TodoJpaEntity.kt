package com.spring.kafka.infrastructure.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "t_todo")
class TodoJpaEntity(
    @Id
    @GeneratedValue
    var id: UUID? = null,

    @Column(nullable = false)
    var title: String = "",

    @Column(nullable = false)
    var completed: Boolean = false,

    @Column(nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
)
