package com.example.mvvmarc

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmarc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var counter = 0
    companion object {
        const val LOGTAG = "LifeCycle"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val observer = Observer()
        lifecycle.addObserver(observer)

        Log.d(LOGTAG, "Activity - onCreate")

        binding.btnIncrement.setOnClickListener {
            Counter()
        }


    }

    fun Counter() {
        counter++
        binding.textView.text= counter.toString()

    }

}