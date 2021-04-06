package com.codart.building_calculator.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.codart.building_calculator.R
import com.codart.building_calculator.db.Advices
import com.codart.building_calculator.db.Note
import com.codart.building_calculator.db.NoteDB

class AdvicesAdapter(context: Context): RecyclerView.Adapter<AdvicesAdapter.AdvicesViewHolder>() {
    val data: MutableList<Note> = NoteDB.getItems()
    var context: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvicesViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.cell_usefultoknow, parent, false)
        return AdvicesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdvicesViewHolder, position: Int) {
        holder.txtDescription.text= Advices.infos[position]
        holder.txtTitle.text=Advices.titles[position]
        holder.layout.setOnClickListener {
            val intent= Intent(context,AdviceActivity::class.java)
            intent.putExtra("id", position)
            context.startActivity(intent)
        }
        //Log.d("NOTE", data[0].title)

    }
    override fun getItemCount(): Int = 2

    class AdvicesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView
        var txtDescription: TextView
        var  layout: ConstraintLayout
        init {
            txtDescription = itemView.findViewById(R.id.txt_cell_uToKnow_desc)
            txtTitle  = itemView.findViewById(R.id.txt_cell_uToKnow_title)
            layout =itemView.findViewById(R.id.layout_uToKnow)
        }
    }

}