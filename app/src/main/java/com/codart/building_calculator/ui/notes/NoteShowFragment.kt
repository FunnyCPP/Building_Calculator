package com.codart.building_calculator.ui.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.codart.building_calculator.R
import com.codart.building_calculator.db.CategoriesGeneration
import com.codart.building_calculator.db.NoteDB


private const val ID = "id"

/**
 * A simple [Fragment] subclass.
 * Use the [NoteShowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoteShowFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val txt=requireView().findViewById<TextView>(R.id.txt_note)
        val text="""
            ${CategoriesGeneration.calculations[param1]}
            ${NoteDB.getItems()[param1].title}
            ${NoteDB.getItems()[param1].info}
        """.trimIndent()
        txt.setText(text)
        super.onViewCreated(view, savedInstanceState)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NoteShowFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int) =
            NoteShowFragment().apply {
                arguments = Bundle().apply {
                    putInt(ID, param1)
                }
            }
    }
}