package com.codart.building_calculator.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.codart.building_calculator.R
import com.codart.building_calculator.db.CategoriesGeneration
import com.codart.building_calculator.db.Category

class CategoriesAdapter(context: Context, navController: NavController, id: Int): RecyclerView.Adapter<CategoriesAdapter.MainCategoriesViewHolder>() {
    val data: MutableList<Category> = CategoriesGeneration.getData(id)
    var context: Context = context
    val navController= navController
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCategoriesViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.cell_categories, parent, false)
        return MainCategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainCategoriesViewHolder, position: Int) {
        val imageTitle= data[position].imageName
        val imageId=context.resources.getIdentifier(imageTitle, "drawable", context.packageName)
        holder.imgIcon.setImageResource(imageId)
        holder.txtTitle.text=data[position].titleCategory
        holder.txtDescription.text=data[position].desc
        Log.d("Title",data[0].titleCategory)
        val pair=Pair<String, Int>("id", data[position].id)
        holder.layout.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_formulasFragment, bundleOf(pair))
        }
    }
    override fun getItemCount(): Int = data.size

    class MainCategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgIcon: ImageView
        var txtTitle: TextView
        var txtDescription: TextView
        var layout: ConstraintLayout



        init {
            imgIcon = itemView.findViewById(R.id.imgIcon)
            txtTitle  = itemView.findViewById(R.id.txtTitle)
            txtDescription = itemView.findViewById(R.id.txtNotesDescription)
            layout=itemView.findViewById(R.id.layout_categories)



        }
    }

}