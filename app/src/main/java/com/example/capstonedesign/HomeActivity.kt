package com.example.capstonedesign

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.AnalogClock
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.example.capstonedesign.databinding.ActivityHomeBinding
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import kotlinx.android.synthetic.main.activity_camera.*
import kotlinx.android.synthetic.main.activity_choice.*
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.*
import java.util.Objects.toString
import kotlin.concurrent.schedule

class HomeActivity : AppCompatActivity() {
    private val TAG = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (intent.hasExtra("username")){
            tv_user.text = intent.getStringExtra("username")
        }

        btn_camera.setOnClickListener {
            onCameraButtonClicked()
        }
        btn_qrscan.setOnClickListener {
            val integrator = IntentIntegrator(this)
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE) // 특정 규격의 바코드만 지원
            integrator.setPrompt("QR 코드를 스캔하여 주세요") // 카메라 프리뷰 하단에 표시되는 문구
            integrator.setCameraId(0) // 0 후면카메라, 1 전면카메라
            integrator.setBeepEnabled(true) // 바코드 인식할 때 비프음 여부
            integrator.setBarcodeImageEnabled(true) // 인식한 바코드 사진을 저장하고 경로를 반환
            integrator.setOrientationLocked(false) // orientation이 fullSensor일 때 orientation 변경을 허용할지 여부
            integrator.initiateScan()
        }
        btn_choice.setOnClickListener {
            val intent = Intent(this, ChoiceActivity::class.java)
            intent.putExtra("msg",tv_choice.text.toString())
            startActivity(intent)
        }
        btn_my.setOnClickListener {
            val intent = Intent(this, MyActivity::class.java)
            intent.putExtra("msg",tv_my.text.toString())
            startActivity(intent)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        var retrofit = Retrofit.Builder()
            .baseUrl("http://13.209.10.103/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var qrService = retrofit.create(QrService::class.java)

        val call : Call<Qr> = qrService.requestQr("result.contents")

        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            // result.contents에는 스캔한 결과가 포함된다. 만약 null이라면 사용자가 스캔을 완료하지 않고 QR 리더 액티비티를 종료한 것이다.
            if (result.contents != null) {
                call.enqueue(object : Callback<Qr>{
                    override fun onFailure(call : Call<Qr>,t:Throwable){
                        Log.d("qrTest","error:(${t.message}")
                    }
                    override fun onResponse(call: Call<Qr>,response: Response<Qr>){
                        Log.d("qrTest", "Success: "+"${response.isSuccessful()}")

                    }
                })
                Toast.makeText(
                    this,
                    "Scanned: ${result.contents} ${result.formatName}",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            }
            if (result.barcodeImagePath != null) {
                Log.i(TAG, "onActivityResult: ${result.barcodeImagePath}")
                val bitmap = BitmapFactory.decodeFile(result.barcodeImagePath)
                image.setImageBitmap(bitmap)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)

        }
    }
    fun onCameraButtonClicked() {
        Log.d("", "HomeActivity-onButtonClicked() called")

        val intent = Intent(this, CameraActivity::class.java)
        startActivity(intent)
    }
}