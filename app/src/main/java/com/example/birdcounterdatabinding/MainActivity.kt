package com.example.birdcounterdatabinding

import android.graphics.Color

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.birdcounterdatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var  counterViewModel : CounterViewModel
    private val preferenceManager = PreferenceManager()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]
        setUpUi()
    }
    private fun setUpUi() {
        setBindings()
        setObservers()
        setInitialScreen()
    }

    private fun setObservers() {
        counterViewModel.counter.observe(this,androidx.lifecycle.Observer {
            binding.invalidateAll()
        })
    }

    private fun setBindings() {
        binding.apply {
            counterData = counterViewModel
            buttonBlue.setOnClickListener{countBird("#0000FF")}
            buttonOrange.setOnClickListener{countBird("#FFA500")}
            buttonRed.setOnClickListener{countBird("#FF0000")}
            buttonWhite.setOnClickListener{countBird("#ffffff")}
            buttonReset.setOnClickListener{resetAll()}
        }
    }

    private fun setInitialScreen(){
        counterViewModel.setCounter(preferenceManager.retriveCounter());
        binding.layoutId.setBackgroundColor(Color.parseColor(preferenceManager.retriveColor()))
    }

    private fun resetAll() {
        preferenceManager.saveCounter(0)
        preferenceManager.saveColor("#FFFFFF")
        setInitialScreen()
    }

    private fun countBird(s: String) {
        preferenceManager.incrementBirdCounter()
        preferenceManager.saveColor(s)
        setInitialScreen()
    }

}
