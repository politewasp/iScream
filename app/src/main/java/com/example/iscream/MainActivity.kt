package com.example.iscream

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sensorManager : SensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        val accelerometer = Accelerometer()


        val toggle: ToggleButton = findViewById(R.id.toggleButton)
        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                toggle.performHapticFeedback(
                    HapticFeedbackConstants.VIRTUAL_KEY,
                    HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING
                )
                println("BEGIN DATA")
                sensorManager.registerListener(accelerometer, sensor, SensorManager.SENSOR_DELAY_NORMAL)
            }
            else {
                toggle.performHapticFeedback(
                    HapticFeedbackConstants.VIRTUAL_KEY,
                    HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING
                )
                println("END DATA")
                sensorManager.unregisterListener(accelerometer)
            }
        }

    }

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }
}