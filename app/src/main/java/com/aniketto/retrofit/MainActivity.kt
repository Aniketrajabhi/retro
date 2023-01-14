package com.aniketto.retrofit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.aniketto.retrofit.R.layout.activity_main)

        // hiding SUPPORT BAR and ACTION BAR
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }


        tvLoginlink.setOnClickListener{
            Intent(this , LoginActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}