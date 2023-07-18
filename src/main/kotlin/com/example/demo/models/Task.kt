package com.example.demo.models
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "Task")
data class Task(
        // use toast for feedback on adding
        // use stepper for first time users
        // use drawer for adding projects and chat
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val taskId: Long = 0,

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    val project: Project,

    @Column(nullable = false)
    val taskName: String,

    @Column(nullable = true)
    val description: String?,

    @ManyToOne
    @JoinColumn(name = "assignee_id", nullable = false)
    val assignee: User,

    @Column(nullable = true)
    val dueDate: LocalDate?,

    @Column(nullable = true)
    val status: String?,

    @Column(nullable = true)
    val priority: String?,

)
