package com.example.capstonedesign

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.AnalogClock
import android.widget.Toast
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.example.capstonedesign.databinding.ActivityHomeBinding
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

private const val REQUEST_CODE_FOR_IMAGE_CAPTURE = 100
private const val TAG = "HomeActivity"

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var photoFile: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(packageManager) != null) {
                //val dir = getExternalFilesDir(Environment.DIRECTORY_PICTURES) // photos will be deleted when the app is uninstalled
                val dir = externalCacheDir // photo can be deleted when the app is terminated
                val file = File.createTempFile("photo_", ".jpg", dir)
                val uri = FileProvider.getUriForFile(this, "$packageName.provider", file)
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
                startActivityForResult(intent, REQUEST_CODE_FOR_IMAGE_CAPTURE)
                photoFile = file
            }
        }
        if (intent.hasExtra("msg")){
            tv_user.text = intent.getStringExtra("msg")
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
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            // result.contents에는 스캔한 결과가 포함된다. 만약 null이라면 사용자가 스캔을 완료하지 않고 QR 리더 액티비티를 종료한 것이다.
            if (result.contents != null) {
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
//                image.setImageBitmap(bitmap)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
            when (requestCode) {
                REQUEST_CODE_FOR_IMAGE_CAPTURE -> {
                    if (resultCode == RESULT_OK) {
//                    BitmapFactory.decodeFile(photoFile.absolutePath)?.let {
//                        binding.image.setImageBitmap(it)
//                    }
//                        Glide.with(this).load(photoFile)
//                            .into(binding.image) // call .centerCrop() .circleCrop() before .into()
                    } else {
                        Toast.makeText(this, "취소 되었습니다", Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }
}