package com.example.capstonedesign

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewHolder(view).apply {
            itemView.setOnClickListener {

                val curPos : Int = adapterPosition
                val profile: Profiles = profileList.get(curPos)
                Toast.makeText(parent.context, "약이름 : ${profile.name}\n", Toast.LENGTH_SHORT).show()


            }
        }
    }

    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.line.setImageResource(profileList.get(position).line)
        holder.name.text = profileList.get(position).name

    }

    override fun getItemCount(): Int {
        return profileList.size

    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val line = itemView.findViewById<ImageView>(R.id.iv_profile)//성별
        val name = itemView.findViewById<TextView>(R.id.tv_name)//이름
    }


}