package com.codart.building_calculator.ui

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.codart.building_calculator.R
import com.codart.building_calculator.db.CategoriesGeneration
import com.codart.building_calculator.db.Category

class ImageSoloAdapter(context: Context, navController: NavController, id: Int): RecyclerView.Adapter<ImageSoloAdapter.ImageSoloViewHolder>() {
    val id=id
    val data: MutableList<Category> = CategoriesGeneration.getData(id)
    var context: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSoloViewHolder {
        val view: View =
                LayoutInflater.from(context).inflate(R.layout.cell_img_solo, parent, false)
        return ImageSoloViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageSoloViewHolder, position: Int) {
        var imageTitle= data[position].imageName
        var imageId=context.resources.getIdentifier(imageTitle, "drawable", context.packageName)
        holder.img1.setImageResource(imageId)
        holder.layout1.setOnClickListener {
            val intent = Intent(context, CalculationsActivity::class.java)
            intent.putExtra("id", data[position].id)
            context.startActivity(intent)
            Log.e("Position Formulas",id.toString())
        }

    }
    override fun getItemCount(): Int = data.size

    class ImageSoloViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img1: ImageView
        var layout1: ConstraintLayout

        init {
            img1=itemView.findViewById(R.id.img_solo_cell)
            layout1=itemView.findViewById(R.id.layout_solo_cell)

        }
    }

}