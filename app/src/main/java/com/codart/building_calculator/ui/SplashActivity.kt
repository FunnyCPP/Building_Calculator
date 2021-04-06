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
        setContentView(R.layout.activity_splash)
        Paper.init(this)
        val img = findViewById<ImageView>(R.id.img_splash)
        val anim=AnimationUtils.loadAnimation(applicationContext,R.anim.animation)
        img.animation=anim
        val handler = Handler()
        handler.postDelayed({
                            startActivity(Intent(this,MainActivity::class.java))
        },1500)
    }
}