package com.spring.kafka.presentation.controller

import com.spring.kafka.application.dto.CreateTodoRequest
import com.spring.kafka.application.dto.TodoResponse
import com.spring.kafka.application.dto.TodoSearchDto
import com.spring.kafka.application.dto.common.PageResponse
import com.spring.kafka.application.service.TodoService
import com.spring.kafka.domain.entity.Todo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/todos")
class TodoController(
    private val todoService: TodoService
) {
    @PostMapping
    fun create(
        @RequestBody request: CreateTodoRequest
    ): ResponseEntity<TodoResponse> {

        val todo = todoService.create(request.title)

        val response = TodoResponse(
            id = todo.id,
            title = todo.title,
            completed = todo.completed
        )

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response)
    }

    @GetMapping
    fun search(
        @RequestParam title: String?,
        pageable: Pageable
    ): Page<TodoResponse> {
        val searchDto = TodoSearchDto(
            title = title,
            pageable = pageable
        )
        return todoService.search(searchDto).map { TodoResponse.from(it) }
    }
    
}
