package com.codart.building_calculator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView
import com.codart.building_calculator.R
import com.codart.building_calculator.db.CategoriesGeneration

class CategoriesActivity : AppCompatActivity() {

    private var toogle: ActionBarDrawerToggle? = null
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var navView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var imgMain: ImageView
    lateinit var imgMetals: ImageView
    lateinit var imgHome: ImageView
    lateinit var imgSquares: ImageView
    lateinit var imgConverters: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        imgMain=findViewById(R.id.imgBottomMain)
        imgMetals=findViewById(R.id.imgBottomMetals)
        imgHome=findViewById(R.id.imgBottomHome)
        imgSquares=findViewById(R.id.imgBottomSquares_advice)
        imgConverters=findViewById(R.id.imgBottomConverters)
        imgMain.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            intent.putExtra("id",1)
            startActivity(intent)
        }
        imgMetals.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            intent.putExtra("id",2)
            startActivity(intent)
        }
        imgHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        imgSquares.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            intent.putExtra("id",3)
            startActivity(intent)
        }
        imgConverters.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            intent.putExtra("id",4)
            startActivity(intent)
        }
        toolbar = findViewById(R.id.toolbar_categories)
        setSupportActionBar(toolbar)
        toolbar.title=CategoriesGeneration.getTitle(intent.getIntExtra("id",1))
        drawerLayout = findViewById(R.id.drawer_layout_categories)
        toogle = ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0)
        drawerLayout.addDrawerListener(toogle!!)
        toogle!!.syncState()
        val navController = Navigation.findNavController(this,R.id.fragment_categories)
    }
    fun getMyToolbar(): androidx.appcompat.widget.Toolbar? = toolbar

    override fun onBackPressed() {
        toolbar.title=CategoriesGeneration.getTitle(intent.getIntExtra("id",1))
        if(intent.getIntExtra("id",0)==3 ||intent.getIntExtra("id",0)==4) {
            startActivity(Intent(this, MainActivity::class.java))
        }
        super.onBackPressed()
    }
    companion object{
    }
}