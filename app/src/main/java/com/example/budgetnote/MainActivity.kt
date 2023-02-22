package com.example.budgetnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.budgetnote.Database.DataBase
import com.example.budgetnote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   lateinit var dataBase : DataBase
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

        binding.transaction.setOnClickListener(){

            var intent = Intent(applicationContext,Transactions::class.java)
            startActivity(intent)
        }

        dataBase = DataBase(this)

        var list = dataBase.showData()

        var tIncome = 0
        var tExpense = 0
        var tBalance = 0
        for (l in list) {

            tIncome += l.income
            tExpense += l.expense
            tBalance = tIncome - tExpense
        }

        binding.totalIncome.text = tIncome.toString()
        binding.totalExpense.text = tExpense.toString()
        binding.totalBalance.text = tBalance.toString()
    }
}