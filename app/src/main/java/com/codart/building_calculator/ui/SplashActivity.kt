package com.codart.building_calculator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.codart.building_calculator.R
import com.codart.building_calculator.calculations.Round
import io.paperdb.Paper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_splash)
        }
        catch (e: Exception)
        {
            Log.e("Splash set", e.toString())
        }
        try {
            Paper.init(this)
        }
        catch (e: Exception)
        {
            Log.e("Paper init", e.toString())
        }
        try {
            val img = findViewById<ImageView>(R.id.img_splash)
            val anim = AnimationUtils.loadAnimation(applicationContext, R.anim.animation)
            img.animation = anim
        }
        catch (e: java.lang.Exception){
            Log.e("Anim set", e.toString())
        }
        val handler = Handler()
        handler.postDelayed({
                            startActivity(Intent(this,MainActivity::class.java))
        },1500)
    }
}