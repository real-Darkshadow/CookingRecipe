package com.example.cookingrecipe.ui.detailui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cookingrecipe.apidata.ExtendedIngredient
import com.example.cookingrecipe.constants
import com.example.cookingrecipe.databinding.FragmentDetailrecipeBinding
import com.squareup.picasso.Picasso

class detailrecipe : Fragment() {
    private var binding:FragmentDetailrecipeBinding?=null
    private lateinit var viewModel: DetailrecipeViewModel
    private val args:detailrecipeArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailrecipeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this,detailfac(constants.repo)).get(DetailrecipeViewModel::class.java)
        val title=args.title
        binding!!.title.text=title
        val image=args.image
        Picasso.get().load(image).into(binding!!.tfoodimg)
        val position=args.position

        viewModel.data.observe(viewLifecycleOwner,{
            val senddata=it.recipes[position].extendedIngredients.toList()
            recycler(senddata)
        })



        return binding!!.root
    }
    private fun recycler(data: List<ExtendedIngredient>){
        binding!!.ingrec.adapter=detailAdapter(requireContext(),data)
        binding!!.ingrec.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }


}