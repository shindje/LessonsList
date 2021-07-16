package com.example.lessonslist.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lessonslist.R
import com.example.lessonslist.data.IRepository
import com.example.lessonslist.data.MockedRepository
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var adapter: RVClassesAdapter
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
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.days_text.observe(viewLifecycleOwner, Observer { tv_timer_days.text = it })
        homeViewModel.hours_text.observe(viewLifecycleOwner, Observer { tv_timer_hours.text = it })
        homeViewModel.minutes_text.observe(viewLifecycleOwner, Observer { tv_timer_minutes.text = it })

        rv_classes_horizontal.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        var classes = repository.getClasses()
        adapter = RVClassesAdapter(classes)
        rv_classes_horizontal.adapter = adapter
        val currentClassIndex = repository.getCurrentClassIndex()
        if (currentClassIndex > - 1)
            rv_classes_horizontal.scrollToPosition(currentClassIndex)
        tv_classes_today.text = "${classes.size} classes today"

        rv_homeworks.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        var homeworks = repository.getHomeworks()
        var adapterHW = RVHomeworksAdapter(homeworks)
        rv_homeworks.adapter = adapterHW

    }
}