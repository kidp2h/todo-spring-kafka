package com.spring.kafka.presentation.common

import org.springframework.data.domain.Pageable

abstract class AbstractSearchDto(
    var pageable: Pageable
)