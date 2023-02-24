package com.example.engineeringstuff.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.engineeringstuff.R
import com.example.engineeringstuff.adapter.cseAdapter
import com.example.engineeringstuff.data.subjectsName
import com.example.engineeringstuff.model.Subjects

class che(private val year : String?) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_che, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView : RecyclerView = view.findViewById(R.id.che_Recycler)
        val data : List<Subjects> = when(year) {
            "1" -> subjectsName().Year1().cheSubjects()
            "2" -> subjectsName().Year2().cheSubjects()
            "3" -> subjectsName().Year3().cheSubjects()
            else -> subjectsName().Year4().cheSubjects()
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = cseAdapter(view.context ,data)
        }
    }
}