package com.example.chapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data2:MutableList<Memo> = loadData()
        var adapter2 = CustomAdapter()
        adapter2.listData=data2

        binding.recyclerView.adapter=adapter2

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val message = it.data?.getStringExtra("returnValue")
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }

        val intent = Intent(this, SubActivity::class.java)
        intent.putExtra("from1", "Hello, Bundle")
        intent.putExtra("from2", 2022)

        binding.btnStart.setOnClickListener { activityResult.launch(intent) }

        var data = listOf("-선택하세요-", "1월", "2월", "3월", "4월", "5월", "6월")
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)

        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                TODO("Not yet implemented")
                binding.result.text = data.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
//                TODO("Not yet implemented")
            }
        }


    }
    fun loadData():MutableList<Memo>{
        val data:MutableList<Memo> = mutableListOf()
        for (no in 1..100){
            val title="이것이 안드로이드다 ${no}"
            var date=System.currentTimeMillis()
            var memo=Memo(no, title, date)
            data.add(memo)
        }
        return data
    }
}