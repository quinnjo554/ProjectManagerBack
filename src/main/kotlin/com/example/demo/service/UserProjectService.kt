package com.example.demo.service

import com.example.demo.models.Project
import com.example.demo.models.UserProject
import com.example.demo.repository.ProjectRepo
import com.example.demo.repository.UserProjRepo
import com.example.demo.repository.UserRepo
import com.example.demo.request.UserProjectRequest
import org.springframework.stereotype.Service

@Service
class UserProjectService(private val userRepo: UserRepo, private val projectRepo: ProjectRepo, private val userProjRepo: UserProjRepo) {
    fun addProjectToUser(userProjectRequest: UserProjectRequest): UserProject {
        val user = userRepo.findById(userProjectRequest.userId).orElseThrow { Exception() }
        val project = projectRepo.findById(userProjectRequest.projectId).orElseThrow { Exception() }
        val userProj = UserProject(0, user, project)
        return userProjRepo.save(userProj)
    }

   fun getAllProjForUser(userId: Int): List<Project> {
       val user = userRepo.findById(userId).orElseThrow { Exception("bad") }
       return userProjRepo.findByUser(user).map { it.project }
   }
}
