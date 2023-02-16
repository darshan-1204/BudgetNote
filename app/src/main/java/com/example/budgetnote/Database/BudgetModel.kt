package com.example.budgetnote.Database

class BudgetModel {

    var id = 0
    var income = 0
    var expense = 0
    var p_method : String
    var party : String

    constructor(id: Int, income: Int, expense: Int, p_method: String, party: String) {
        this.id = id
        this.income = income
        this.expense = expense
        this.p_method = p_method
        this.party = party
    }


}
