package com.spring.kafka.presentation.controller

import com.spring.kafka.application.service.TodoService
import com.spring.kafka.presentation.dto.CreateTodoRequest
import com.spring.kafka.presentation.dto.PageResponse
import com.spring.kafka.presentation.dto.TodoResponse
import com.spring.kafka.presentation.dto.TodoSearchRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

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
        val response = TodoResponse.from(todo)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response)
    }

    @PutMapping("/{id}/complete")
    fun complete(
        @PathVariable id: UUID
    ): ResponseEntity<Void> {
        todoService.complete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping
    fun search(
        @ModelAttribute request: TodoSearchRequest
    ): ResponseEntity<PageResponse<TodoResponse>> {
        val pageResult = todoService.search(request.toQuery())
        val response = PageResponse.from(pageResult) { TodoResponse.from(it) }

        return ResponseEntity.ok(response)
    }
}
