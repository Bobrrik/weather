package com.example.qwest_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qwest_1.databinding.ActivityMainBinding
import com.example.qwest_1.view.HomeFragment
import com.example.qwest_1.view.SettingFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //      val user = CityBase("Городишко","большой")

        FragmentHomeOpen()
        ClickButton()
    }

    fun ClickButton() {
        binding.setting.setOnClickListener {
            FragmentSettingOpen()
        }
    }

    fun FragmentHomeOpen() {
        supportFragmentManager
            .beginTransaction()
            .add(binding.fragmentHome.id, HomeFragment())
            .addToBackStack(null)
            .commit()
    }

    fun FragmentSettingOpen() {
        supportFragmentManager
            .beginTransaction()
            .add(binding.fragmentHome.id, SettingFragment())
            .addToBackStack(null)
            .commit()
    }
}

