package com.example.cookingrecipe.ui.homeui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cookingrecipe.R
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.constants
import com.example.cookingrecipe.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class home : Fragment() {

    private var _binding:FragmentHomeBinding?=null
    private val binding get()=_binding!!
    private lateinit var viewmodel:homemodel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)

        viewmodel=ViewModelProvider(this,homefac(constants.repo)).get(homemodel::class.java)
        viewmodel.data.observe(viewLifecycleOwner,{
                recyclerviews(it)
            })
        viewmodel.data2.observe(viewLifecycleOwner,{
            pop(it)

        })

        binding.seeall.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_seeall2)
        }

        return binding.root
    }

    fun recyclerviews(reci:recipes){
        binding.popularrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.popularrecycler.adapter= popularAdapter(requireContext(),reci,::onsave)

        binding.recentrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.recentrecycler.adapter= recentAdapter(requireContext(),reci,::onsave)
    }
    fun pop(reci:recipes){
        binding.trendingrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.trendingrecycler.adapter= trendingadapter(requireContext(),reci,::onsave)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
    fun onsave(){
        CoroutineScope(Dispatchers.IO).launch {
            viewmodel.save()
        }
    }
}