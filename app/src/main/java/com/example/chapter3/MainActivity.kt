package com.example.chapter3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import android.widget.SeekBar
import androidx.core.widget.addTextChangedListener
import com.example.chapter3.databinding.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

//    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
//
//    val bindingprogress by lazy {ProgressbarBinding.inflate(layoutInflater)}
//
//    val bindingseekbar by lazy {SeekbarBinding.inflate(layoutInflater)}
//
//    val bindingratingbar by lazy {RatingbarBinding.inflate(layoutInflater)}

    //quiz4_2_1
//    val bindingquiz421 by lazy {Quiz421Binding.inflate(layoutInflater)}
    //quiz4_2_2
//    val bindingquiz422 by lazy {Quiz422Binding.inflate(layoutInflater)}
    //quiz4_2_3
    val bindingquiz423 by lazy {Quiz423Binding.inflate(layoutInflater)}

//    val listener by lazy{
//        CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
//            if (isChecked){
//                when(buttonView.id){
//                    R.id.checkApple -> Log.d("CheckBox", "apple checked")
//                    R.id.checkBanana -> Log.d("CheckBox", "banana checked")
//                    R.id.checkOrange -> Log.d("CheckBox", "orange checked")
//                }
//            }
//            else{
//                when(buttonView.id){
//                    R.id.checkApple -> Log.d("CheckBox", "apple not checked")
//                    R.id.checkBanana -> Log.d("CheckBox", "banana not checked")
//                    R.id.checkOrange -> Log.d("CheckBox", "orange not checked")
//                }
//            }
//        }
//    }

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

//        setContentView(bindingratingbar.root)
//        bindingratingbar.ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
//            bindingratingbar.textView.text="$rating"
//        }



//        thread(start=true){
//            Thread.sleep(3000)
//            runOnUiThread{
//                showProgress(false)
//            }
//        }
////        val binding = ActivityMainBinding.inflate(layoutInflater)
//
//
//
//
//        binding.editText.addTextChangedListener {
//            if(it.toString().length>=8){
//                Log.d("EditText", "현재 입력된 값=${it.toString()}")
//            }
//        }
//
//        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
//            when (checkedId){
//                R.id.radio_apple->Log.d("RadioButton", "apple select")
//                R.id.radio_banana->Log.d("RadioButton", "banana select")
//                R.id.radio_orange->Log.d("RadioButton", "orange select")
//            }
//        }
//
//        binding.checkApple.setOnCheckedChangeListener (listener)
//        binding.checkBanana.setOnCheckedChangeListener (listener)
//        binding.checkOrange.setOnCheckedChangeListener (listener)

        //quiz4_2_1
//        setContentView(bindingquiz421.root)
//        bindingquiz421.radioGroup.setOnCheckedChangeListener { radioGroup, checkID ->
//            when (checkID){
//                R.id.radioApple -> bindingquiz412.radioText.text="사과"
//                R.id.radioBanana -> bindingquiz412.radioText.text="바나나"
//                R.id.radioOrange -> bindingquiz412.radioText.text="오렌지"
//
//            }
//        }

        //quiz4_2_2
//        setContentView(bindingquiz422.root)
//        bindingquiz422.checkApple.setOnCheckedChangeListener { buttonView, isChecked ->
//            apple = isChecked
//            printItem()
//        }
//        bindingquiz422.checkBanana.setOnCheckedChangeListener { buttonView, isChecked ->
//            banana = isChecked
//            printItem()
//        }
//        bindingquiz422.checkOrange.setOnCheckedChangeListener { buttonView, isChecked ->
//            orange = isChecked
//            printItem()
//        }

        //quiz4_2_3
        setContentView(bindingquiz423.root)
        thread(start=true){
            for(i in 0 until 10){
                Thread.sleep(1000)
                runOnUiThread { bindingquiz423.progressCount.text="${i+1}" }
            }
        }





    }

    //quiz4_2_2
//    var apple=false
//    var banana=false
//    var orange=false
//
//    fun printItem(){
//        var result=""
//        if (apple){
//            result="apple"
//        }
//        if(banana){
//            if(result.isNotEmpty()){
//                result+=" and "
//            }
//            result+="banana"
//        }
//        if(orange){
//            if(result.isNotEmpty()){
//                result+=" and "
//            }
//            result+="orange"
//        }
//        bindingquiz422.textView.text=result
//    }

//    fun showProgress(show:Boolean){
//        if(show){
//            bindingprogress.progressLayout.visibility= View.VISIBLE
//        }
//        else{
//            bindingprogress.progressLayout.visibility=View.GONE
//        }
//        //bindingprogress.progressLayout.visibility = if(show) View.VISIBLE else View.GONE
//    }
}