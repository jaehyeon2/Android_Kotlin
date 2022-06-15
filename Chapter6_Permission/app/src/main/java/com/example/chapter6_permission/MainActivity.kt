package com.example.chapter6_permission

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.chapter6_permission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    lateinit var activityResult:ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        activityResult = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if (it){
                startProcess()
            }else{
                finish()
            }
        }
        binding.btnCamera.setOnClickListener{
            activityResult.launch(Manifest.permission.CAMERA)
        }
    }
    fun startProcess(){
        Toast.makeText(this, "run camera.", Toast.LENGTH_LONG).show()
    }


}