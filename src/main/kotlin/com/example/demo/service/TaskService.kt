package com.example.demo.service

import com.example.demo.models.Task
import com.example.demo.repository.ProjectRepo
import com.example.demo.repository.TaskRepo
import com.example.demo.repository.UserRepo
import com.example.demo.request.TaskRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class TaskService(private val taskRepo: TaskRepo, private val projectRepo: ProjectRepo, private val userRepo: UserRepo) {
    /**
     * make sure all expeptions have a custom one
     */
    fun addTask(taskRequest: TaskRequest): Task {
        val project = projectRepo.findById(taskRequest.projectId.toInt()).orElseThrow { Exception("not found") }
        val user = userRepo.findById(taskRequest.assigneeId.toInt()).orElseThrow { Exception("not found") }
        val dueDate = LocalDate.parse(taskRequest.dueDate, DateTimeFormatter.ofPattern("MM-dd-yyyy"))
        val task = Task(0, project, taskRequest.taskName, taskRequest.description, user, dueDate, taskRequest.status, taskRequest.priority)
        return taskRepo.save(task)
    }

    fun getTaskForProject(projectId: Long, @PageableDefault(size = 10, sort = ["id"], direction = Sort.Direction.ASC) pageable: Pageable): Page<Task> {
        val project = projectRepo.findById(projectId.toInt()).orElseThrow { Exception("Custom needed") }
        return taskRepo.findAllByProject(project, pageable)
    }

    fun getTaskAssignedToUser() {
    }

    fun updateTask() {
    }
}
