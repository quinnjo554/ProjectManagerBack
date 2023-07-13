package com.example.demo.repository

import com.example.demo.models.User
import com.example.demo.models.UserProject
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserProjRepo : JpaRepository<UserProject, Int> {
    fun findByUser(user: User): List<UserProject>
}
