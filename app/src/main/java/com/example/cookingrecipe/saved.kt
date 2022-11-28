package com.example.cookingrecipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cookingrecipe.databinding.FragmentHomeBinding
import com.example.cookingrecipe.databinding.FragmentSavedBinding
import java.lang.reflect.Array.get

class saved : Fragment() {
    private var _binding:FragmentSavedBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentSavedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.savedrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.savedrecycler.adapter=savedAdapter(requireContext())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}