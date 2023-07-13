package com.example.demo.service

import com.example.demo.models.Project
import com.example.demo.repository.ProjectRepo
import com.example.demo.request.ProjectRequest
import org.springframework.stereotype.Service

@Service
class ProjectService(private val projectRepo: ProjectRepo) {
    fun getProjectById(id: Int): Project {
        return projectRepo.findById(id).orElseThrow { Exception() }
    }
    fun addProject(projectRequest: ProjectRequest): Project {
       val project = Project(0, projectRequest.projectName, projectRequest.description, projectRequest.startDate, projectRequest.endDate)
        return projectRepo.save(project)
    }

    fun deleteProjectById(id: Int) {
        if (projectRepo.findById(id) != null) {
             return projectRepo.deleteById(id)
        } else {
            throw Exception()
        }
    }
}
