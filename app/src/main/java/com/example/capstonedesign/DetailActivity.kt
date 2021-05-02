package com.example.capstonedesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<AnalysisProfileAdapter.CustomViewHolder>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.activity_detail, container, false)

        return view

    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        val AnalysisProfileList = arrayListOf(
            AnalysisProfiles("제조업체명", "제조업체명입니다"),
            AnalysisProfiles("효능효과", "효능효과입니다"),
            AnalysisProfiles("용법용량", "용법용량입니다"),
            AnalysisProfiles("주의사항", "주의사항입니다"),
            AnalysisProfiles("병용주의사항", "병용주의사항입니다"),
            AnalysisProfiles("부작용", "부작용입니다"),
            AnalysisProfiles("저장방법", "저장방법입니다")
        )
        rv_analysis.layoutManager = LinearLayoutManager(activity)
        rv_analysis.setHasFixedSize(true)

        rv_analysis.adapter = AnalysisProfileAdapter(AnalysisProfileList)

    }
}