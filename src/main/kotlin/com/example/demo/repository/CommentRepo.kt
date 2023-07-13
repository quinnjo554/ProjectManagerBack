package com.example.demo.repository
import com.example.demo.models.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepo : JpaRepository<Comment, Int>
