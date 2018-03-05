package br.com.leonardomiyagi.roomtasklist.data.dao

import android.arch.persistence.room.Dao
import br.com.leonardomiyagi.roomtasklist.data.entity.Item

/**
 * Created by lmiyagi on 05/03/18.
 */
@Dao
abstract class ItemDAO : DAO<Item>() {
}