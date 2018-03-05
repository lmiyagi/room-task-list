package br.com.leonardomiyagi.roomtasklist.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.AsyncTask
import br.com.leonardomiyagi.roomtasklist.data.dao.TaskListDAO
import br.com.leonardomiyagi.roomtasklist.data.entity.TaskList
import java.util.*

/**
 * Created by lmiyagi on 05/03/18.
 */
class MainViewModel(private val taskListDAO: TaskListDAO) : ViewModel() {

    lateinit var taskLists: LiveData<List<TaskList>>

    init {
        getTaskLists()
    }

    private fun getTaskLists() {
        taskLists = taskListDAO.listAll()
    }

    fun addTaskList() {
        val taskList = TaskList("Teste ${Random().nextInt(999)}")
        val insertAsyncTask = InsertAsyncTask(taskListDAO)
        insertAsyncTask.execute(taskList)
    }

    class MainViewModelFactory(private val taskListDAO: TaskListDAO) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(taskListDAO) as T
        }
    }

    class InsertAsyncTask(private val taskListDAO: TaskListDAO) : AsyncTask<TaskList, Unit, Unit>() {

        override fun doInBackground(vararg taskList: TaskList?) {
            taskListDAO.insert(taskList[0]!!)
        }
    }
}