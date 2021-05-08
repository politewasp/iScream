package com.example.iscream

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import kotlin.math.sqrt

class Accelerometer : SensorEventListener {
    // never used
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // pass
    }

    // runs when sensor values change IF scream button enabled
    override fun onSensorChanged(event: SensorEvent?) {
        // reads force acting upon x, y, and z axis
        // ex: zval will return 9.8 when sitting still
        val xval : Float = event?.values?.get(0) ?: 0F
        val yval : Float = event?.values?.get(1) ?: 0F
        val zval : Float = event?.values?.get(2) ?: 0F

        // calculates total force acting on sensor
        val at = sqrt(xval*xval + yval*yval + zval*zval)

        // if total force is close to zero, phone is in free fall
        if(at < 1 && at > -1){
            println("IM FALLING")
        }
    }

}