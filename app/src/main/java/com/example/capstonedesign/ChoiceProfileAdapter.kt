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
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.list_choice.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.file.Paths.get

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

        //레트로핏 객체 생성
        var retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:7000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //create을 통해 서비스를 올려줌
        var pillService = retrofit.create(PillService::class.java)

        holder.itemView.btn_dt.setOnClickListener{//상세정보 버튼 클릭

            var pillName = choiceProfileList.get(position).choicename.toString()

            pillService.requestPill(pillName).enqueue(object: Callback<Pill>{
                override fun onFailure(call: Call<Pill>, t: Throwable) {
                    //통신 실패 (인터넷 끊김, 시스템적 문제 발생)
                    Log.d("FAIL","onFailure: 통신 실패")
                }

                override fun onResponse(call: Call<Pill>, response: Response<Pill>) {
                    if(response.isSuccessful()){
                        //정상적으로 통신이 성공된 경우
                        Log.d("SUCCESS","onResponse: 성공")
                        var data=response.body()
                        val intent = Intent(holder.itemView?.context, AnalysisActivity::class.java)
                        intent.putExtra("pill", choiceProfileList.get(position).choicename)//약 이름
                        intent.putExtra("entpName", data?.entpName)//제조업체
                        intent.putExtra("itemImage",data?.itemImage)//알약 이미지
                        intent.putExtra("efficiency", data?.efficiency)//효능효과
                        intent.putExtra("useMethod", data?.useMethod)//용법용량
                        intent.putExtra("warning", data?.warning)//주의사항
                        intent.putExtra("intrcnt", data?.intrcnt)//병용주의사항
                        intent.putExtra("sideEffect", data?.sideEffect)//부작용
                        intent.putExtra("depositMethod", data?.depositMethod)//저장방법
                        ContextCompat.startActivity(holder.itemView.context, intent, null)
                    }

                    else{
                        //통신 실패한 경우(응답코드 3xx, 4xx 등)
                        Log.d("FAIL"," onResponse: 통신 실패")
                    }

                }

            })
//            val intent = Intent(holder.itemView?.context, AnalysisActivity::class.java)
//            intent.putExtra("pill", choiceProfileList.get(position).choicename)//약 이름
//            ContextCompat.startActivity(holder.itemView.context, intent, null)

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

