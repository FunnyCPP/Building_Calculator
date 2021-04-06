package com.codart.building_calculator.ui.notebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import com.codart.building_calculator.R
import com.codart.building_calculator.ui.MainActivity
import com.codart.building_calculator.ui.notes.NotesActivity

class NotebookActivity : AppCompatActivity() {
    private var toogle: ActionBarDrawerToggle? = null
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var imgNotes: ImageView
    lateinit var imgHome: ImageView
    lateinit var imgNotebook: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notebook)
        toolbar=findViewById(R.id.toolbar_notebook)
        drawerLayout = findViewById(R.id.drawer_layout_notebook)
        toogle = ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0)
        drawerLayout.addDrawerListener(toogle!!)
        toogle!!.syncState()
        imgNotes= findViewById(R.id.img_notes2)
        imgHome=findViewById(R.id.img_home2)
        imgNotebook=findViewById(R.id.img_notebook2)
        val btnAdd= findViewById<ImageView>(R.id.img_notebook_add)
        val navController = Navigation.findNavController(this,R.id.fragment_notebook)
        btnAdd.setOnClickListener {
            navController.navigate(R.id.action_notebookFragment_to_notebookAddFragment)
        }
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