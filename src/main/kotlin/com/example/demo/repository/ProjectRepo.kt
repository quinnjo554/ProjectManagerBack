package com.example.demo.repository

import com.example.demo.models.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProjectRepo : JpaRepository<Project, Int>
