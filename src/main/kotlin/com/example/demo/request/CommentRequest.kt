package com.example.demo.request

import java.time.LocalDateTime

data class CommentRequest(
        val taskId: Long,
        val userId: Long,
        val commentText: String,
        val createdAt: LocalDateTime
)
