package com.example.android.hackathontodolist

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by Hesham on 2/10/2018.
 */
class ListAdaptor(private val context:Context): RecyclerView.Adapter<ListAdaptor.ListViewHolder>() {

    private var tasks: List<ToDoListItem> = ArrayList()

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val task = tasks[position]
        holder.priorityTextView.text = task.priority.toString()
        holder.tasktitle.text = task.name
        holder.taskDescription.text = task.description
        holder.dateTextView.text = task.date
        holder.timeTextView.text = task.time.toString()


    }
    class ListViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val priorityTextView = itemView.priorityTextView
        val tasktitle = itemView.tasktitle
        val taskDescription = itemView.taskDescription
        val dateTextView = itemView.dateTextView
        val timeTextView = itemView.timeTextView

    }
}