package com.example.demo.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "project")
data class Project(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val projectId: Long = 0,

    @Column(nullable = false)
    val projectName: String,

    @Column(nullable = true)
    val description: String?,

    @Column(nullable = false)
    val startDate: LocalDate,

    @Column(nullable = true)
    val endDate: LocalDate?,

    // Add more fields and relationships as needed
)
