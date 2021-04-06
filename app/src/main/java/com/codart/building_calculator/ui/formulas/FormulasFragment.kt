package com.codart.building_calculator.ui.formulas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codart.building_calculator.R
import com.codart.building_calculator.db.CategoriesGeneration
import com.codart.building_calculator.ui.FormulasAdapter
import com.codart.building_calculator.ui.ImageAdapter
import com.codart.building_calculator.ui.ImageSoloAdapter

private const val ID = "id"

class FormulasFragment : Fragment() {

    var categoryId=5
    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            categoryId = it.getInt(ID)
        }
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_formulas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val toolbar: androidx.appcompat.widget.Toolbar? = activity?.findViewById(R.id.toolbar_categories)
        toolbar?.title = CategoriesGeneration.getTitle(categoryId)
        setAdapter()
        super.onViewCreated(view, savedInstanceState)
    }
    fun setAdapter(){
        var recyclerView: RecyclerView = requireView().findViewById(R.id.recycler_formulas)
        if(categoryId==10 || categoryId==3 || categoryId==9)
        {
            var adapter = ImageAdapter(requireContext(), findNavController(), categoryId)
            val layoutManager: RecyclerView.LayoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = layoutManager
        }
        else if(categoryId == 12)
        {
            var adapter = ImageSoloAdapter(requireContext(), findNavController(), categoryId)
            val layoutManager: RecyclerView.LayoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = layoutManager
        }
        else {
            var adapter = FormulasAdapter(requireContext(), findNavController(), categoryId)
            val layoutManager: RecyclerView.LayoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = layoutManager
        }
    }
    companion object {
        fun newInstance(position: String) =
                FormulasFragment().apply {
                    arguments = Bundle().apply {
                        putString(ID, position)
                    }
                }
    }

}