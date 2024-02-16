package com.example.mobilesmallbrother

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.example.mobilesmallbrother.adapter.AnimalsAdapter
import com.example.mobilesmallbrother.fragments.AnimalModel
import org.w3c.dom.Text

// class AnimalPopup(private val adapter: AnimalsAdapter, private val currentAnimal: AnimalModel) : Dialog(adapter.context)
class AnimalPopup(private val adapter: AnimalsAdapter, private val currentAnimal: AnimalModel) : Dialog(adapter.context)
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_animal_details)
        setupComponents()
        setupCloseButton()
        setupDeleteButton()
    }

    private fun setupDeleteButton() {
        findViewById<ImageView>(R.id.delete_animal).setOnClickListener{
            //delete the animal from the database --> 3:48:36
        }
    }

    private fun setupCloseButton() {
        findViewById<ImageView>(R.id.close_button).setOnClickListener{
            dismiss()
        }
    }

    private fun setupComponents() {
        //actualiser image
        val animalImage = findViewById<ImageView>(R.id.image_item);
        //Glide.with(adapter.context).load(Uri.parse(currentAnimal.animalImageUrl)).into(animalImage)

        //actualise the nom
        findViewById<TextView>(R.id.popup_animal_name).text = currentAnimal.name

        //actualise the details
        findViewById<TextView>(R.id.popup_animal_details_subtitle).text = currentAnimal.animalDetails


        //actualiser la description
        findViewById<TextView>(R.id.popup_animal_description_subtitle).text = currentAnimal.animalDescription

        //actualise the state
        findViewById<TextView>(R.id.popup_animal_state_subtitle).text = currentAnimal.animalState

    }


}