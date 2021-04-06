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
import com.codart.building_calculator.models.Space

class SpacesAdapter(var context: Context, val navController: NavController): RecyclerView.Adapter<SpacesAdapter.SpacesViewHolder>() {
    val data: MutableList<Space> = CalculationsActivity.getSpaces()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpacesViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.cell_space, parent, false)
        return SpacesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpacesViewHolder, position: Int) {
        holder.txtTitle.text="${data[position].title} (${data[position].number}шт)"
        holder.txtMain.text="${data[position].length/1000*data[position].height/1000}м2 (${data[position].length} * ${data[position].height}мм)"
        holder.layout.setOnClickListener {
            val pair=Pair("position", position)
            navController.navigate(R.id.action_spaceFragment_to_addSpaceFragment, bundleOf(pair))
        }
        //Log.d("NOTE", data[0].title)

    }
    override fun getItemCount(): Int = data.size

    class SpacesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView = itemView.findViewById(R.id.space_title)
        val txtMain: TextView = itemView.findViewById(R.id.space_main)
        val layout: ConstraintLayout = itemView.findViewById(R.id.layout_space)
    }

}