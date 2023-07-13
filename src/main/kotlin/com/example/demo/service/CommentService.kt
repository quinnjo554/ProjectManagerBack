package com.example.demo.service

import com.example.demo.models.Comment
import com.example.demo.repository.CommentRepo
import com.example.demo.repository.TaskRepo
import com.example.demo.repository.UserRepo
import com.example.demo.request.CommentRequest
import org.springframework.stereotype.Service

@Service
class CommentService(private val commentRepo: CommentRepo, private val taskRepo: TaskRepo, private val userRepo: UserRepo) {
    fun addComment(commentRequest: CommentRequest): Comment {
        val task = taskRepo.findById(commentRequest.taskId.toInt())
                .orElseThrow { throw IllegalArgumentException("Task not found") }
        val user = userRepo.findById(commentRequest.userId.toInt())
                .orElseThrow { throw IllegalArgumentException("User not found") }

        val comment = Comment(
                task = task,
                user = user,
                commentText = commentRequest.commentText,
                createdAt = commentRequest.createdAt,
        )
        return commentRepo.save(comment)
    }
    fun getComment(commentId: Int): Comment {
        return commentRepo.findById(commentId).orElseThrow { Exception("Bad") }
    }

    fun deleteComment(commentId: Int) {
        if (commentRepo.existsById(commentId)) {
            commentRepo.deleteById(commentId)
        } else {
            throw IllegalArgumentException("Comment not found")
        }
    }
}
