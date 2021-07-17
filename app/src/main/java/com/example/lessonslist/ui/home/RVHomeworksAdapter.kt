package com.example.lessonslist.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonslist.R
import com.example.lessonslist.data.model.Homework
import kotlinx.android.synthetic.main.rv_homework_item.view.*
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.util.*

class RVHomeworksAdapter (private val homeworks: List<Homework>) : RecyclerView.Adapter<RVHomeworksAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(h: Homework) {
            itemView.apply {
                item_homework_name.text = h.name

                val curDate = LocalDate.now();
                val deadline = h.deadline.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                val period = Period.between(curDate, deadline)
                item_homework_deadline.text = "${period.days} days left"

                item_howework_task.text = h.task
                item_homework_icon.setImageResource(h.icon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_homework_item, parent, false))

    override fun getItemCount(): Int = homeworks.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val cl = homeworks[position]
        holder.bind(cl)
    }
}