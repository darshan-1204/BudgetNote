package com.example.budgetnote.Database

import android.content.ContentValues
import android.content.Context
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

    fun addIncome (id : Int,income : Int,p_method : String,party : String){

        var db = writableDatabase
        var values = ContentValues()
        values.put("income",income)
        values.put("p_method",p_method)
        values.put("party",party)
        db.insert("budget",null,values)
    }

    fun addExpense (id : Int,expense : Int,p_method : String,party : String){

        var db = writableDatabase
        var values = ContentValues()
        values.put("expense",expense)
        values.put("p_method",p_method)
        values.put("party",party)
        db.insert("budget",null,values)
    }
}