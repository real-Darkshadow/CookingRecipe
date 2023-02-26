package com.example.cookingrecipe.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cookingrecipe.RecycleAdapters.popularAdapter
import com.example.cookingrecipe.RecycleAdapters.recentAdapter
import com.example.cookingrecipe.RecycleAdapters.trendingadapter
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.constants
import com.example.cookingrecipe.databinding.FragmentHomeBinding
import com.example.cookingrecipe.network.api
import com.example.cookingrecipe.network.retrohelper
import com.example.cookingrecipe.repo.repo
import com.example.cookingrecipe.ui.homeui.homefac
import com.example.cookingrecipe.ui.homeui.homemodel
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class home : Fragment() {

    private var _binding:FragmentHomeBinding?=null
    val binding get()=_binding!!
    private lateinit var viewmodel:homemodel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        val api=retrohelper.getinstance().create(api::class.java)
        val repo=repo(api)
        viewmodel=ViewModelProvider(this,homefac(repo)).get(homemodel::class.java)
        if (constants.isNetworkAvailable(requireContext())){
            viewmodel.data.observe(viewLifecycleOwner,{
                recyclerviews(it)
            })
        }
        return binding.root
    }
    fun categorybutton(view:View){


    }
    fun recyclerviews(reci:recipes){
        binding.popularrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.popularrecycler.adapter= popularAdapter(requireContext(),reci)
        binding.trendingrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.trendingrecycler.adapter= trendingadapter(requireContext(),reci)
        binding.recentrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.recentrecycler.adapter= recentAdapter(requireContext(),reci)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}