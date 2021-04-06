package com.codart.building_calculator.ui.notebook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.codart.building_calculator.R
import com.codart.building_calculator.db.Notebook
import com.codart.building_calculator.db.NotebookDB

val ID="ID"
class NotebookAddFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var position: Int? = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(ID, -1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notebook_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnSave: AppCompatButton=requireView().findViewById(R.id.btn_save_notebook)
        val btnClose: AppCompatButton=requireView().findViewById(R.id.btn_cancel_notebook)
        val input1 : TextInputEditText=requireView().findViewById(R.id.input1_notebook)
        val input2 : TextInputEditText=requireView().findViewById(R.id.input2_notebook)
        if(position!=-1)
        {
            val data= NotebookDB.getItems()
            input1.setText(data[position!!].title)
            input2.setText(data[position!!].text)
        }
        btnSave.setOnClickListener {
            if(position!=-1)
            {
                NotebookDB.removeItem(NotebookDB.getItems()[position!!])
            }
            val title=input1.text.toString()
            val text=input2.text.toString()
            NotebookDB.addItem(Notebook(title,text))
            findNavController().navigateUp()
        }
        btnClose.setOnClickListener {
            findNavController().navigateUp()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            NotebookAddFragment().apply {
                arguments = Bundle().apply {
                    putInt(ID, param1)
                }
            }
    }
}