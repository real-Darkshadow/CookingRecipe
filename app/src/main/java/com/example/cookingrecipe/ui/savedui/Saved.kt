package com.example.cookingrecipe.ui.savedui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cookingrecipe.ui.savedui.Recadapter.savedAdapter
import com.example.cookingrecipe.Room.entity
import com.example.cookingrecipe.constants
import com.example.cookingrecipe.databinding.FragmentSavedBinding

class saved : Fragment() {
    private var _binding:FragmentSavedBinding?=null
    private val binding get() = _binding!!
  private lateinit var viewmodel:savedmodel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentSavedBinding.inflate(inflater, container, false)
        val application=requireActivity().application
        val repo=(application as constants).repo
        viewmodel=ViewModelProvider(this,savedfac(repo)).get(savedmodel::class.java)

        viewmodel.roomdata.observe(viewLifecycleOwner,{
            recycler(it)
        }
        )


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    fun recycler(data: List<entity>){
        binding.savedrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.savedrecycler.adapter= savedAdapter(requireContext(),data)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}