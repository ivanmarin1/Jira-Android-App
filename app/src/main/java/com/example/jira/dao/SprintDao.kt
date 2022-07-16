package com.example.jira.dao

import androidx.room.*
import com.example.jira.entities.Sprint
import com.example.jira.entities.Ticket
import com.example.jira.entities.relations.SprintWithTickets
import com.example.jira.entities.relations.UserWithTickets

@Dao
interface SprintDao {
}