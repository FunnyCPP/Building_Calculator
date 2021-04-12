package com.codart.building_calculator.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.codart.building_calculator.R
import com.codart.building_calculator.ui.notebook.NotebookActivity
import com.codart.building_calculator.ui.notes.NotesActivity
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

class MainActivity : AppCompatActivity() {
    private var toogle: ActionBarDrawerToggle? = null
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var navView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var imgNotes: ImageView
    lateinit var imgHome: ImageView
    lateinit var imgNotebook: ImageView
    lateinit var layoutMain: RelativeLayout
    lateinit var layoutMetal: RelativeLayout
    lateinit var layoutSquares: RelativeLayout
    lateinit var layoutConverters: RelativeLayout
    lateinit var popup: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        toogle = ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0)
        drawerLayout.addDrawerListener(toogle!!)
        toogle!!.syncState()
        imgNotes= findViewById(R.id.imgBottomMetals)
        imgHome=findViewById(R.id.imgBottomHome)
        imgNotebook=findViewById(R.id.imgBottomSquares_advice)
        layoutMain= findViewById(R.id.layout_main)
        layoutMetal= findViewById(R.id.layout_metal)
        layoutSquares= findViewById(R.id.layout_squares)
        layoutConverters= findViewById(R.id.layout_convertors)
        popup= findViewById(R.id.popup_noads)
        setBottomBar()
        setCategoriesOnClickEvents()
        setAdvicesRecycler()
        setDrawer()

    }
    fun setDrawer(){
        popup.setOnClickListener{
            val i: Intent = Intent(this, SubscribeActivity::class.java)
            startActivity(i)
        }
    }
    fun setCategoriesOnClickEvents(){
        layoutMain.setOnClickListener{
            val i: Intent = Intent(this, CategoriesActivity::class.java)
            i.putExtra("id",1)
            startActivity(i)
        }
        layoutMetal.setOnClickListener{
            val i: Intent = Intent(this, CategoriesActivity::class.java)
            i.putExtra("id",2)
            startActivity(i)
        }
        layoutSquares.setOnClickListener{
            val i: Intent = Intent(this, CategoriesActivity::class.java)
            i.putExtra("id",3)
            startActivity(i)
        }
        layoutConverters.setOnClickListener{
            val i: Intent = Intent(this, CategoriesActivity::class.java)
            i.putExtra("id",4)
            startActivity(i)
        }
    }
    fun setBottomBar(){
        imgNotes.setOnClickListener{
            val i: Intent = Intent(this, NotesActivity::class.java)
            startActivity(i)
        }
        imgNotebook.setOnClickListener{
            val i: Intent = Intent(this, NotebookActivity::class.java)
            startActivity(i)
        }
    }
    fun setAdvicesRecycler()
    {
        val recycler=findViewById<RecyclerView>(R.id.recycler_advices)
        val adapter  = AdvicesAdapter(this)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = adapter
        recycler.layoutManager = layoutManager
    }
}