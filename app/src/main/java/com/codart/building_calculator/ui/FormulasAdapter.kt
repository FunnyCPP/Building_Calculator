package com.codart.building_calculator.ui

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.codart.building_calculator.R
import com.codart.building_calculator.db.CategoriesGeneration
import com.codart.building_calculator.db.Category
import java.lang.Exception

class FormulasAdapter(context: Context, navController: NavController, id: Int): RecyclerView.Adapter<FormulasAdapter.FormulasViewHolder>() {
    val id=id
    val data: MutableList<Category> = CategoriesGeneration.getData(id)
    var context: Context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormulasViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.cell_formulas, parent, false)
        return FormulasViewHolder(view)
    }

    override fun onBindViewHolder(holder: FormulasViewHolder, position: Int) {
        var position=position
        if(data[position].id==6 && data[position-1].titleCategory=="расчет состава бетона")
        {
            holder.layout.visibility=View.GONE
        }
        if(data[position].titleCategory=="расчет состава бетона")
        {
            position += 1
        }
        try{

            val imageTitle= data[position].imageName
            val imageId=context.resources.getIdentifier(imageTitle, "drawable", context.packageName)

            holder.imgIcon.setImageResource(imageId)
            holder.txtTitle.text=data[position].titleCategory
            holder.layout.setOnClickListener {
                val intent = Intent(context, CalculationsActivity::class.java)
                intent.putExtra("id", data[position].id)
                context.startActivity(intent)
                Log.e("Position Formulas",id.toString())
            }
        }
        catch (e:Exception)
        {
            Log.e("Position Formulas",id.toString())
        }

        Log.d("Title",data[0].titleCategory)
    }
    override fun getItemCount(): Int = data.size

    class FormulasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgIcon: ImageView
        var txtTitle: TextView
        var  layout: ConstraintLayout




        init {
            imgIcon = itemView.findViewById(R.id.imgIcon_formulas)
            txtTitle  = itemView.findViewById(R.id.txtTitle_formulas)
            layout = itemView.findViewById(R.id.layout_formulas)




        }
    }

}