package com.example.mobilesmallbrother.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilesmallbrother.R
import com.example.mobilesmallbrother.adapter.MyAnimalsAdapter
import com.example.mobilesmallbrother.databinding.FragmentMyanimalsListBinding
import com.example.mobilesmallbrother.dtos.DtoInputAnimal
import com.example.mobilesmallbrother.dtos.DtoInputClient
import com.example.mobilesmallbrother.managers.AnimalManagerViewModel

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentMyanimalsListBinding
    lateinit var viewModel: AnimalManagerViewModel
    lateinit var dtoClient: DtoInputClient
    private lateinit var animalsList: List<DtoInputAnimal>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyanimalsListBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(AnimalManagerViewModel::class.java)

        val view = inflater?.inflate(R.layout.fragment_myanimals_list, container, false)

        val recyclerView = view!!.findViewById<RecyclerView>(R.id.rv_fragmentMyAnimalsList)
        recyclerView.adapter = this.context?.let { MyAnimalsAdapter(it) }

        viewModel.mutableLiveDataByIdClientAnimal.observe(viewLifecycleOwner) {
            Log.i("test", it.toString())
        }

        viewModel.launchFetchByIdClient(dtoClient.idClient)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimalManagerViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}