package com.example.iscream

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import kotlin.math.sqrt

class Accelerometer : SensorEventListener {
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        println("accuracy changed")
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val xval : Float = event?.values?.get(0) ?: 0F
        val yval : Float = event?.values?.get(1) ?: 0F
        val zval : Float = event?.values?.get(2) ?: 0F
        //println(timestamp)

        val at = sqrt(xval*xval + yval*yval + zval*zval)

        if(at < 1 && at > -1){
            println("IM FALLING")
        }



    }

}