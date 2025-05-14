package com.example.qwest_1.view

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.qwest_1.MainActivity
import com.example.qwest_1.data.MainRepository
import com.example.qwest_1.databinding.FragmentSettingBinding
import com.example.qwest_1.domain.City
import com.example.qwest_1.domain.DataModel


class SettingFragment : Fragment() {
    lateinit var binding: FragmentSettingBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter()      // подключение адаптера
        onClick()    // подключение кликов
    }

    fun adapter() {

        val spinnerList = mutableListOf<String>() // лист для адаптера

        for (i in 0..MainRepository().citiesDataBase.size - 1) {        // заполнение листа для адаптера
            spinnerList.add(MainRepository().citiesDataBase[i].name)
        }

        val spinnerArrayAdapter: ArrayAdapter<String> =     //  адаптер для spinner
            ArrayAdapter<String>(requireContext(), R.layout.simple_spinner_item, spinnerList)
        spinnerArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item) // The drop down view
        binding.spinnerCity.adapter = spinnerArrayAdapter
    }

    fun onClick() {
        binding.butApply.setOnClickListener {       // применить
            dataModel.city.value = binding.spinnerCity.selectedItem.toString()
            dataModel.season.value = binding.spinnerSeason.selectedItem.toString()
            (activity as MainActivity).start()
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
        binding.exit.setOnClickListener {       // выйти
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
    }
}