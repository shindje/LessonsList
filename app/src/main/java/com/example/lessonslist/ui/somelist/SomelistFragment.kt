package com.example.lessonslist.ui.somelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lessonslist.R

class SomelistFragment : Fragment() {

    private lateinit var somelistViewModel: SomelistViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        somelistViewModel =
                ViewModelProvider(this).get(SomelistViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_somelist, container, false)
        val textView: TextView = root.findViewById(R.id.text_somelist)
        somelistViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}