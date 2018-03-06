package br.com.leonardomiyagi.roomtasklist.data.utils

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * Created by lmiyagi on 05/03/18.
 */
class DataTypeConverter {

    @TypeConverter
    fun toDate(time: Long?): Date? {
        return time?.let { Date(time) }
    }

    @TypeConverter
    fun toLong(date: Date?): Long? {
        return date?.let { date.time }
    }

    @TypeConverter
    fun toInteger(boolean: Boolean?): Int? {
        return boolean?.let {
            if (it) 1 else 0
        }
    }

    @TypeConverter
    fun toBoolean(integer: Int?): Boolean? {
        return integer?.let {
            it == 1
        }
    }
}