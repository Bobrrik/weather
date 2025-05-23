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
import com.example.qwest_1.databinding.FragmentSettingBinding
import com.example.qwest_1.domain.DataModel
import com.example.qwest_1.view_model.SettingFragmentViewModel


class SettingFragment : Fragment() {
    lateinit var binding: FragmentSettingBinding
    private val viewModel: SettingFragmentViewModel by activityViewModels()
    private val dataModel: DataModel by activityViewModels()
    var spinnerList = mutableListOf<String>() // лист для адаптера

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

        viewModel.cityNameList.observe(viewLifecycleOwner) {
            spinnerList = it
        }

        val spinnerArrayAdapter: ArrayAdapter<String> =     //  адаптер для spinner
            ArrayAdapter<String>(requireContext(), R.layout.simple_spinner_item, spinnerList)
        spinnerArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item) // The drop down view
        binding.spinnerCity.adapter = spinnerArrayAdapter
    }

    fun onClick() {
        binding.spinnerCity.setOnClickListener {
           viewModel.listFill()
        }

        binding.butApply.setOnClickListener {       // применить
            this.dataModel.city.value = binding.spinnerCity.selectedItem.toString()
            this.dataModel.season.value = binding.spinnerSeason.selectedItem.toString()
            (activity as MainActivity).start()
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
        binding.exit.setOnClickListener {       // выйти
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
        binding.butCityPlus.setOnClickListener {
        }
    }
}