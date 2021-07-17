package com.example.lessonslist.ui.classes

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonslist.R
import com.example.lessonslist.data.model.Class
import kotlinx.android.synthetic.main.rv_class_item_vertical.view.*

class RVClassesAdapterV (private val classes: List<Class>, private val classColor: Int, private val facultyColor: Drawable?)
    : RecyclerView.Adapter<RVClassesAdapterV.DataViewHolder>() {

    class DataViewHolder(itemView: View, val classColor: Int, val facultyColor: Drawable?) : RecyclerView.ViewHolder(itemView) {

        fun bind(cl: Class) {
            itemView.apply {
                class_item_v_time.text = "${cl.startHour}:${cl.startMinute} - ${cl.endHour}:${cl.endMinute}"
                class_item_v_name.text = cl.name
                class_item_v_teacher.text = "Teacher: ${cl.teacher}"
                class_item_v_text.text = cl.text
                class_item_v_icon.setImageResource(cl.icon)
                class_item_v_text.isVisible = cl.isFaculty
                if (cl.isFaculty) {
                    facultyColor?.apply { class_item_layout_in.setBackground(this) }
                } else
                    class_item_card.setCardBackgroundColor(classColor)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
            DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_class_item_vertical, parent, false), classColor, facultyColor)

    override fun getItemCount(): Int = classes.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val cl = classes[position]
        holder.bind(cl)
    }
}