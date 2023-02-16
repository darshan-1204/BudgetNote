package com.example.budgetnote.Database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBase(context: Context?) : SQLiteOpenHelper(context, "MyData.db",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {

        var sql = "CREATE TABLE budget(id INTEGER PRIMARY KEY AUTOINCREMENT,income INTEGER,expense INTEGER,p_method TEXT,party TEXT)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun addIncome (income : Int,p_method : String,party : String){

        var db = writableDatabase
        var values = ContentValues()
        values.put("income",income)
        values.put("p_method",p_method)
        values.put("party",party)
        db.insert("budget",null,values)
    }

    fun addExpense (expense : Int,p_method : String,party : String){

        var db = writableDatabase
        var values = ContentValues()
        values.put("expense",expense)
        values.put("p_method",p_method)
        values.put("party",party)
        db.insert("budget",null,values)
    }

    fun showData(): ArrayList<BudgetModel> {

        var bgtList = ArrayList<BudgetModel>()
        var db = readableDatabase
        var sql = "SELECT * FROM budget"
        var cursor : Cursor = db.rawQuery(sql,null)
        cursor.moveToFirst()

        for (i in 0 until cursor.count){

            var id = cursor.getInt(0)
            var income = cursor.getInt(1)
            var expense = cursor.getInt(2)
            var p_method = cursor.getString(3)
            var party = cursor.getString(4)

            var bgt = BudgetModel(id, income, expense, p_method, party)
            bgtList.add(bgt)
            cursor.moveToNext()
        }

        return bgtList

    }
}