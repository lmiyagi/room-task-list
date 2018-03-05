package br.com.leonardomiyagi.roomtasklist.item.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.leonardomiyagi.roomtasklist.R
import br.com.leonardomiyagi.roomtasklist.data.entity.Item
import br.com.leonardomiyagi.roomtasklist.databinding.ListItemTaskItemBinding

/**
 * Created by lmiyagi on 05/03/18.
 */
class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val items = ArrayList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        return ItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.list_item_task_item, parent, false))
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        holder?.format(items[position])
    }

    fun setItems(items: List<Item>?) {
        items?.let {
            this.items.clear()
            this.items.addAll(items)
            notifyDataSetChanged()
        }
    }

    inner class ItemViewHolder(private val binding: ListItemTaskItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun format(item: Item) {
            binding.item = item
        }
    }
}