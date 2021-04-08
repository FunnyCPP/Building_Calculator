package com.codart.building_calculator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
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
    lateinit var imgMain: LinearLayout
    lateinit var imgMetals: LinearLayout
    lateinit var imgHome: ImageView
    lateinit var imgSquares: LinearLayout
    lateinit var imgConverters: LinearLayout
    lateinit var main: ImageView
    lateinit var metals: ImageView
    lateinit var squares: ImageView
    lateinit var converters: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        imgMain=findViewById(R.id.layout_main_categories)
        imgMetals=findViewById(R.id.layout_metals_categories)
        imgHome=findViewById(R.id.imgBottomHome)
        imgSquares=findViewById(R.id.layout_squares_categories)
        imgConverters=findViewById(R.id.layout_converters_categories)
        main=findViewById(R.id.imgBottomMain)
        metals=findViewById(R.id.imgBottomMetals)
        squares=findViewById(R.id.imgBottomSquares_advice)
        converters=findViewById(R.id.imgBottomConverters)


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
        when(intent.getIntExtra("id",1)) {
            1 -> main.setImageResource(R.drawable.ic_bottom_main_selected)
            2 -> metals.setImageResource(R.drawable.ic_bottom_metals_selected)
            3 -> squares.setImageResource(R.drawable.ic_bottom_squares_selected)
            4 -> converters.setImageResource(R.drawable.ic_bottom_converters_selected)
        }
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