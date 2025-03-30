package com.example.qwest_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.qwest_1.data.CityBase
import com.example.qwest_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = CityBase("Городишко","большой")
    }
}

fun ClickButton(){}

fun FragmentHomeOpen(){}

fun FragmentSettingOpen(){}