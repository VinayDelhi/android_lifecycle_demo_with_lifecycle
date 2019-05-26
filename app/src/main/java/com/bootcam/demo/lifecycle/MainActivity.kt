package com.bootcam.demo.lifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.sql.Time

class MainActivity : AppCompatActivity() {

    private lateinit var  timerToast: TimerToast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        timerToast = TimerToast(application, this)
    }
}
