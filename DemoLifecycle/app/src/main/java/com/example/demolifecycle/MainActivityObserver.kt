package com.example.demolifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MainActivityObserver : LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateEvent(){
        Log.i("xxx", "Observer On_Create")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartEvent(){
        Log.i("xxx", "Observer On_Start")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeEvent(){
        Log.i("xxx", "Observer On_Resume")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseEvent(){
        Log.i("xxx", "Observer On_Pause")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopEvent(){
        Log.i("xxx", "Observer On_Stop")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyEvent(){
        Log.i("xxx", "Observer On_Destroy")
    }




}