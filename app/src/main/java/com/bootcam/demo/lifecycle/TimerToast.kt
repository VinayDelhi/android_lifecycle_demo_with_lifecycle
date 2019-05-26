package com.bootcam.demo.lifecycle

import android.app.Application
import android.arch.lifecycle.*
import android.os.CountDownTimer
import android.widget.Toast
import java.util.*

class TimerToast(application: Application, lifecycleOwner: LifecycleOwner): LifecycleObserver{

    private val lifecycle = lifecycleOwner.lifecycle
    private var isStarted = false

    init{
        lifecycle.addObserver(this)
    }

    //Note: onTick & onFinished will
    // be called in different thread than the main thread.

    private val timer = object: CountDownTimer(60000, 3000){
        override fun onFinish() {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            if(lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED))
            Toast.makeText(application, "timer finished", Toast.LENGTH_SHORT).show()

        }

        override fun onTick(millisUntilFinished: Long) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

            if(lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED))
            Toast.makeText(application, "$millisUntilFinished", Toast.LENGTH_SHORT).show()
        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start(){
        if(!isStarted){
            isStarted = true
            timer.start()
        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun stop(){
        timer.cancel();
    }
}