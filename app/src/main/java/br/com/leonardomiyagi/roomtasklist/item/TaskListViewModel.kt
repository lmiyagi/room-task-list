package br.com.leonardomiyagi.roomtasklist.item

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.os.AsyncTask
import br.com.leonardomiyagi.roomtasklist.data.dao.ItemDAO
import br.com.leonardomiyagi.roomtasklist.data.entity.Item
import java.util.*

/**
 * Created by lmiyagi on 05/03/18.
 */
class TaskListViewModel(private val taskListId: Long,
                        private val itemDAO: ItemDAO) : ViewModel() {

    lateinit var items: LiveData<List<Item>>

    init {
        getItems()
    }

    private fun getItems() {
        items = itemDAO.listAll(taskListId)
    }

    fun addItem() {
        val item = Item("Item ${Random().nextInt(999)}", taskListId)
        val insertItemAsyncTask = InsertItemAsyncTask(itemDAO)
        insertItemAsyncTask.execute(item)
    }

    class TaskListViewModelFactory(private val taskListId: Long,
                                   private val itemDAO: ItemDAO) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TaskListViewModel(taskListId, itemDAO) as T
        }
    }

    class InsertItemAsyncTask(private val itemDAO: ItemDAO) : AsyncTask<Item, Unit, Unit>() {

        override fun doInBackground(vararg item: Item?) {
            itemDAO.insert(item[0]!!)
        }
    }
}