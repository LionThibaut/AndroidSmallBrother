package com.example.mobilesmallbrother.managers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilesmallbrother.dtos.DtoInputPost
import com.example.mobilesmallbrother.repositories.PostRepository
import com.example.mobilesmallbrother.utils.RetrofitHelper
import kotlinx.coroutines.launch

class PostManagerViewModel : ViewModel(){
    private val postRepository = RetrofitHelper.newInstance().create(PostRepository::class.java)

    val mutableLiveDataListNotFoundPost: MutableLiveData<List<DtoInputPost>> = MutableLiveData()

    fun launchFetchAllNotFound() {
        viewModelScope.launch {
            val postList = postRepository.fetchAllNotFound()
            mutableLiveDataListNotFoundPost.postValue(postList)
        }
    }
}