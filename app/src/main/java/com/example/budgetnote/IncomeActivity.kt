package com.example.budgetnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.budgetnote.Database.DataBase
import com.example.budgetnote.databinding.ActivityIncomeBinding

class IncomeActivity : AppCompatActivity() {

    lateinit var dataBase: DataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityIncomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataBase = DataBase(applicationContext)

        binding.back.setOnClickListener {

            var intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnSaveIncome.setOnClickListener(){

            dataBase.addIncome(
                binding.edtIncome.text.toString().toInt(),
                binding.edtPaymentMethod.text.toString(),
                binding.edtParty.text.toString()
            )
        }
    }
}