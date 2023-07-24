package com.example.demo.repository

import com.example.demo.models.Project
import com.example.demo.models.Task
import com.example.demo.models.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepo : JpaRepository<Task, Int> {
    fun findAllByProject(project: Project, pageable: Pageable): Page<Task>
    fun findAllByAssignee(user: User, pageable: Pageable): Page<Task>
}
