package com.example.jira.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.jira.entities.Ticket
import com.example.jira.entities.User

data class UserWithTickets(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val tickets: List<Ticket>
)