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
import com.example.engineeringstuff.adapter.aiAdapter
import com.example.engineeringstuff.model.SubjectFireBase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ai(private val year : String?) : Fragment() {
    private lateinit var database : FirebaseFirestore
    private lateinit var recyclerView: RecyclerView
    private lateinit var data : ArrayList<SubjectFireBase>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ai, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.ai_Recycler)
        database = Firebase.firestore
        data = arrayListOf()
        val ai = database.collection("ai")

        when(year){
            "1" -> ai.document("mMp21nTp7Ff2EybNrpaH").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = aiAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "2" -> ai.document("hnWkXTfC1j0ZVQdOtOlg").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = aiAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "3" -> ai.document("Lolg9Z9cjsQV8uRdJaKx").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = aiAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "4" ->ai.document("UD1fIjHzfMWWemS0ZjHm").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = aiAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
        }
    }
}