package br.com.leonardomiyagi.roomtasklist.data.dao

import android.arch.persistence.room.*

/**
 * Created by lmiyagi on 05/03/18.
 */
@Dao
abstract class DAO<T> {

    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    abstract fun insert(t: T)

    @Update(onConflict = OnConflictStrategy.ROLLBACK)
    abstract fun update(t: T)

    @Delete
    abstract fun delete(t: T)
}