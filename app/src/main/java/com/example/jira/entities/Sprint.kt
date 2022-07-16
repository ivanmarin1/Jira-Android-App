package com.example.jira.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity
data class Sprint(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val dateBegin: OffsetDateTime,
    val dateEnd: OffsetDateTime,
    val boardId: Int
)