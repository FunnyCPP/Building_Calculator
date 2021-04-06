package com.codart.building_calculator.ui.calculations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.codart.building_calculator.R


class CalculationsFragment6 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner
    private lateinit var spinner5: Spinner
    //private lateinit var input1: EditText
    //private lateinit var input2: EditText
   // private lateinit var input3: EditText
    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView

    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations6, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations6)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations6)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations6)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations6)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations6)

        //input1 =requireView().findViewById(R.id.calculations6_sizeA)
        //input2 =requireView().findViewById(R.id.calculations6_sizeB)
        //nput3 =requireView().findViewById(R.id.calculations6_sizeC)


        result1 =requireView().findViewById(R.id.calculations6_result1)
        result2 =requireView().findViewById(R.id.calculations6_result2)
        result3 =requireView().findViewById(R.id.calculations6_result3)
        result4 =requireView().findViewById(R.id.calculations6_result4)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations6)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations6)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations6)


        super.onViewCreated(view, savedInstanceState)
    }
}