package com.example.demo.controllers

import com.example.demo.models.Task
import com.example.demo.request.TaskRequest
import com.example.demo.service.TaskService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/Task")
class TaskController(private val taskService: TaskService) {
    @GetMapping("/project/{id}")
    fun getTaskForProject(
        @PathVariable id: Long,
                       @PageableDefault(size = 10, sort = ["id"], direction = Sort.Direction.ASC) pageable: Pageable,
    ): ResponseEntity<Page<Task>> {
        val task = taskService.getTaskForProject(id, pageable)
        return ResponseEntity(task, HttpStatus.OK)
    }

    @PostMapping("/add")
    fun addTaskToProject(@RequestBody taskRequest: TaskRequest): Task {
        return taskService.addTask(taskRequest)
    }
}
