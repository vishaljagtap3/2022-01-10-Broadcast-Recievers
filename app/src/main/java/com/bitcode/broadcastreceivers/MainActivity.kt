package com.bitcode.broadcastreceivers

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitcode.broadcastreceivers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    var myBr = MyBR()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            var intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            intentFilter.addAction(Intent.ACTION_BATTERY_LOW)
            intentFilter.addAction(Intent.ACTION_WALLPAPER_CHANGED)
            intentFilter.addAction("in.bitcode.download.COMPLETE")

            intentFilter.priority = 900

            registerReceiver(myBr, intentFilter)
        }

        binding.btnUnregister.setOnClickListener {
            unregisterReceiver(myBr)
        }
    }
}


