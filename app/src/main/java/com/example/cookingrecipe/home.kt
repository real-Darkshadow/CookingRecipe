package com.example.cookingrecipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cookingrecipe.databinding.FragmentHomeBinding


class home : Fragment() {

    private var _binding:FragmentHomeBinding?=null
    val binding get()=_binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.popularrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.popularrecycler.adapter=popularAdapter(requireContext())
        binding.recentrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.recentrecycler.adapter=recentAdapter(requireContext())
        binding.trendingrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.trendingrecycler.adapter=trendingadapter(requireContext())

    }
    fun categorybutton(){
        return
    }


}