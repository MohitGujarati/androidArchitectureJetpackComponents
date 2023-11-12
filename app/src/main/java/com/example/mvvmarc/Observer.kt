package com.example.mvvmarc

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class Observer : LifecycleEventObserver {
        companion object {
            const val LOGTAG = "LifeCycle"
        }

        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            when (event) {
                Lifecycle.Event.ON_CREATE -> Log.d(LOGTAG, "Observer - onCreate")
                Lifecycle.Event.ON_START -> Log.d(LOGTAG, "Observer - onStart")
                Lifecycle.Event.ON_RESUME -> Log.d(LOGTAG, "Observer - onResume")
                Lifecycle.Event.ON_PAUSE -> Log.d(LOGTAG, "Observer - onPause")
                Lifecycle.Event.ON_STOP -> Log.d(LOGTAG, "Observer - onStop")
                Lifecycle.Event.ON_DESTROY -> Log.d(LOGTAG, "Observer - onDestroy")
                // Add other lifecycle events as needed
                else -> {}
            }
        }
    }

