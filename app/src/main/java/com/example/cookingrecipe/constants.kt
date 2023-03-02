package com.example.cookingrecipe

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.example.cookingrecipe.Room.database
import com.example.cookingrecipe.Room.roomservice
import com.example.cookingrecipe.network.api
import com.example.cookingrecipe.network.retrohelper
import com.example.cookingrecipe.repo.repo

class constants:Application() {


     val APP_ID: String = "0971290cafd74fd10656d504"
     val BASE_URL: String = "https://api.spoonacular.com"

    lateinit var repo: repo

    override fun onCreate() {
        super.onCreate()
        init()
    }

    fun init(){
         val roomservice =database.getDatabase(applicationContext).dao()
         val api= retrohelper.getinstance().create(api::class.java)
         repo=repo(api, roomservice)


    }
    fun isNetworkAvailable(context: Context): Boolean {
        // It answers the queries about the state of network connectivity.
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network      = connectivityManager.activeNetwork ?: return false
            val activeNetWork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            // Returns details about the currently active default data network.
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnectedOrConnecting
        }
    }
}
