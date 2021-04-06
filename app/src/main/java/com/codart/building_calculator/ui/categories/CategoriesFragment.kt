package com.codart.building_calculator.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codart.building_calculator.R
import com.codart.building_calculator.ui.CategoriesAdapter


class CategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id=requireActivity().intent.getIntExtra("id",1)
        if(id == 3 || id == 4)
        {
            val pair=Pair<String, Int>("id", id)
            findNavController().navigate(R.id.action_mainFragment_to_formulasFragment, bundleOf(pair))
        }
        setAdapter(id)
        super.onViewCreated(view, savedInstanceState)

    }
    fun setAdapter(id: Int){
        var recyclerView: RecyclerView = requireView().findViewById(R.id.recycler_main)
        var adapter = CategoriesAdapter(requireContext(), findNavController(), id)
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }


}