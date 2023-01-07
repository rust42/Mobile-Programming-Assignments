package edu.miu.cs473.quizapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import edu.miu.cs473.quizapp.entity.Answer
import edu.miu.cs473.quizapp.entity.Question

@Database(entities = [Question::class, Answer::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java,
            "Questions.db")
                .addCallback(seedDatabaseCallback(context))
                .allowMainThreadQueries()
                .build()

        private fun seedDatabaseCallback(context: Context): Callback {
            return  object: Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    ioThread {
                        val questionDao = getInstance(context).questionDao()
                        seedQuestions(questionDao)
                    }
                }
            }
        }
    }
}