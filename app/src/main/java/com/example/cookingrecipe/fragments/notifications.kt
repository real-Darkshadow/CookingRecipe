package com.example.cookingrecipe.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cookingrecipe.RecycleAdapters.notificationAdapter
import com.example.cookingrecipe.databinding.FragmentHomeBinding
import com.example.cookingrecipe.databinding.FragmentNotificationsBinding


class notifications : Fragment() {
    var _binding:FragmentNotificationsBinding?=null
    val binding get()=_binding!!

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.notificationrecycler.adapter= notificationAdapter(requireContext())
        binding.notificationrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
    }
}