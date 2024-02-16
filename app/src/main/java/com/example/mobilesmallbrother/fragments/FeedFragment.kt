package com.example.mobilesmallbrother.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilesmallbrother.MainActivity
import com.example.mobilesmallbrother.R
import com.example.mobilesmallbrother.adapter.AnimalItemDecoration
import com.example.mobilesmallbrother.adapter.AnimalsAdapter
import com.example.mobilesmallbrother.databinding.FragmentFeedBinding
import com.example.mobilesmallbrother.dtos.DtoInputPost
import com.example.mobilesmallbrother.managers.AnimalManagerViewModel
import com.example.mobilesmallbrother.managers.PostManagerViewModel

class FeedFragment : Fragment() {
    lateinit var binding: FragmentFeedBinding
    lateinit var viewModel: PostManagerViewModel
    private lateinit var postsList: List<DtoInputPost>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this).get(PostManagerViewModel::class.java)

        val view = inflater?.inflate(R.layout.fragment_feed, container, false)

        val recyclerView = view!!.findViewById<RecyclerView>(R.id.rv_fragmentFeed_recycleView)
        recyclerView.adapter = this.context?.let { AnimalsAdapter(it) }
        recyclerView.addItemDecoration(AnimalItemDecoration())

        viewModel.mutableLiveDataListNotFoundPost.observe(viewLifecycleOwner) {
            Log.i("test", it.toString())
        }

        viewModel.launchFetchAllNotFound()

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PostManagerViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        @JvmStatic
        fun newInstance() = FeedFragment()
    }
}