package com.bitcode.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyBR : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        mt(context!!, intent?.action!!)
        if (intent.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            var isOn = intent.getBooleanExtra("state", false)
            mt(
                context,
                if (isOn) {
                    "Airplane mode is turned on.."
                } else {
                    "Airplane mode is turned off"
                }
            )
        }
        if(intent.action.equals("in.bitcode.download.COMPLETE")) {
            mt(
                context,
                intent.getStringExtra("path")!!
            )
        }

    }

    private fun mt(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
        Log.e("tag", text)
    }
}