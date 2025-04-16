package com.example.qwest_1.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.qwest_1.MainActivity
import com.example.qwest_1.databinding.FragmentSettingBinding
import com.example.qwest_1.domain.City
import com.example.qwest_1.domain.DataModel


class SettingFragment : Fragment() {
    lateinit var binding: FragmentSettingBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //   val listdfdf = DataBase.citiesDataBase
        val list = City("sdfasads", 34223)

        onClick()
    }


    fun onClick() {
        binding.butApply.setOnClickListener {
            dataModel.city.value = binding.spinnerCity.selectedItem.toString()
            dataModel.season.value = binding.spinnerSeason.selectedItem.toString()
            (activity as MainActivity).start()
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
        binding.exit.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
        }
    }
}