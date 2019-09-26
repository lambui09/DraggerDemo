package com.example.demolifecycle

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLocationManager(private val context: Context,
                        private val callback: (Location) -> Unit) : LifecycleObserver {
    private var mLocationManager: LocationManager? = null
    //conect gg service to get location
    @SuppressLint("MissingPermission")
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun start() {
        mLocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        mLocationManager?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, locationListener)

        //update last location, if available
        val lastLocation = mLocationManager?.getLastKnownLocation(
            LocationManager.GPS_PROVIDER
        )
        if (lastLocation != null) {
            locationListener.onLocationChanged(lastLocation)
        }
        Toast.makeText(context, "MyLocationManager started", Toast.LENGTH_SHORT).show()


    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stop() {
        if (mLocationManager == null) {
            return
        }
        mLocationManager?.removeUpdates(locationListener)
        mLocationManager = null
        Toast.makeText(context, "MyLocationManager paused", Toast.LENGTH_SHORT).show()
    }

    val locationListener = object : LocationListener {

        override fun onLocationChanged(p0: Location?) {
            p0?.let {
                callback.invoke(p0)
            }
        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {

        }

        override fun onProviderEnabled(p0: String?) {

        }

        override fun onProviderDisabled(p0: String?) {

        }
    }
}