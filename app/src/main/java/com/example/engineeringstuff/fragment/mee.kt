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
import com.example.engineeringstuff.adapter.meeAdapter
import com.example.engineeringstuff.model.SubjectFireBase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class mee(private val year : String?) : Fragment() {
    private lateinit var database : FirebaseFirestore
    private lateinit var recyclerView: RecyclerView
    private lateinit var data : ArrayList<SubjectFireBase>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mee, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.mee_Recycler)
        database = Firebase.firestore
        data = arrayListOf()
        val mee = database.collection("mee")

        when(year){
            "1" -> mee.document("ttlTJ36zDNnaKyMJsM9f").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = meeAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "2" -> mee.document("H147I6ncxUIhh2Pr7NCx").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = meeAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "3" -> mee.document("lYcpUuiq94qNWBopiSDg").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = meeAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
            "4" ->mee.document("OW3GdomXO1A5zkEuWGdG").collection("subjects")
                .get().addOnSuccessListener {result ->
                    for( document in result){
                        data.add(SubjectFireBase(document.data["name"].toString(), document.data["link"].toString()))
                    }
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = meeAdapter(view.context ,data)
                    }
                }.addOnFailureListener {
                    Toast.makeText(context, "Unable to Load Data", Toast.LENGTH_LONG).show()
                }
        }
    }
}