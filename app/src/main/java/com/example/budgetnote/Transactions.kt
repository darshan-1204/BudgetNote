package com.example.budgetnote

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgetnote.Database.DataBase
import com.example.budgetnote.databinding.ActivityTransactionsBinding

class Transactions : AppCompatActivity() {

    lateinit var dataBase: DataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {

            var intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        dataBase = DataBase(applicationContext)

        var list = dataBase.showData()
        binding.recycle.layoutManager = LinearLayoutManager(applicationContext)
        binding.recycle.adapter = RecycleAdapter(list)

    }
}