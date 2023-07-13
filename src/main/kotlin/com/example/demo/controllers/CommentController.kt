package com.example.demo.controllers

import com.example.demo.models.Comment
import com.example.demo.request.CommentRequest
import com.example.demo.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/Comment")
class CommentController(private val commentService: CommentService) {
    @GetMapping("/add")
    fun addComment(commentRequest: CommentRequest): ResponseEntity<Comment> {
       val comment = commentService.addComment(commentRequest)
       return ResponseEntity(comment, HttpStatus.OK)
    }

    @GetMapping("/get")
    fun getComment(commentId: Int): ResponseEntity<Comment> {
       return ResponseEntity(commentService.getComment(commentId), HttpStatus.OK)
    }

    @DeleteMapping("/delete")
    fun deleteComment(commentId: Int) {
        commentService.deleteComment(commentId)
    }
}
