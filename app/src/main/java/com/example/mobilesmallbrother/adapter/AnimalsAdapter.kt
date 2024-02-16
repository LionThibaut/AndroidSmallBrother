package com.example.mobilesmallbrother.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilesmallbrother.AnimalPopup
import com.example.mobilesmallbrother.R
import com.example.mobilesmallbrother.fragments.AnimalModel
import com.example.mobilesmallbrother.fragments.FeedFragment

//Va servir d'adapter pour l'image de chaque chiens
class AnimalsAdapter(public val context: Context) : RecyclerView.Adapter<AnimalsAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imgAnimal= view.findViewById<ImageView>(R.id.itemAnimalCard_ImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_animal_card, parent, false)
            )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{

            AnimalPopup(this, currentAnimal = AnimalModel()).show()

        }

    }

    override fun getItemCount(): Int = 10
}