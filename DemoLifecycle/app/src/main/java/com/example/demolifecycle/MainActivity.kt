package com.example.demolifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model =
            ViewModelProviders.of(this).get(
                MainActivityViewModel::class.java
            )
        val myRamdomNumber = model.getNumer()
        myRamdomNumber.observe(this, Observer<String> {
            tvNumber.text = it
            Log.i("xxx", "Random Number Set")
        })
        btnSubmit.setOnClickListener {
            model.createNumber()
        }


        //attach observer
        Log.i("xxx","Owner onCreate")
        lifecycle.addObserver(MainActivityObserver())

    }

    override fun onStart() {
        super.onStart()
        Log.i("xxx","Owner onCreate")
    }

    override fun onPause() {
        super.onPause()
        Log.i("xxx","Owner onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.i("xxx","Owner onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("xxx","Owner onDestroy")
    }

    override fun onStop() {
        super.onStop()
        Log.i("xxx","Owner onStop")
    }

}
