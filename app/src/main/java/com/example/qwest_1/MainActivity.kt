package com.example.qwest_1

import android.os.Bundle
import android.widget.Toast
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
    val cityName = " "
    var citySeason = " "
    private var backPressed = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)




        ClickButton()
        start()
    }

    fun start() {

        dataModel.city.observe(this, { name -> binding.textText.text = name })
        dataModel.season.observe(this, { _season -> citySeason = _season })

        arrangement(City(cityName, 21233), citySeason)

    }

    fun arrangement(city: City, season: String) {

//        val city = City("Апчихба", 21233)
//        val season = "Весна"

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

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            if (backPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                super.onBackPressed()
                finish()
            } else {
                Toast.makeText(this, "Вы точно хотите выйти?", Toast.LENGTH_SHORT).show()
                backPressed = System.currentTimeMillis()
            }
        } else super.onBackPressed()
    }

    companion object {
        const val TIME_INTERVAL = 2000
    }
}



