package com.example.jira.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jira.entities.Board
import com.example.jira.entities.Sprint
import com.example.jira.entities.Ticket
import com.example.jira.entities.User
import com.example.jira.entities.relations.BoardWithSprints
import com.example.jira.entities.relations.SprintWithTickets
import com.example.jira.entities.relations.UserWithTickets

@Dao
interface JiraDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTicket(ticket: Ticket)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSprint(sprint: Sprint)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBoard(board: Board)

    @Transaction
    @Query("SELECT * FROM user WHERE id = :userId")
    fun getUserWithTickets(userId: Int): LiveData<List<UserWithTickets>>

    @Transaction
    @Query("SELECT * FROM sprint WHERE id = :sprintId")
    fun getSprintWithTickets(sprintId: Int): LiveData<List<SprintWithTickets>>

    @Transaction
    @Query("SELECT * FROM board WHERE id = :boardId")
    fun getBoardWithSprints(boardId: Int): LiveData<List<BoardWithSprints>>

}