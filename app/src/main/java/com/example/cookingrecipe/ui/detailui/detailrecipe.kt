package com.example.cookingrecipe.ui.detailui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.TypeConverter
import com.example.cookingrecipe.Room.database
import com.example.cookingrecipe.apidata.ExtendedIngredient
import com.example.cookingrecipe.constants
import com.example.cookingrecipe.databinding.FragmentDetailrecipeBinding
import com.example.cookingrecipe.network.api
import com.example.cookingrecipe.network.retrohelper
import com.example.cookingrecipe.repo.repo
import com.example.cookingrecipe.ui.detailui.viewmodel.DetailrecipeViewModel
import com.example.cookingrecipe.ui.detailui.viewmodel.detailfac
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


        val application=requireActivity().application
        val repo= (application as constants).repo










        viewModel = ViewModelProvider(this, detailfac(repo)).get(DetailrecipeViewModel::class.java)
        val position=args.position
        when(args.adapter){
            "trending"->(viewModel.data2.observe(viewLifecycleOwner,{
                binding!!.title.text=it.recipes[position].title
                Picasso.get().load(it.recipes[position].image).into(binding!!.tfoodimg)
                val senddata=it.recipes[position].extendedIngredients.toList()
                recycler(senddata)
                val sum=Html.fromHtml(it.recipes[position].instructions).toString()
                binding!!.summary.text=sum

            }))
            "rec"->(
                    viewModel.data.observe(viewLifecycleOwner,{
                        binding!!.title.text=it.recipes[position].title
                        Picasso.get().load(it.recipes[position].image).into(binding!!.tfoodimg)
                        val senddata=it.recipes[position].extendedIngredients.toList()
                        recycler(senddata)
                        val sum=Html.fromHtml(it.recipes[position].instructions).toString()
                        binding!!.summary.text=sum

                    }))
            else->(viewModel.roomdata.observe(viewLifecycleOwner,{
                    binding!!.title.text=it[position].name
                    Picasso.get().load(it[position].image).into(binding!!.tfoodimg)
                    val sum=Html.fromHtml(it[position].summary).toString()
                    binding!!.summary.text=sum

                }))
            }



        binding!!.back.setOnClickListener {
            findNavController().popBackStack()
        }



        return binding!!.root
    }
    private fun recycler(data: List<ExtendedIngredient>){
        binding!!.ingrec.adapter=detailAdapter(requireContext(),data)
        binding!!.ingrec.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }


}
