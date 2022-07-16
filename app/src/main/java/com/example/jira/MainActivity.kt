package com.example.jira

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.jira.entities.Board
import com.example.jira.entities.Sprint
import com.example.jira.entities.Ticket
import com.example.jira.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.OffsetDateTime
import java.time.ZoneOffset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = JiraDatabase.getInstance(this).jiraDao

        val users = listOf<User>(
            User(0, "Ivan", "Marin"),
            User(1, "Ante", "Antic"),
            User(2, "Mate", "Matic"),
            User(3, "Luka", "Lukic"),
            User(4, "Stipe", "Stipic")
        )

        val tickets = listOf(
            Ticket(0, "Delete user", "", 1, 1, 0, 0),
            Ticket(1, "Add new user", "", 1, 0, 2, 0),
            Ticket(2, "Modify procedure", "", 0, 1, 3, 0),
            Ticket(3, "Read ISO standard", "", 0, 0, 1, 0),
            Ticket(4, "Add different roles for users", "", 3, 0, 3, 1),
            Ticket(5, "Experiment with different boards", "", 1, 1, 1, 1),
            Ticket(6, "Read about cryptography", "", 0, 2, 4, 1),
        )

        val sprints = listOf(
            Sprint(
                0,
                "Sprint 1",
                OffsetDateTime.now(),
                OffsetDateTime.of(2022, 8, 16, 14, 0, 0, 0, ZoneOffset.ofHours(0)),
                0
            ),
            Sprint(
                1,
                "Sprint 2",
                OffsetDateTime.of(2022, 8, 16, 14, 0, 0, 0, ZoneOffset.ofHours(0)),
                OffsetDateTime.of(2022, 8, 31, 14, 0, 0, 0, ZoneOffset.ofHours(0)),
                0
            )
        )

        val boards = listOf(
            Board(0, "Board 1"),
            Board(1, "Board 2")
        )

        lifecycleScope.launch(Dispatchers.IO) {
            users.forEach { dao.insertUser(it) }
            tickets.forEach { dao.insertTicket(it) }
            sprints.forEach { dao.insertSprint(it) }
            boards.forEach { dao.insertBoard(it) }

            val userWithTickets = dao.getUserWithTickets(0)
            val sprintWithTickets = dao.getSprintWithTickets(0)
            val boardWithSprints = dao.getBoardWithSprints(0)
        }

    }
}