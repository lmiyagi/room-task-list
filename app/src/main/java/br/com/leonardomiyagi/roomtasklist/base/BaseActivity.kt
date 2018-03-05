package br.com.leonardomiyagi.roomtasklist.base

import android.support.v7.app.AppCompatActivity
import br.com.leonardomiyagi.roomtasklist.BaseApplication
import br.com.leonardomiyagi.roomtasklist.data.DefaultRoomDatabase

/**
 * Created by lmiyagi on 05/03/18.
 */
open class BaseActivity : AppCompatActivity() {

    protected fun getDatabase(): DefaultRoomDatabase? {
        return (application as BaseApplication).database
    }
}