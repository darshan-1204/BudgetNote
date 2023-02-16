package com.example.budgetnote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.budgetnote.Database.BudgetModel

class RecycleAdapter(list: ArrayList<BudgetModel>) : RecyclerView.Adapter<RecycleAdapter.BudgetHolder>() {

    var list = list

    class BudgetHolder(itemView: View) : ViewHolder(itemView) {

        var party = itemView.findViewById<TextView>(R.id.recycle_party)
        var p_method = itemView.findViewById<TextView>(R.id.recycle_payment_method)
        var income = itemView.findViewById<TextView>(R.id.recycle_income)
        var expense = itemView.findViewById<TextView>(R.id.recycle_expense)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BudgetHolder {

        return BudgetHolder( LayoutInflater.from(parent.context).inflate(R.layout.recycle_transaction,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BudgetHolder, position: Int) {

        holder.party.text = list[position].party
        holder.p_method.text = list[position].p_method
        holder.income.text = list[position].income.toString()
        holder.expense.text = list[position].expense.toString()
    }
}