package com.example.capstonedesign

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_analysis.view.*
import kotlinx.android.synthetic.main.list_choice.view.*

class AnalysisProfileAdapter (val AnalysisProfileList: ArrayList<AnalysisProfiles>) : RecyclerView.Adapter<AnalysisProfileAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalysisProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_analysis, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {

                val curPos : Int = adapterPosition
                val profile: AnalysisProfiles = AnalysisProfileList.get(curPos)
                Toast.makeText(parent.context, "정보 : ${profile.infor}\n", Toast.LENGTH_SHORT).show()

            }
        }

    }

    override fun onBindViewHolder(holder: AnalysisProfileAdapter.CustomViewHolder, position: Int) {
        holder.subject.text = AnalysisProfileList.get(position).subject
        holder.infor.text = AnalysisProfileList.get(position).infor
    }

    override fun getItemCount(): Int {
        return AnalysisProfileList.size

    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val subject = itemView.findViewById<TextView>(R.id.tv_subject)
        val infor = itemView.findViewById<TextView>(R.id.tv_infor)//이름

    }
}

