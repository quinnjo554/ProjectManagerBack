package com.example.demo.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "app_user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id")
        var userId: Int = 0,

        @Column(name = "username")
        var userName: String = "",

        @Column(name = "email")
        var email: String = "",

        @Column(name = "password")
        var password: String = "",
)
