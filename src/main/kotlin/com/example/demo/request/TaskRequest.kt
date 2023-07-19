package com.example.demo.request

data class TaskRequest(
            val projectId: Long,
            val taskName: String,
            val description: String?,
            val assigneeId: Long,
            val dueDate: String?,
            val status: String?,
            val priority: String?,
    )
