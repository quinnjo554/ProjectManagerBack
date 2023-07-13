package com.example.demo.controllers

import com.example.demo.models.Project
import com.example.demo.request.ProjectRequest
import com.example.demo.service.ProjectService
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
@RequestMapping("/Project")
class ProjectController(private val projectService: ProjectService) {
    @GetMapping("/{id}")
    fun getProjById(@PathVariable id: Int): ResponseEntity<Project> {
        val project = projectService.getProjectById(id)
        return ResponseEntity(project, HttpStatus.OK)
    }

    @PostMapping("/post")
    fun addProject(@RequestBody projectRequest: ProjectRequest) : ResponseEntity<Project>{
       val project = projectService.addProject(projectRequest)
       return ResponseEntity(project,HttpStatus.OK)
    }

    @DeleteMapping("/delete")
    fun deleteProjectId(@PathVariable id: Int){
        projectService.deleteProjectById(id)
    }

}
