package com.codart.building_calculator.ui.calculations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codart.building_calculator.R
import com.codart.building_calculator.ui.CalculationsActivity
import com.codart.building_calculator.ui.CategoriesAdapter
import com.codart.building_calculator.ui.SpacesAdapter


class SpaceFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_space, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val txt = requireView().findViewById<TextView>(R.id.space_txt)
        val btn = requireView().findViewById<AppCompatButton>(R.id.space_add)
        btn.setOnClickListener {
            findNavController().navigate(R.id.action_spaceFragment_to_addSpaceFragment)
        }
        txt.text="Суммарная Площадь = ${CalculationsActivity.calculateSquare()}м2"
        setAdapter()
        super.onViewCreated(view, savedInstanceState)
    }
    fun setAdapter(){
        val recyclerView: RecyclerView = requireView().findViewById(R.id.space_recycler)
        val adapter = SpacesAdapter(requireContext(), findNavController())
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }


}