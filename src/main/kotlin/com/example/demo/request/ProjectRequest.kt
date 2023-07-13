package com.example.demo.request

import java.time.LocalDate

data class ProjectRequest(
        val projectName: String,
        val description: String?,
        val startDate: LocalDate,
        val endDate: LocalDate?,
)
