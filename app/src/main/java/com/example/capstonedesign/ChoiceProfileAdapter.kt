package com.example.capstonedesign

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.list_choice.view.*

class ChoiceProfileAdapter(val choiceProfileList: ArrayList<ChoiceProfiles>) : RecyclerView.Adapter<ChoiceProfileAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChoiceProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_choice, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {

                val curPos : Int = adapterPosition
                val profile: ChoiceProfiles = choiceProfileList.get(curPos)
                Toast.makeText(parent.context, "약이름 : ${profile.choicename}\n", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onBindViewHolder(holder: ChoiceProfileAdapter.CustomViewHolder, position: Int) {
        holder.square_line.setImageResource(choiceProfileList.get(position).square_line)
        holder.choicename.text = choiceProfileList.get(position).choicename

        holder.itemView.btn_dt.setOnClickListener{
            val intent = Intent(holder.itemView?.context, AnalysisActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }

    }

    override fun getItemCount(): Int {
        return choiceProfileList.size

    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val square_line = itemView.findViewById<ImageView>(R.id.iv_line)
        val choicename = itemView.findViewById<TextView>(R.id.tv_pillname)//이름

    }
}

