package br.com.leonardomiyagi.roomtasklist

import android.app.Application
import android.arch.persistence.room.Room
import br.com.leonardomiyagi.roomtasklist.data.DefaultRoomDatabase
import br.com.leonardomiyagi.roomtasklist.data.migration.MIGRATION_1_2


/**
 * Created by lmiyagi on 05/03/18.
 */
class BaseApplication : Application() {

    var database: DefaultRoomDatabase? = null

    override fun onCreate() {
        super.onCreate()
        setupRoom()
    }

    private fun setupRoom() {
        database = Room.databaseBuilder(applicationContext,
                DefaultRoomDatabase::class.java, "task-list-db")
                .addMigrations(MIGRATION_1_2)
                .build()
    }
}