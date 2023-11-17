package com.example.mvvmarc

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmarc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    companion object {
        const val LOGTAG = "MainActivityLog"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use DataBindingUtil.setContentView to set up data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // Set the lifecycle owner for observing LiveData
        binding.lifecycleOwner = this
        val lifecycleobserver = Observer()
        lifecycle.addObserver(lifecycleobserver)


        //Adding observer to keep eye on data so as soon as it changes the data here
        val observer = Observer<String> {
            binding.textView1.text = it
        }

        // Initialize ViewModel using ViewModelProvider
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(0)).get(MainViewModel::class.java)

        // Observe the EOTextLiveData in the ViewModel
        mainViewModel.EOTextLiveData.observe(this, observer)

        // Set ViewModel to the binding
        binding.viewModelData = mainViewModel

        // Set up click listener for the button
        binding.btnIncrement.setOnClickListener {
            mainViewModel.increment()
            setText()
        }

        setText()
    }

    private fun setText() {
        binding.textView.text = mainViewModel.count.toString()
    }
}