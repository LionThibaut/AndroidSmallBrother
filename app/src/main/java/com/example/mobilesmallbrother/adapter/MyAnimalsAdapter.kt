package com.example.mobilesmallbrother.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilesmallbrother.R

class MyAnimalsAdapter(
    public val context: Context
) : RecyclerView.Adapter<MyAnimalsAdapter.ViewHolder>() {

    inner class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val plantImage = view.findViewById<ImageView>(R.id.iv_fragmentMyAnimalsCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_myanimals_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // val item = values[position]
        // Affecter les url des images de la liste des dtos
    }

    override fun getItemCount(): Int = 5
}