package com.example.qwest_1.view

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterCity : RecyclerView.Adapter<AdapterCity.MeViewHolder>() {
    class MeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeViewHolder {
        return MeViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: MeViewHolder, position: Int) {
        (holder.itemView as TextView).text = "f"
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}