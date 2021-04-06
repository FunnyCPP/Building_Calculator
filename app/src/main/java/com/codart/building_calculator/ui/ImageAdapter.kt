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

class ImageAdapter(context: Context, navController: NavController, id: Int): RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    val id=id
    val data: MutableList<Category> = CategoriesGeneration.getData(id)
    var context: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view: View =
                LayoutInflater.from(context).inflate(R.layout.cell_img, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        var position=position*2
        var imageTitle= data[position].imageName
        var imageId=context.resources.getIdentifier(imageTitle, "drawable", context.packageName)
        holder.img1.setImageResource(imageId)
        imageTitle= data[position+1].imageName
        imageId=context.resources.getIdentifier(imageTitle, "drawable", context.packageName)
        holder.img2.setImageResource(imageId)
        holder.layout1.setOnClickListener {
            val intent = Intent(context, CalculationsActivity::class.java)
            intent.putExtra("id", data[position].id)
            context.startActivity(intent)
            Log.e("Position Formulas",id.toString())
        }
        holder.layout2.setOnClickListener {
            val intent = Intent(context, CalculationsActivity::class.java)
            intent.putExtra("id", data[position+1].id)
            context.startActivity(intent)
            Log.e("Position Formulas",id.toString())
        }

    }
    override fun getItemCount(): Int = data.size/2

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img1: ImageView
        var img2: ImageView
        var layout1: ConstraintLayout
        var layout2: ConstraintLayout
        init {
            img1=itemView.findViewById(R.id.img1_cell)
            img2=itemView.findViewById(R.id.img2_cell)
            layout1=itemView.findViewById(R.id.layoutImg1)
            layout2=itemView.findViewById(R.id.layoutImg2)
        }
    }

}