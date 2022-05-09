package com.example.chapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.SeekBar
import androidx.core.widget.addTextChangedListener
import com.example.chapter3.databinding.ActivityMainBinding
import com.example.chapter3.databinding.ProgressbarBinding
import com.example.chapter3.databinding.RatingbarBinding
import com.example.chapter3.databinding.SeekbarBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    val bindingprogress by lazy {ProgressbarBinding.inflate(layoutInflater)}

    val bindingseekbar by lazy {SeekbarBinding.inflate(layoutInflater)}

    val bindingratingbar by lazy {RatingbarBinding.inflate(layoutInflater)}

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
//        setContentView(binding.root)
//        setContentView(bindingprogress.root)

//        setContentView(bindingseekbar.root)
//        bindingseekbar.seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
//            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
//                bindingseekbar.textView.text="$progress"
//                //TODO("Not yet implemented")
//            }
//
//            override fun onStartTrackingTouch(p0: SeekBar?) {
//                //TODO("Not yet implemented")
//            }
//
//            override fun onStopTrackingTouch(p0: SeekBar?) {
//                //TODO("Not yet implemented")
//            }
//        })

        setContentView(bindingratingbar.root)
        bindingratingbar.ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            bindingratingbar.textView.text="$rating"
        }

        thread(start=true){
            Thread.sleep(3000)
            runOnUiThread{
                showProgress(false)
            }
        }
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

    fun showProgress(show:Boolean){
        if(show){
            bindingprogress.progressLayout.visibility= View.VISIBLE
        }
        else{
            bindingprogress.progressLayout.visibility=View.GONE
        }
        //bindingprogress.progressLayout.visibility = if(show) View.VISIBLE else View.GONE
    }
}