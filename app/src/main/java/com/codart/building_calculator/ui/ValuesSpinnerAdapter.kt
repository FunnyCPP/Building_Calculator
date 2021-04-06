package com.codart.building_calculator.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.codart.building_calculator.R

class ValuesSpinnerAdapter(val context: Context, var dataSource: Array<String>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val vh: ValuesSpinnerAdapter.ItemHolder
        if (convertView == null) {
            view = if(position==0)
                inflater.inflate(R.layout.spinner_item, parent, false)
            else
                inflater.inflate(R.layout.spinner_item, parent, false)
            vh = ValuesSpinnerAdapter.ItemHolder(view, position)
            view?.tag = vh

        } else {
            view = convertView
            vh = view.tag as ValuesSpinnerAdapter.ItemHolder
        }
        vh.label.text = dataSource[position]


        return view
    }


    override fun getItem(position: Int): Any? {
        return dataSource[position];
    }

    override fun getCount(): Int {
        return dataSource.size;
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    private class ItemHolder(row: View?, position: Int) {
        val label: TextView = if(position==0)
            row?.findViewById(R.id.txt_spinner) as TextView
        else
            row?.findViewById(R.id.txt_spinner) as TextView

    }



}