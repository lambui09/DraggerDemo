package com.example.demolifecycle

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel : ViewModel() {
//    private val _resetOtpTimeRemain = MutableLiveData<Long>().apply {
//        value = Constants.TIME_RESET_GET_OTP_SECOND
//    }
//    val resetOtpTimeRemain: LiveData<Long> = _resetOtpTimeRemain //cho pubic



    private lateinit var myRandomNumber : MutableLiveData<String>
    fun getNumer() :MutableLiveData<String>{
        Log.i("xxx", "Get Number")
        if (!::myRandomNumber.isInitialized){
            myRandomNumber = MutableLiveData()
            this.createNumber()
        }
        return myRandomNumber
    }
    fun createNumber(){
        val random = Random
        myRandomNumber.value = "Number: " + (random.nextInt(10 -1) + 1)
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("xxx", "ViewModel Destroyed")
    }
}