package br.com.leonardomiyagi.roomtasklist.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import br.com.leonardomiyagi.roomtasklist.data.dao.TaskListDAO
import br.com.leonardomiyagi.roomtasklist.data.entity.Item
import br.com.leonardomiyagi.roomtasklist.data.entity.TaskList
import br.com.leonardomiyagi.roomtasklist.data.utils.DataTypeConverter

/**
 * Created by lmiyagi on 05/03/18.
 */
@Database(entities = [(TaskList::class), (Item::class)],
        version = 1, exportSchema = false)
@TypeConverters(DataTypeConverter::class)
abstract class DefaultRoomDatabase : RoomDatabase() {

    abstract fun taskListDAO(): TaskListDAO
}