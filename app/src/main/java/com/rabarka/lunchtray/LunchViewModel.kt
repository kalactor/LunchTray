package com.rabarka.lunchtray

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val TAX_PERCENT = 18

class LunchViewModel : ViewModel() {

    private val _mainDishName = MutableLiveData<String>()
    val mainDishName: LiveData<String> = _mainDishName

    private val _mainDishPrice = MutableLiveData<Double>()
    val mainDishPrice: LiveData<Double> = _mainDishPrice

    private val _sideDishName = MutableLiveData<String>()
    val sideDishName: LiveData<String> = _sideDishName

    private val _sideDishPrice = MutableLiveData<Double>()
    val sideDishPrice: LiveData<Double> = _sideDishPrice

    private val _extraDishName = MutableLiveData<String>()
    val extraDishName: LiveData<String> = _extraDishName

    private val _extraDishPrice = MutableLiveData<Double>()
    val extraDishPrice: LiveData<Double> = _extraDishPrice

    private val _subTotalPrice = MutableLiveData(0.0)
    val subTotalPrice: LiveData<Double> = _subTotalPrice

    private val _totalPrice = MutableLiveData(0.0)
    val totalPrice: LiveData<Double> = _totalPrice

    private val _tax = MutableLiveData(0.0)
    val tax: LiveData<Double> = _tax


    fun setMainDish(name: String, price: String) {
        _mainDishName.value = name
        _mainDishPrice.value = price.toDouble()
        subTotalHandler()
    }

    fun setSideDish(name: String, price: String) {
        _sideDishName.value = name
        _sideDishPrice.value = price.toDouble()
        subTotalHandler()
    }

    fun setExtraDish(name: String, price: String) {
        _extraDishName.value = name
        _extraDishPrice.value = price.toDouble()
        subTotalHandler()
    }

    private fun subTotalHandler() {
        val mainPrice = _mainDishPrice.value ?: 0.0
        val sidePrice = _sideDishPrice.value ?: 0.0
        val extraPrice = _extraDishPrice.value ?: 0.0
        _subTotalPrice.value = mainPrice + sidePrice + extraPrice
    }

    fun totalBillWithTax() {
        val tempBill = _subTotalPrice.value ?: 0.0
        _tax.value = tempBill * TAX_PERCENT / 100
        _totalPrice.value = _tax.value?.let { tempBill + it }
    }

    fun resetOrder() {
        _mainDishName.value = ""
        _mainDishPrice.value = 0.0
        _sideDishPrice.value = 0.0
        _sideDishName.value = ""
        _extraDishName.value = ""
        _extraDishPrice.value = 0.0
        _subTotalPrice.value = 0.0
    }

    init {
        resetOrder()
    }

}