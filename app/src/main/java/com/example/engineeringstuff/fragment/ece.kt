package com.example.engineeringstuff.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.engineeringstuff.R
import com.example.engineeringstuff.adapter.eceAdapter
import com.example.engineeringstuff.model.SubjectFireBase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



class ece(private val year : String?) : Fragment() {
    private lateinit var database : FirebaseFirestore
    private lateinit var recyclerView: RecyclerView
    private lateinit var data : ArrayList<SubjectFireBase>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ece, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.ece_Recycler)
        database = Firebase.firestore
        val ece = database.collection("ece")

        data = arrayListOf()

        when(year){
            "1" -> ece.document("gQ12mrR8RySuKbzgL1zA").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = eceAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "2" -> ece.document("E9QpqkTp6DyKAGT0RcXn").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = eceAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "3" -> ece.document("eUDmFvPytaWtSo7Q9Wer").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = eceAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "4" ->ece.document("f0DRKEItU1DLyJhv74QU").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = eceAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
        }
    }
}