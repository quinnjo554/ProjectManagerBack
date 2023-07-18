package com.example.demo.service

import com.example.demo.exceptions.UserAlreadyExistsException
import com.example.demo.exceptions.UserNotFoundException
import com.example.demo.models.User
import com.example.demo.repository.UserRepo
import com.example.demo.request.UserRequest
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepo: UserRepo) {

    fun getUserByEmail(email: String): User {
        return userRepo.findByEmail(email)
                ?: throw UserNotFoundException() // think about security and what the exception should return
    }

    fun getUserById(id: Int): User {
        return userRepo.findById(id).orElseThrow { UserNotFoundException() }
    }

    fun createUser(userRequest: UserRequest): User {
        if (userRepo.findByEmail(userRequest.email) != null) {
            throw UserAlreadyExistsException()
        }
        val user = User(0, userRequest.userName, userRequest.email, userRequest.password,userRequest.img,userRequest.description)
        return userRepo.save(user)
    }

    fun deleteUserByEmail(email: String) {
        val user: User? = userRepo.findByEmail(email)
        if (user != null) {
           return userRepo.deleteById(user.userId)
        }
    }
}
