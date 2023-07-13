package com.example.demo.controllers

import com.example.demo.models.Project
import com.example.demo.models.UserProject
import com.example.demo.request.UserProjectRequest
import com.example.demo.service.UserProjectService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/UserProject")
class UserProjectController(private val userProjectService: UserProjectService) {
     @GetMapping("/GetForUser/{id}")
     fun getProjForUser(@PathVariable id: Int): List<Project> {
         return userProjectService.getAllProjForUser(id)
     }

    @PostMapping("/post")
    fun addProjToUser(@RequestBody userProjectRequest: UserProjectRequest): ResponseEntity<UserProject> {
        val userProj = userProjectService.addProjectToUser(userProjectRequest)
        return ResponseEntity(userProj, HttpStatus.OK)
    }
}
