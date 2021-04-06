package com.codart.building_calculator.ui.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.codart.building_calculator.R
import com.codart.building_calculator.ui.MainActivity
import com.codart.building_calculator.ui.notebook.NotebookActivity

class NotesActivity : AppCompatActivity() {
    private var toogle: ActionBarDrawerToggle? = null
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var navView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var imgNotes: ImageView
    lateinit var imgHome: ImageView
    lateinit var imgNotebook: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        drawerLayout = findViewById(R.id.drawer_layout_notes)
        toolbar=findViewById(R.id.toolbar_notes)
        toogle = ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0)
        drawerLayout.addDrawerListener(toogle!!)
        toogle!!.syncState()
        imgNotes= findViewById(R.id.img_notes3)
        imgHome=findViewById(R.id.img_home3)
        imgNotebook=findViewById(R.id.img_notebook3)
        setBottomBar()

    }
    fun setBottomBar(){
        imgNotes.setOnClickListener{
            val i: Intent = Intent(this, NotesActivity::class.java)
            startActivity(i)
        }
        imgHome.setOnClickListener{
            val i: Intent = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        imgNotebook.setOnClickListener{
            val i: Intent = Intent(this, NotebookActivity::class.java)
            startActivity(i)
        }
    }

}