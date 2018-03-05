package br.com.leonardomiyagi.roomtasklist.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import br.com.leonardomiyagi.roomtasklist.R
import br.com.leonardomiyagi.roomtasklist.base.BaseActivity
import br.com.leonardomiyagi.roomtasklist.data.entity.TaskList
import br.com.leonardomiyagi.roomtasklist.databinding.ActivityMainBinding
import br.com.leonardomiyagi.roomtasklist.item.TaskListActivity
import br.com.leonardomiyagi.roomtasklist.main.adapter.TaskListAdapter

class MainActivity : BaseActivity(), TaskListAdapter.OnTaskListClicked {

    private lateinit var adapter: TaskListAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this,
                MainViewModel.MainViewModelFactory(getDatabase()?.taskListDAO()!!))
                .get(MainViewModel::class.java)
        setupView()
        setupRecyclerView()
        setupViewModel()
    }

    override fun onClick(taskList: TaskList) {
        TaskListActivity.start(this, taskList.name, taskList.id)
    }

    private fun setupView() {
        binding.addFab.setOnClickListener {
            viewModel.addTaskList()
        }
    }

    private fun setupRecyclerView() {
        adapter = TaskListAdapter(this)
        binding.taskListsRecyclerView.adapter = adapter
        binding.taskListsRecyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    private fun setupViewModel() {
        viewModel.taskLists.observe(this, Observer<List<TaskList>> {
            adapter.setTaskLists(it)
        })
    }
}
