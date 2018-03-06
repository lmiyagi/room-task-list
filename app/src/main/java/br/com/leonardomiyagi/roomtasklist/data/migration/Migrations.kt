package br.com.leonardomiyagi.roomtasklist.data.migration

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration
import br.com.leonardomiyagi.roomtasklist.data.entity.Item

/**
 * Created by lmiyagi on 3/5/18.
 */
val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE ${Item.TABLE} ADD COLUMN ${Item.COLUMN_DONE} INTEGER NOT NULL DEFAULT '0'")
    }
}