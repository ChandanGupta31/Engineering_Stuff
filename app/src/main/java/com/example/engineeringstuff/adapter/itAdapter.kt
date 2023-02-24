package com.example.engineeringstuff.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.engineeringstuff.PDFviewer
import com.example.engineeringstuff.R
import com.example.engineeringstuff.model.Subjects

class itAdapter(private val context: Context, private val subjects: List<Subjects>) : RecyclerView.Adapter<itAdapter.itViewHolder>() {

    class itViewHolder( view : View) : RecyclerView.ViewHolder(view){
        var textView : TextView = itemView.findViewById(R.id.subjectItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itViewHolder {
        val layoutAdapter = LayoutInflater.from(parent.context).inflate(R.layout.subject_item,parent,false)
        return itViewHolder(layoutAdapter)
    }

    override fun getItemCount(): Int {
        return subjects.size
    }

    override fun onBindViewHolder(holder: itViewHolder, position: Int) {
        val item = subjects[position]
        holder.textView.text = context.resources.getString(item.subjectName)

        holder.textView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PDFviewer::class.java)
            intent.putExtra("url",context.resources.getString(item.url))
            holder.itemView.context.startActivity(intent)
        }
    }
}