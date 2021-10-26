package com.example.databindingfull

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModelProvider
import com.example.databindingfull.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val myUser = User("john", "doe", 34, true)
        binding.user = myUser

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        binding.viewModel = myViewModel
        binding.lifecycleOwner = this

//        myViewModel.message.observe(this,{
//            binding.textView.text = it
//        })

        binding.editText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               myViewModel.setMessage(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}

        })
    }
}