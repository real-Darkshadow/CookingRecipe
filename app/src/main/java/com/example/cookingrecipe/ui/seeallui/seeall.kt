package com.example.cookingrecipe.ui.seeallui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.constants
import com.example.cookingrecipe.databinding.FragmentSeeallBinding
import com.example.cookingrecipe.ui.seeallui.recycler.seealladapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class seeall : Fragment() {
    private var binding:FragmentSeeallBinding?=null
    private lateinit var viewModel: SeeallViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSeeallBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this,seeallfac(constants.repo)).get(SeeallViewModel::class.java)
        viewModel.data.observe(viewLifecycleOwner,{
            recycler(it)
        })
    return binding!!.root
    }
    fun recycler(data:recipes){
        binding!!.seerecycler.adapter=seealladapter(requireContext(),data,::save)
        binding!!.seerecycler.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }
    fun save(){
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.save()
        }
    }


}