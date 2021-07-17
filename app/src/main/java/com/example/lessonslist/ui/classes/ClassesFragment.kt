package com.example.lessonslist.ui.classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.getDrawable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonslist.R
import com.example.lessonslist.data.IRepository
import com.example.lessonslist.data.MockedRepository
import kotlinx.android.synthetic.main.fragment_classes.*

class ClassesFragment : Fragment() {

    private lateinit var classesViewModel: ClassesViewModel
    private lateinit var repository: IRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository = MockedRepository()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        classesViewModel =
                ViewModelProvider(this).get(ClassesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_classes, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_classes_vertical.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        val adapter = RVClassesAdapterV(
                repository.getClassesAndFaculties(),
                getColor(requireContext(), R.color.purple_500),
                getDrawable(requireContext(), R.drawable.color_green_gradient)
        )
        rv_classes_vertical.adapter = adapter
    }
}