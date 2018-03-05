package br.com.leonardomiyagi.roomtasklist.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by lmiyagi on 05/03/18.
 */
@Entity(tableName = TaskList.TABLE,
        indices = [(Index(value = [(TaskList.COLUMN_ID)],
                name = TaskList.COLUMN_ID,
                unique = true))])
data class TaskList(var name: String? = null) {

    companion object {
        const val TABLE = "taskLists"
        const val COLUMN_ID = "id"
    }

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
    var createdAt: Date = Date()
}