package com.example.mobilesmallbrother.managers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilesmallbrother.dtos.DtoInputAnimal
import com.example.mobilesmallbrother.dtos.DtoOutputCreateAnimal
import com.example.mobilesmallbrother.repositories.AnimalRepository
import com.example.mobilesmallbrother.utils.RetrofitHelper
import kotlinx.coroutines.launch

class AnimalManagerViewModel : ViewModel() {
    private val animalRepository = RetrofitHelper.newInstance().create(AnimalRepository::class.java)

    val mutableLiveDataByIdClientAnimal: MutableLiveData<List<DtoInputAnimal>?> = MutableLiveData()
    val mutableLiveDataCreateAnimal: MutableLiveData<DtoInputAnimal> = MutableLiveData()

    fun launchFetchByIdClient(idClient: Int) {
        viewModelScope.launch {
            try {
                val animalByIdClient = animalRepository.fetchByIdClient(idClient)
                mutableLiveDataByIdClientAnimal.postValue(animalByIdClient)
            }
            catch(e: Exception) {
                mutableLiveDataByIdClientAnimal.postValue(null)
            }
        }
    }

    fun launchCreate(dto: DtoOutputCreateAnimal) {
        viewModelScope.launch {
            val animal = animalRepository.create(dto)
            mutableLiveDataCreateAnimal.postValue(animal)
        }
    }
}