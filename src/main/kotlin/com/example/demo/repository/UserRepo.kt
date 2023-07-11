package com.example.demo.repository

import com.example.demo.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo : JpaRepository<User, Int> {
    fun findByEmail(email: String): User?
    fun save(user: User): User
}
