package com.codart.building_calculator.ui.calculations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import com.codart.building_calculator.R
import com.codart.building_calculator.models.Space
import com.codart.building_calculator.ui.CalculationsActivity


private const val ARG_PARAM1 = "position"

class AddSpaceFragment : Fragment() {
    private var param1: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_add_space, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val input1 = requireView().findViewById<EditText>(R.id.add_input1)
        val input2 = requireView().findViewById<EditText>(R.id.add_input2)
        val input3 = requireView().findViewById<EditText>(R.id.add_input3)
        val input4 = requireView().findViewById<EditText>(R.id.add_input4)

        fun checkFields(): Boolean =  input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty()

        if (param1 != null) {
            val space = CalculationsActivity.getSpaces()[param1!!]
            input1.setText(space.title)
            input2.setText(space.length.toString())
            input3.setText(space.height.toString())
            input4.setText(space.number.toString())
        }
        val btnSave: AppCompatButton = requireView().findViewById(R.id.add_btn_save)
        val btnClose: AppCompatButton = requireView().findViewById(R.id.add_btn_close)
        btnSave.setOnClickListener {
            var space: Space? = null
            if(checkFields()) {
                val square = input2.text.toString().toDouble()*input3.text.toString().toDouble()/1000/1000
                 space = Space(input1.text.toString(), input2.text.toString().toDouble(), input3.text.toString().toDouble(), square,
                    input4.text.toString().toInt())
            }
            else
            {
                Toast.makeText(requireContext(),"Не все поля заполнены!", Toast.LENGTH_SHORT).show()
            }
            if(param1 != null && checkFields()) {
                CalculationsActivity.editSpace(space!!, param1!!)
            }
            else if(checkFields())
            {
               CalculationsActivity.addSpace(space!!)
            }
            if(checkFields())
                close()
        }
        btnClose.setOnClickListener {
            close()
        }
        super.onViewCreated(view, savedInstanceState)
    }
    fun close(){
        findNavController().navigate(R.id.action_addSpaceFragment_to_spaceFragment)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: Int) =
            AddSpaceFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}