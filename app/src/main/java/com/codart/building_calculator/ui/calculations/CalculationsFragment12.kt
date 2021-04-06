package com.codart.building_calculator.ui.calculations

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.doAfterTextChanged
import com.codart.building_calculator.R
import com.codart.building_calculator.calculations.Round
import com.codart.building_calculator.db.Note
import com.codart.building_calculator.db.NoteDB
import com.codart.building_calculator.ui.MainActivity
import com.codart.building_calculator.ui.SpinnerAdapter
import kotlin.math.floor


class CalculationsFragment12 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: TextView
    private lateinit var spinner3: TextView
    private lateinit var spinner4: TextView

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText

    private lateinit var result1: TextView

    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox

    private lateinit var txt1: TextView
    private lateinit var txt2: TextView
    private lateinit var txt3: TextView
    private lateinit var txt4: TextView
    var a=0
    var b=0
    var c=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations12, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations12)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations12)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations12)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations12)


        input1 =requireView().findViewById(R.id.calculations12_input1)
        input2 =requireView().findViewById(R.id.calculations12_input2)
        input3 =requireView().findViewById(R.id.calculations12_input3)

        result1 =requireView().findViewById(R.id.calculations12_result1)

        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations12)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations12)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations12)

        checkBox1=requireView().findViewById(R.id.calculations12_checkBox1)
        checkBox2=requireView().findViewById(R.id.calculations12_checkBox2)

        txt1=requireView().findViewById(R.id.txt1_calculations12)
        txt2=requireView().findViewById(R.id.txt2_calculations12)
        txt3=requireView().findViewById(R.id.txt3_calculations12)
        txt4=requireView().findViewById(R.id.txt4_calculations12)

        setCheckBoxes()
        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && checkBox2.isChecked ) {
            calculate1to6results()
        }
        else if(checkBox1.isChecked)
            calculate1to6results()

    }
    private fun calculate1to6results(){
        setSizeOfBrick()
        val d=((a*c*b)/1000000000.0)*0.76
        val res1=1/d

        result1.text = "${Round.round(res1)} шт"


    }
    private fun setSizeOfBrick(){
        if(checkBox2.isChecked) {
            a = input1.text.toString().toInt()
            b = input2.text.toString().toInt()
            c = input3.text.toString().toInt()
        }
        else
        {
            when(spinner1.selectedItemPosition){
                0->{a=250;b=120;c=65}
                1->{a=250;b=120;c=88}
                2->{a=250;b=120;c=140}
                3->{a=250;b=85;c=65}
                4->{a=288;b=63;c=138}
                5->{a=250;b=120;c=138}
                6->{a=250;b=200;c=70}
                7->{a=390;b=190;c=188}
                8->{a=400;b=200;c=200}
                9->{a=600;b=100;c=250}
                10->{a=600;b=100;c=300}
                11->{a=600;b=150;c=250}
                12->{a=600;b=200;c=200}
                13->{a=600;b=200;c=250}
                14->{a=600;b=200;c=300}
                15->{a=600;b=240;c=250}
                16->{a=600;b=300;c=200}
                17->{a=600;b=300;c=250}
                18->{a=600;b=400;c=250}
                19->{a=600;b=400;c=300}
            }
        }
    }


    private fun setSpinnersAdapters(){
        val array=resources.getStringArray(R.array.calculations11_array1)
        val adapter = SpinnerAdapter(requireContext(), array)
        spinner1.adapter=adapter
    }
    private fun setBottomButtons(){
        setCopyButton()
        setHomeButton()
        setSaveButton()
    }
    private fun setSaveButton(){
        imgBottomSave.setOnClickListener {
            getTitleFromDialog()

        }
    }
    private fun setCopyButton(){
        val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        imgBottomCopy.setOnClickListener {
            val textToCopy = getInfoResultAboutCalculations()
            val clip = ClipData.newPlainText("RANDOM UUID", textToCopy)
            clipboard.setPrimaryClip(clip)
        }

    }
    private fun setHomeButton(){
        imgBottomHome.setOnClickListener {
            requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
        }
    }
    private fun getInfoAboutCalculations(): String{
        if(checkBox1.isChecked)
        {
            val input=requireContext().resources.getString(R.string.calculation11_text1)+" "+requireContext().resources.
            getStringArray(R.array.calculations11_array1)[spinner1.selectedItemPosition]
            val res=requireContext().resources.getString(R.string.calculation11_text5)+" "+result1.text.toString()+" шт"
            return """
            $input           
            $res
        """.trimIndent()
        }
        else{
            val input1Value=requireContext().resources.getString(R.string.calculation11_text2)+" "+input1.text.toString()+" мм"
            val input2Value=requireContext().resources.getString(R.string.calculation11_text3)+" "+input2.text.toString()+" мм"
            val input3Value=requireContext().resources.getString(R.string.calculation11_text4)+" "+input3.text.toString()+" мм"
            val res=requireContext().resources.getString(R.string.calculation11_text5)+" "+result1.text.toString()+" шт"
            return """
            $input1Value
            $input2Value
            $input3Value
            $res
        """.trimIndent()
        }



    }
    private fun getInfoResultAboutCalculations(): String{
        val res1Value=requireContext().resources.getString(R.string.calculation11_text5)+" "+result1.text.toString()

        return """"
            $res1Value     
        """.trimIndent()
    }
    private fun getTitleFromDialog(): String {
        var title = ""
        //Inflate the dialog with custom view
        val mDialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(requireContext())
            .setView(mDialogView)
            .setTitle("Название заметки")
        //show dialog
        val mAlertDialog = mBuilder.show()
        //login button click of custom layout

        mDialogView.findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnSave).setOnClickListener {
            //dismiss dialog
            title = mDialogView.findViewById<EditText>(R.id.txtDialogTitle).text.toString()
            if(title!="") {
                val info = getInfoAboutCalculations()
                val id = 11
                val note = Note(title, info, id, "")
                NoteDB.addItem(note)
                val toast = Toast.makeText(requireContext(), "Заметка успешно сохранена", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.TOP, 0, 0)
                toast.show()
            }
            else {
                val toast = Toast.makeText(requireContext(), "Сохранение не удалось", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)
                toast.show()
            }
            mAlertDialog.dismiss()

        }
        //cancel button click of custom layout
        mDialogView.findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnClose).setOnClickListener {
            //dismiss dialog
            mAlertDialog.dismiss()

        }
        return title
    }
    private fun checkFields(){
        input1.doAfterTextChanged {
            checkMetricFields()
        }
        input2.doAfterTextChanged {
            checkMetricFields()
        }
        input3.doAfterTextChanged {
            checkMetricFields()
        }
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
    }
    fun setCheckBoxes()
    {
        checkBox1.setOnCheckedChangeListener { buttonView, isChecked -> if(isChecked) {
            checkBox1.isChecked = true
            checkBox2.isChecked = false
            txt1.visibility = View.VISIBLE
            txt2.visibility = View.GONE
            txt3.visibility = View.GONE
            txt4.visibility = View.GONE
            spinner1.visibility = View.VISIBLE
            input1.visibility = View.GONE
            input2.visibility = View.GONE
            input3.visibility = View.GONE
            spinner2.visibility = View.GONE
            spinner3.visibility = View.GONE
            spinner4.visibility = View.GONE
        }

        }
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                checkBox1.isChecked = false
                checkBox2.isChecked = true
                txt1.visibility = View.GONE
                txt2.visibility = View.VISIBLE
                txt3.visibility = View.VISIBLE
                txt4.visibility = View.VISIBLE
                spinner1.visibility = View.GONE
                input1.visibility = View.VISIBLE
                input2.visibility = View.VISIBLE
                input3.visibility = View.VISIBLE
                spinner2.visibility = View.VISIBLE
                spinner3.visibility = View.VISIBLE
                spinner4.visibility = View.VISIBLE
            }

        }
    }

}