package com.example.howtomakerecyclerview

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.howtomakerecyclerview.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        //
        //array설정
        val list : ArrayList<Data> = ArrayList()

        //adapter 설정
        binding.recycler.adapter = MainAdapter(list){
                data, position ->
            Toast.makeText(this, "아이템이 삭제됨", Toast.LENGTH_SHORT).show()
            list.remove(data)
            binding.recycler.adapter!!.notifyItemRemoved(position)
        }

        binding.addBtn.setOnClickListener {
            val randomInt = Random.nextInt(100).toString()
            Log.d(TAG, "onCreate: random : $randomInt")
            list.add(
                Data("학생", R.drawable.ic_launcher_foreground, randomInt)
            )
            binding.recycler.adapter!!.notifyItemInserted(list.size.minus(1))
        }

    }

}