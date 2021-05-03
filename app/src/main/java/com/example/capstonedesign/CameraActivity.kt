package com.example.capstonedesign

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import com.example.capstonedesign.databinding.ActivityCameraBinding
import kotlinx.android.synthetic.main.activity_camera.*
import java.io.File

private const val REQUEST_CODE_FOR_IMAGE_CAPTURE = 100
private const val TAG = "CameraActivity"

class CameraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCameraBinding
    private lateinit var photoFile: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnBack14.setOnClickListener {
            onBtnBackClicked()
        }
        btn_medicine.setOnClickListener {
            onMedicineButtonClicked()
        }

        binding.camera.setOnClickListener {
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
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE_FOR_IMAGE_CAPTURE -> {
                if (resultCode == RESULT_OK) {
                    BitmapFactory.decodeFile(photoFile.absolutePath)?.let {
                        binding.image.setImageBitmap(it)
                    }
                    Glide.with(this).load(photoFile).into(binding.image) // call .centerCrop() .circleCrop() before .into()
                } else {
                    Toast.makeText(this, "취소 되었습니다", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    fun onBtnBackClicked(){
        Log.d("", "CameraActivity-onBtnBackClicked() called")

        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
    fun onMedicineButtonClicked() {
        Log.d("", "CameraActivity-onButtonClicked() called")

        val intent = Intent(this, AnalysisActivity::class.java)
        startActivity(intent)
    }
}