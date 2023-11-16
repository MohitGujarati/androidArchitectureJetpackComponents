package com.example.mvvmarc

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainviewmodel: mainViewModel
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
        mainviewmodel=ViewModelProvider(this,mainViewModelFactory(10)).get(mainViewModel::class.java)

        Log.d(LOGTAG, "Activity - onCreate")

        setText()

        binding.btnIncrement.setOnClickListener {
            increment()
            setText()
        }


    }

    private fun setText() {
        binding.textView.text=mainviewmodel.count.toString()
    }

    private fun increment(){
        mainviewmodel.increment()
    }


}