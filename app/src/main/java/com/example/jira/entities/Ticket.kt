package com.example.jira.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ticket(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val priority: Int,
    val type: Int,
    val userId: Int,
    val sprintId: Int
)