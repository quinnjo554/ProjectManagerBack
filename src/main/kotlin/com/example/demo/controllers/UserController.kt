package com.example.demo.controllers

import com.example.demo.models.User
import com.example.demo.request.UserRequest
import com.example.demo.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/User")
class UserController(private val userService: UserService) {
    @GetMapping("/email/{email}")
    fun getUserByEmail(@PathVariable email: String): ResponseEntity<User> {
        val user = userService.getUserByEmail(email)
        return ResponseEntity(user, HttpStatus.OK)
    }

    @GetMapping("/id/{id}")
    fun getUserById(@PathVariable id: Int): ResponseEntity<User> {
        val user = userService.getUserById(id)
        return ResponseEntity(user, HttpStatus.OK)
    }

    @PostMapping("/post")
    fun addPokemonToTrainer(@RequestBody userRequest: UserRequest): User {
        return userService.createUser(userRequest)
    }

    @DeleteMapping("/delete/{email}")
    fun updateUser(@PathVariable email: String): ResponseEntity<User> {
        userService.deleteUserByEmail(email)
        return ResponseEntity(null, HttpStatus.OK)
    }
}
