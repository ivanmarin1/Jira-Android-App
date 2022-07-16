package com.example.jira.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.jira.entities.Sprint
import com.example.jira.entities.Ticket
import com.example.jira.entities.User

data class SprintWithTickets(
    @Embedded
    val sprint: Sprint,
    @Relation(
        parentColumn = "id",
        entityColumn = "sprintId"
    )
    val tickets: List<Ticket>
)