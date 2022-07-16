package com.example.jira.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.jira.entities.Board
import com.example.jira.entities.Sprint
import com.example.jira.entities.Ticket
import com.example.jira.entities.User

data class BoardWithSprints(
    @Embedded
    val board: Board,
    @Relation(
        parentColumn = "id",
        entityColumn = "boardId"
    )
    val sprints: List<Sprint>
)