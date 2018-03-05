package br.com.leonardomiyagi.roomtasklist.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import br.com.leonardomiyagi.roomtasklist.data.entity.TaskList

/**
 * Created by lmiyagi on 05/03/18.
 */
@Dao
abstract class TaskListDAO : DAO<TaskList>() {

    @Query("SELECT * FROM ${TaskList.TABLE} ORDER BY ${TaskList.COLUMN_ID}")
    abstract fun listAll(): LiveData<List<TaskList>>
}