package com.codart.building_calculator.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.codart.building_calculator.R
import com.codart.building_calculator.db.CategoriesGeneration
import com.codart.building_calculator.db.Note
import com.codart.building_calculator.db.NoteDB

class NoteAdapter(context: Context,  navController: NavController): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    val data: MutableList<Note> = NoteDB.getItems()
    val navController=navController
    var context: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.cell_notes, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.txtDescription.text=CategoriesGeneration.calculations[data[position].id-1]
        holder.txtTitle.text=data[position].title
        holder.txtPrice.text=data[position].price
        holder.txtNumber.text=(position+1).toString()+"."
        holder.layout.setOnClickListener {
            val pair=Pair<String, Int>("id", position)
            navController.navigate(R.id.action_noteFragment_to_noteShowFragment, bundleOf(pair))
        }
        //Log.d("NOTE", data[0].title)

    }
    override fun getItemCount(): Int = data.size

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView
        var txtDescription: TextView
        var  txtPrice: TextView
        var  txtNumber: TextView
        var  layout: ConstraintLayout
        init {
            txtDescription = itemView.findViewById(R.id.txtNotesDescription)
            txtTitle  = itemView.findViewById(R.id.txtTitle_notes)
            txtPrice = itemView.findViewById(R.id.txtNotesPrice)
            txtNumber = itemView.findViewById(R.id.txtNumber_notes)
            layout =itemView.findViewById(R.id.cell_note)
        }
    }

}