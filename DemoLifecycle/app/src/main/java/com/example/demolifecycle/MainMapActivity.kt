package com.example.demolifecycle

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.demolifecycle.Constants.REQUEST_LOCATION_PERMISSION_CODE
import kotlinx.android.synthetic.main.activity_main_map.*

class MainMapActivity : AppCompatActivity() {
    private lateinit var myLocationManager: MyLocationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_map)
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)!=
            PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),REQUEST_LOCATION_PERMISSION_CODE)
        }else{
            setupLocationListener()
            //TODO:/ using GPS after request permisstion
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.i("aaa","vo day")
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            setupLocationListener()
            //TODO:/ using GPS after request permisstion
        }else{
            Toast.makeText(this, "Bạn chưa có quyền truy cập vào GPS của thiết bị", Toast.LENGTH_LONG).show()
        }
    }

    override fun onStart() {
        super.onStart()
        //get information location
        myLocationManager.start()
    }

    override fun onStop() {
        super.onStop()
        //stop
        myLocationManager.stop()
    }
    private fun setupLocationListener(){
        myLocationManager = MyLocationManager(this){
            tvAddress.text = it.latitude.toString() + " , " + it.longitude.toString()
        }
        lifecycle.addObserver(myLocationManager)
    }


}
