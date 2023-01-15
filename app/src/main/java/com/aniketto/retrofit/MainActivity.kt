package com.aniketto.retrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory as GsonGsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.aniketto.retrofit.R.layout.activity_main)

        // hiding SUPPORT BAR and ACTION BAR
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        getMydata()
    }

    private fun getMydata() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(APIinterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<myDataItem>?> {
            override fun onResponse(
                call: Call<List<myDataItem>?>,
                response: Response<List<myDataItem>?>
            ) {
                val responseBody = response.body()!!
                val StringBuilder = StringBuilder()
                for (myData in responseBody){
                    StringBuilder.append(myData.id)
                    StringBuilder.append("\n")
                }
                tvMyid.text = StringBuilder
            }

            override fun onFailure(call: Call<List<myDataItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure"+t.message)
            }
        })
    }
}