package com.example.mycalculatorapp.model

class Calculator (
    private val number1:Double,
    private val number2:Double) {

    fun add()=number1+number2
    fun subtraction()=number1-number2
    fun multiply()=number1*number2
    fun divide()=number1/number2

    //fun newFun()=(number1+number2)*2
}