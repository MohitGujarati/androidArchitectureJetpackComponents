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
        // Initialize ViewModel using ViewModelProvider
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(0)).get(MainViewModel::class.java)
        // Set ViewModel to the binding we need to pass lifecycleowener
        binding.lifecycleOwner=this
        binding.viewModelData = mainViewModel
    }

}