package com.example.budgetnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.budgetnote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addIncome.setOnClickListener(){

            var intent = Intent(applicationContext,IncomeActivity::class.java)
            startActivity(intent)
        }

        binding.addExpense.setOnClickListener(){

            var intent = Intent(applicationContext,ExpenseActivity::class.java)
            startActivity(intent)
        }
    }
}