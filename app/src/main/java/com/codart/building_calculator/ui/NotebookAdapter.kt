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
import com.codart.building_calculator.db.*

class NotebookAdapter(context: Context, navController: NavController): RecyclerView.Adapter<NotebookAdapter.NotebookViewHolder>() {
    val data: MutableList<Notebook> = NotebookDB.getItems()
    val navController=navController
    var context: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotebookViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.cell_notes, parent, false)
        return NotebookViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotebookViewHolder, position: Int) {
        holder.txtDescription.text= ""
        holder.txtTitle.text=data[position].title
        holder.txtPrice.text=""
        holder.txtNumber.text=(position+1).toString()+"."
        holder.layout.setOnClickListener {
            val pair=Pair<String, Int>("id", position)
            navController.navigate(R.id.action_notebookFragment_to_notebookAddFragment, bundleOf(pair))
        }
        //Log.d("NOTEBOOk", data[0].title)

    }
    override fun getItemCount(): Int = data.size

    class NotebookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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