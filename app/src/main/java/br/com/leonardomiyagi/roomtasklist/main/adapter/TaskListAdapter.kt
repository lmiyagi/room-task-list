package br.com.leonardomiyagi.roomtasklist.main.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.leonardomiyagi.roomtasklist.R
import br.com.leonardomiyagi.roomtasklist.data.entity.TaskList
import br.com.leonardomiyagi.roomtasklist.databinding.ListItemTaskListBinding

/**
 * Created by lmiyagi on 05/03/18.
 */
class TaskListAdapter(private val listener: OnTaskListClicked) : RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>() {

    private val taskLists = ArrayList<TaskList>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TaskListViewHolder {
        return TaskListViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.list_item_task_list, parent, false))
    }

    override fun getItemCount(): Int = taskLists.size

    override fun onBindViewHolder(holder: TaskListViewHolder?, position: Int) {
        holder?.format(taskLists[position])
    }

    fun setTaskLists(taskLists: List<TaskList>?) {
        taskLists?.let {
            this.taskLists.clear()
            this.taskLists.addAll(it)
            notifyDataSetChanged()
        }
    }

    inner class TaskListViewHolder(private val binding: ListItemTaskListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun format(taskList: TaskList) {
            binding.taskList = taskList
            binding.taskListContainer.setOnClickListener { listener.onClick(taskList) }
        }
    }

    interface OnTaskListClicked {
        fun onClick(taskList: TaskList)
    }
}