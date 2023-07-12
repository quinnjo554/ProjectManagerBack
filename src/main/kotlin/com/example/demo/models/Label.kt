package com.example.demo.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "label")
data class Label(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val labelId: Long = 0,

    @Column(nullable = false)
    val labelName: String,

    // Add more fields and relationships as needed
)
