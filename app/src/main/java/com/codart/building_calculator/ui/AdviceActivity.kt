package com.codart.building_calculator.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.codart.building_calculator.R
import com.codart.building_calculator.db.Advices
import com.codart.building_calculator.ui.notebook.NotebookActivity
import com.codart.building_calculator.ui.notes.NotesActivity

class AdviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advice)
        val position = intent.getIntExtra("id", 0)
        val title: TextView=findViewById(R.id.txt_title_advice)
        val info: TextView=findViewById(R.id.txt_info_advice)
        val imgNote: ImageView=findViewById(R.id.imgBottomNote_advice)
        val imgHome: ImageView=findViewById(R.id.imgBottomHome_advice)
        val imgNotebook: ImageView=findViewById(R.id.imgBottomNotebook_advice)
        val toolbar: androidx.appcompat.widget.Toolbar=findViewById(R.id.toolbar_advice)
        imgNote.setOnClickListener {
            startActivity(Intent(this,NotesActivity::class.java))
        }
        imgHome.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        imgNotebook.setOnClickListener {
            startActivity(Intent(this,NotebookActivity::class.java))
        }
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onBackPressed()
            }
        })
        title.setText(Advices.titles[position])
        info.setText(Advices.infos[position])
    }
}