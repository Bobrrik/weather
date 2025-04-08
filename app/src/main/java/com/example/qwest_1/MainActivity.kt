package com.example.qwest_1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import com.example.qwest_1.databinding.ActivityMainBinding
import com.example.qwest_1.domain.City
import com.example.qwest_1.domain.DataModel
import com.example.qwest_1.domain.Weather
import com.example.qwest_1.view.SettingFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        arrangement()
        ClickButton()

        dataModel.message.observe(this, { name -> binding.textText.text = name })
    }

    fun arrangement() {

        val city = City("Апчихба", 21233)
        val season = "Весна"

        val user =
            Weather(
                city.name,
                city.size(),
                season,
                city.quarterName(season, 1),
                city.quarterTemp(season, 1),
                city.quarterName(season, 2),
                city.quarterTemp(season, 2),
                city.quarterName(season, 3),
                city.quarterTemp(season, 3)
            )
        val obsUser = ObservableField(user)

        binding.cardView.setCardBackgroundColor(user.colorSeason())

        binding.user = obsUser

    }

    fun ClickButton() {
        binding.setting.setOnClickListener {
            FragmentSettingOpen()
        }
    }

    fun FragmentSettingOpen() {
        supportFragmentManager
            .beginTransaction()
            .add(binding.fragmentSetting.id, SettingFragment())
            .addToBackStack(null)
            .commit()
    }

}



