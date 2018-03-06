package br.com.leonardomiyagi.roomtasklist.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by lmiyagi on 05/03/18.
 */
@Entity(tableName = Item.TABLE,
        indices = [(Index(value = [(Item.COLUMN_TASK_LIST_ID)],
                name = Item.COLUMN_TASK_LIST_ID))],
        foreignKeys = [(ForeignKey(entity = TaskList::class,
                parentColumns = [(TaskList.COLUMN_ID)],
                childColumns = [(Item.COLUMN_TASK_LIST_ID)],
                onDelete = ForeignKey.CASCADE))])
data class Item(var value: String? = null,
                var taskListId: Long) {

    companion object {
        const val TABLE = "items"
        const val COLUMN_TASK_LIST_ID = "taskListId"
        const val COLUMN_DONE = "done"
    }

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
    var createdAt: Date = Date()
    var done: Boolean = false
}