package com.example.demo.service

import com.example.demo.repository.TaskRepo
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepo: TaskRepo) {

}