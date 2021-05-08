package com.example.iscream

import android.hardware.Sensor
import android.hardware.SensorManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.HapticFeedbackConstants
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set screen to res/layout/activity_main.xml
        setContentView(R.layout.activity_main)

        // add audio to media player
        val mediaPlayer = MediaPlayer.create(this, R.raw.beep)

        // create sensor of the type accelerometer and instantiate a listener for the sensor
        val sensorManager : SensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val accelerometer = Accelerometer(mediaPlayer)



        // check if toggleButton is pressed or not
        val toggle: ToggleButton = findViewById(R.id.toggleButton)
        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // provide haptic feedback upon button press
                toggle.performHapticFeedback(
                    HapticFeedbackConstants.VIRTUAL_KEY,
                    HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING
                )
                println("BEGIN DATA")

                // enable sensor data reading
                sensorManager.registerListener(accelerometer, sensor, SensorManager.SENSOR_DELAY_NORMAL)
            }
            else {
                // provide haptic feedback upon button press
                toggle.performHapticFeedback(
                    HapticFeedbackConstants.VIRTUAL_KEY,
                    HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING
                )
                println("END DATA")

                // disable sensor data reading
                sensorManager.unregisterListener(accelerometer)
            }
        }

    }

    // ensures that if other activities are launched, no animation plays upon switching
    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }
}