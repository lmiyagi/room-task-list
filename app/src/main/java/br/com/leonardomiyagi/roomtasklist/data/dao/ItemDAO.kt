package br.com.leonardomiyagi.roomtasklist.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import br.com.leonardomiyagi.roomtasklist.data.entity.Item

/**
 * Created by lmiyagi on 05/03/18.
 */
@Dao
abstract class ItemDAO : DAO<Item>() {

    @Query("SELECT * FROM ${Item.TABLE} WHERE ${Item.COLUMN_TASK_LIST_ID} = :taskListId")
    abstract fun listAll(taskListId: Long): LiveData<List<Item>>
}