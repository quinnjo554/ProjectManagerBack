package com.example.demo.repository

import com.example.demo.models.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepo : JpaRepository<Task, Int> {
}