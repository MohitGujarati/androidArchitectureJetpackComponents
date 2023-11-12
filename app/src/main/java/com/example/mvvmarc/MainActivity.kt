package com.example.mvvmarc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner

class MainActivity : AppCompatActivity() {

    companion object {
        const val LOGTAG = "LifeCycle"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val observer = Observer()

        lifecycle.addObserver(observer)

        Log.d(LOGTAG, "Activity - onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d(LOGTAG, "Activity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOGTAG, "Activity - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOGTAG, "Activity - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOGTAG, "Activity - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOGTAG, "Activity - onDestroy")
    }


}