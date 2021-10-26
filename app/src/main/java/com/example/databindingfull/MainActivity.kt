package com.example.databindingfull

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.databindingfull.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val myUser = User("john", "doe", 34, false)
        binding.user = myUser

    }
}