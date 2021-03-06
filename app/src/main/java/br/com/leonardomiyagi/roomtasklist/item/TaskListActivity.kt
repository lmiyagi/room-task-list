package br.com.leonardomiyagi.roomtasklist.item

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.InputType
import android.view.MenuItem
import br.com.leonardomiyagi.roomtasklist.R
import br.com.leonardomiyagi.roomtasklist.base.BaseActivity
import br.com.leonardomiyagi.roomtasklist.data.entity.Item
import br.com.leonardomiyagi.roomtasklist.databinding.ActivityTaskListBinding
import br.com.leonardomiyagi.roomtasklist.item.adapter.ItemAdapter
import com.afollestad.materialdialogs.MaterialDialog

class TaskListActivity : BaseActivity() {

    companion object {
        const val EXTRA_TASK_LIST_ID = "EXTRA_TASK_LIST_ID"
        const val EXTRA_TASK_LIST_NAME = "EXTRA_TASK_LIST_NAME"

        fun start(context: Context, taskListName: String?, taskListId: Long?) {
            val intent = Intent(context, TaskListActivity::class.java)
            intent.putExtra(EXTRA_TASK_LIST_ID, taskListId)
            intent.putExtra(EXTRA_TASK_LIST_NAME, taskListName)
            context.startActivity(intent)
        }
    }

    private lateinit var adapter: ItemAdapter
    private lateinit var viewModel: TaskListViewModel
    private lateinit var binding: ActivityTaskListBinding

    private var taskListId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_task_list)
        taskListId = intent.getLongExtra(EXTRA_TASK_LIST_ID, -1)
        viewModel = ViewModelProviders.of(this,
                TaskListViewModel.TaskListViewModelFactory(taskListId,
                        getDatabase()?.itemDAO()!!)).get(TaskListViewModel::class.java)
        setupView()
        setupRecyclerView()
        setupViewModel()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupView() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = intent.getStringExtra(EXTRA_TASK_LIST_NAME)
        binding.addFab.setOnClickListener {
            MaterialDialog.Builder(this)
                    .title(R.string.task_list_new_item)
                    .inputType(InputType.TYPE_CLASS_TEXT)
                    .input(getString(R.string.task_list_new_item_name_hint),
                            null,
                            false, { _, input ->
                        viewModel.addItem(Item(input.toString(), taskListId))
                    }).show()
        }
    }

    private fun setupRecyclerView() {
        adapter = ItemAdapter()
        binding.itemsRecyclerView.adapter = adapter
        binding.itemsRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setupViewModel() {
        viewModel.items.observe(this, Observer<List<Item>> {
            adapter.setItems(it)
        })
    }
}
