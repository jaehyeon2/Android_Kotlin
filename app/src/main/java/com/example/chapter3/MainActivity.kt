package com.example.chapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import androidx.core.widget.addTextChangedListener
import com.example.chapter3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    val listener by lazy{
        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                when(buttonView.id){
                    R.id.checkApple -> Log.d("CheckBox", "apple checked")
                    R.id.checkBanana -> Log.d("CheckBox", "banana checked")
                    R.id.checkOrange -> Log.d("CheckBox", "orange checked")
                }
            }
            else{
                when(buttonView.id){
                    R.id.checkApple -> Log.d("CheckBox", "apple not checked")
                    R.id.checkBanana -> Log.d("CheckBox", "banana not checked")
                    R.id.checkOrange -> Log.d("CheckBox", "orange not checked")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val binding = ActivityMainBinding.inflate(layoutInflater)




        binding.editText.addTextChangedListener {
            if(it.toString().length>=8){
                Log.d("EditText", "현재 입력된 값=${it.toString()}")
            }
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId){
                R.id.radio_apple->Log.d("RadioButton", "apple select")
                R.id.radio_banana->Log.d("RadioButton", "banana select")
                R.id.radio_orange->Log.d("RadioButton", "orange select")
            }
        }

        binding.checkApple.setOnCheckedChangeListener (listener)
        binding.checkBanana.setOnCheckedChangeListener (listener)
        binding.checkOrange.setOnCheckedChangeListener (listener)




    }
}