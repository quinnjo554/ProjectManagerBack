package com.example.demo.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class TaskLabel(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @ManyToOne
        @JoinColumn(name = "task_id", nullable = false)
        val task: Task,

        @ManyToOne
        @JoinColumn(name = "label_id", nullable = false)
        val label: Label,

        // Add more fields and relationships as needed
)
