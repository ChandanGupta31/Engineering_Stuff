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
import com.example.engineeringstuff.adapter.cheAdapter
import com.example.engineeringstuff.model.SubjectFireBase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class che(private val year : String?) : Fragment() {
    private lateinit var database : FirebaseFirestore
    private lateinit var recyclerView: RecyclerView
    private lateinit var data : ArrayList<SubjectFireBase>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_che, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.che_Recycler)
        database = Firebase.firestore
        data = arrayListOf()
        val che = database.collection("che")

        when(year){
            "1" -> che.document("NKL0ZtMqZutYvlhMfgfV").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = cheAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "2" -> che.document("Cl3kWfCiNVds2Zbo9Rfv").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = cheAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "3" -> che.document("6Tu4b1X4nHfk3LBgdgEA").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = cheAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "4" ->che.document("U8kONU2mIl6exx7E3zf7").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = cheAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
        }
    }
}