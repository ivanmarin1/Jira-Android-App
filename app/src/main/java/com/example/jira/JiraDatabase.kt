package com.example.jira

import android.content.Context
import androidx.room.*
import com.example.jira.dao.JiraDao
import com.example.jira.entities.Board
import com.example.jira.entities.Sprint
import com.example.jira.entities.Ticket
import com.example.jira.entities.User

@Database(
    entities = [
        User::class,
        Ticket::class,
        Sprint::class,
        Board::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class JiraDatabase : RoomDatabase() {

    abstract val jiraDao: JiraDao

    companion object {
        @Volatile
        private var INSTANCE: JiraDatabase? = null

        fun getInstance(context: Context): JiraDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    JiraDatabase::class.java,
                    "jira_database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}