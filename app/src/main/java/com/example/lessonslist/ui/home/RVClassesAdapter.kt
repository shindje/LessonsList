package com.example.lessonslist.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonslist.R
import com.example.lessonslist.data.model.Class
import kotlinx.android.synthetic.main.rv_class_item_horizontal.view.*

class RVClassesAdapter (private val classes: List<Class>) : RecyclerView.Adapter<RVClassesAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(cl: Class) {
            itemView.apply {
                class_item_hor_name.text = cl.name
                class_item_hor_time.text = "${cl.startHour}:${cl.startMinute} - ${cl.endHour}:${cl.endMinute}"
                class_item_hor_icon.setImageResource(cl.icon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_class_item_horizontal, parent, false))

    override fun getItemCount(): Int = classes.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val cl = classes[position]
        holder.bind(cl)
    }
}