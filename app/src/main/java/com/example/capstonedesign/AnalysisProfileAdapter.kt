package com.example.capstonedesign

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.capstonedesign.Model.Companion.multi_type1
import com.example.capstonedesign.Model.Companion.multi_type2

class AnalysisProfileAdapter (private val list: List<Model>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RecyclerView.ViewHolder {
        val view: View?
        return when (viewType) {
            multi_type1 -> {
                view = LayoutInflater.from(parent.context).inflate(
                        R.layout.list_analysis,
                        parent,
                        false
                )
                MultiViewHolder1(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context).inflate(
                        R.layout.list_analysis2,
                        parent,
                        false
                )
                MultiViewHolder2(view)
            }
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        Log.d("MultiViewTypeAdapter", "Hi, getItemViewType")
        return list[position].type
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (list[position].type) {
            multi_type1 -> { (holder as MultiViewHolder1).bind(list[position])
            }
            multi_type2 -> {(holder as MultiViewHolder2).bind(list[position])
            }
            else -> throw RuntimeException("알 수 없는 뷰 타입 에러")
        }
    }
    class MultiViewHolder1(view: View) : RecyclerView.ViewHolder(view) {

        val subject = itemView.findViewById<TextView>(R.id.tv_subject)
        val infor = itemView.findViewById<TextView>(R.id.tv_infor)//이름

        fun bind(item: Model) {
            subject.text = item.subject
            infor.text = item.infor
        }
    }
    class MultiViewHolder2(view: View) : RecyclerView.ViewHolder(view) {

        val subject = itemView.findViewById<TextView>(R.id.tv_subject)
        val infor = itemView.findViewById<TextView>(R.id.tv_infor)//이름

        fun bind(item: Model) {

            subject.text = item.subject
            infor.text = item.infor
        }
    }
}

