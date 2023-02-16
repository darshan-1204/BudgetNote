package com.example.budgetnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.budgetnote.Database.DataBase
import com.example.budgetnote.databinding.ActivityExpenseBinding
import com.example.budgetnote.databinding.ActivityIncomeBinding

class ExpenseActivity : AppCompatActivity() {

    lateinit var dataBase : DataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataBase = DataBase(applicationContext)

        binding.back.setOnClickListener {

            var intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnSaveExpense.setOnClickListener(){

            dataBase.addExpense(
                binding.edtExpense.text.toString().toInt(),
                binding.edtPaymentMethodExp.text.toString(),
                binding.edtPartyExp.text.toString()
            )
        }
    }
}