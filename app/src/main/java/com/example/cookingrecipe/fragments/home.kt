package com.example.cookingrecipe.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cookingrecipe.RecycleAdapters.popularAdapter
import com.example.cookingrecipe.RecycleAdapters.recentAdapter
import com.example.cookingrecipe.RecycleAdapters.trendingadapter
import com.example.cookingrecipe.apidata.recipes
import com.example.cookingrecipe.constants
import com.example.cookingrecipe.databinding.FragmentHomeBinding
import com.example.cookingrecipe.network.api
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


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
        hell()


    }
    fun categorybutton(view:View){


    }

    fun hell() {
        if (constants.isNetworkAvailable(requireContext())) {
            val retrofit:retrofit2.Retrofit=retrofit2.Retrofit.Builder().baseUrl(constants.BASE_URL).addConverterFactory(
                GsonConverterFactory.create())
                .build()
            val service: api = retrofit.create(api::class.java)
            val listcall: Call<recipes> = service.getdata("25",constants.APP_ID)
            listcall.enqueue(object :Callback<recipes>{
                override fun onResponse(call: Call<recipes>, response: Response<recipes>) {
                    if (response!!.isSuccessful){
                        var list=response.body()
                        if (list != null) {
                            val reci=list
                            Log.d("res", "${list}",)
                            binding.popularrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                            binding.popularrecycler.adapter= popularAdapter(requireContext(),reci)
                            binding.trendingrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                            binding.trendingrecycler.adapter= trendingadapter(requireContext(),reci)
                            binding.recentrecycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                            binding.recentrecycler.adapter= recentAdapter(requireContext(),reci)
                        }else {
                            when (response.code()) {
                                400 -> {
                                    Log.i("Error 404", "Not Found")
                                }
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<recipes>, t: Throwable) {
                    Log.e("Errorr", t!!.message.toString())
                }
            })

        } else {

            Toast.makeText(requireContext(), "jkhk", Toast.LENGTH_SHORT).show()
        }

    }


}