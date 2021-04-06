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


class CalculationsFragment43 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner7: Spinner
    private lateinit var spinner8: TextView


    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText
    private lateinit var input5: EditText
    private lateinit var input6: EditText
    private lateinit var input7: EditText

    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView
    private lateinit var result5: TextView
    private lateinit var result7: TextView


    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    private lateinit var txt: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations43, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations43)
        spinner7 =requireView().findViewById(R.id.spinner7_calculations43)
        spinner8 =requireView().findViewById(R.id.spinner8_calculations43)


        input1 =requireView().findViewById(R.id.calculations43_input1)
        input2 =requireView().findViewById(R.id.calculations43_input2)
        input3 =requireView().findViewById(R.id.calculations43_input3)
        input4 =requireView().findViewById(R.id.calculations43_input4)
        input5 =requireView().findViewById(R.id.calculations43_input5)
        input6 =requireView().findViewById(R.id.calculations43_input6)
        input7 =requireView().findViewById(R.id.calculations43_input7)


        result1 =requireView().findViewById(R.id.calculations43_result1)
        result2 =requireView().findViewById(R.id.calculations43_result2)
        result3 =requireView().findViewById(R.id.calculations43_result3)
        result4 =requireView().findViewById(R.id.calculations43_result4)
        result5 =requireView().findViewById(R.id.calculations43_result5)
        result7 =requireView().findViewById(R.id.calculations43_result7)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations43)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations43)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations43)

        txt =requireView().findViewById(R.id.txt_calculations43)

        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty()  && input3.text.isNotEmpty()) {
            calculate1to2results()
            if(input4.text.isNotEmpty())
            {
                calculate3results()
            }
            if(input5.text.isNotEmpty())
            {
                calculate4to5results()
            }
            if(input6.text.isNotEmpty()  && spinner7.selectedItemPosition!=2|| spinner7.selectedItemPosition==2 && input6.text.isNotEmpty() && input7.text.isNotEmpty()  )
            {
                calculate6to7results()
            }
        }
    }
    private fun calculate1to2results(){
        val a=input1.text.toString().toDouble()
        val b=input2.text.toString().toDouble()
        val c=input3.text.toString().toDouble()
        val res1= b*c/1000
        val res2=a*res1
        result1.text = "${Round.round(res1)} м3"
        result2.text = "${Round.round(res2)} кг"


    }
    private fun calculate3results(){
        val a=input1.text.toString().toDouble()
        val b=input2.text.toString().toDouble()
        val c=input3.text.toString().toDouble()
        val d=input4.text.toString().toDouble()
        val res1= b*c/1000
        val res3=res1*d
        val res2=a*res3
        result3.text = "${Round.round(res3)} м3"
        result2.text = "${Round.round(res2)} кг"

    }
    private fun calculate4to5results(){
        val a=input1.text.toString().toDouble()
        val b=input2.text.toString().toDouble()
        val c=input3.text.toString().toDouble()
        val d=if(input4.text.isNotEmpty())
            input4.text.toString().toDouble()
        else
            1.0
        val e=input5.text.toString().toDouble()
        val res1= b*c/1000

        val res3=res1*d
        val res2=a*res3
        val res4=e/1000*a
        val res5=res2/res4
        result4.text = "${Round.round(res4)} кг"
        result5.text = "${Round.round(res5)}"


    }
    private fun calculate6to7results(){
        val a=input1.text.toString().toDouble()
        val b=input2.text.toString().toDouble()
        val c=input3.text.toString().toDouble()
        val d=if(input4.text.isNotEmpty())
            input4.text.toString().toDouble()
        else
            1.0
        val n=if(input7.text.isNotEmpty())
        {
            input7.text.toString().toDouble()
        }
        else
            0.0
        val p=input6.text.toString().toDouble()
        val res1= b*c/1000

        val res3=res1*d
        val res2=a*res3
        val res6=res2/n
        val res7=when(spinner7.selectedItemPosition)
        {
            0->{res3*p}
            1->{res2*p/1000}
            2->{res6*p}
            else->0.0
        }

        result7.text = "${Round.round(res7)} "


    }
    fun setInput1(){
        input1.setText(when(spinner1.selectedItemPosition)
        {
            0->"1625"
            1->"1630"
            2->"1600"
            3->"1400"
            4->"500"
            5->"14790"
            6->"2210"
            7->"2210"
            8->"3370"
            9->"2300"
            10->"1300"
            else->"0"
        })
    }
    private fun setSpinnersAdapters(){
        var array=resources.getStringArray(R.array.calculations43_array1)
        var adapter2 = SpinnerAdapter(requireContext(), array)
        spinner1.adapter=adapter2
        array=resources.getStringArray(R.array.calculations43_array2)
        adapter2 = SpinnerAdapter(requireContext(), array)
        spinner7.adapter=adapter2
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
    private fun getSpinnerItem(spinner: Spinner): String{
        return when(spinner.selectedItemPosition){
            0 -> "М"
            1 -> "СМ"
            2 -> "ММ"
            else -> ""
        }
    }
    private fun setHomeButton(){
        imgBottomHome.setOnClickListener {
            requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
        }
    }
    private fun getLine(txt: TextView, input: EditText, spinner: Spinner): String
    {
        return txt.text.toString()+" "+input.text+" "+getSpinnerItem(spinner)
    }
    private fun getLine(txt: TextView, input: EditText, s: String): String
    {
        return txt.text.toString()+" "+input.text+" "+s
    }
    private fun getLine(txt: TextView, result: TextView): String
    {
        return txt.text.toString()+" "+result.text
    }
    private fun getLine(txt: String, input: EditText, spinner: Spinner): String
    {
        return txt+" "+input.text+" "+getSpinnerItem(spinner)
    }
    private fun getLine(txt: String, input: EditText, s: String): String
    {
        return txt+" "+input.text+" "+s
    }
    private fun getLine(txt: String, result: TextView): String
    {
        return txt+" "+result.text
    }
    private fun getLine(txt: String, spinner: Spinner): String
    {
        return txt+" "+requireContext().resources.getStringArray(R.array.calculations43_array1)[spinner.selectedItemPosition]
    }
    private fun getInfoAboutCalculations(): String{
        return """
            ${getLine(requireContext().resources.getString(R.string.calculation43_text1), spinner1)}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text2), input1, "кг")}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text3), input2, "м2")}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text4), input3, "мм")}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text5), input4, "")}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text6), input5, "л")}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text7), input6, "руб")}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text8), input7, "кг")}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text9), result1)}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text10), result2)}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text11), result3)}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text12), result4)}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text13), result5)}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text15), result7)}         
        """.trimIndent()
    }
    private fun getInfoResultAboutCalculations(): String{
        return """"
            ${getLine(requireContext().resources.getString(R.string.calculation43_text9), result1)}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text10), result2)}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text11), result3)}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text12), result4)}
            ${getLine(requireContext().resources.getString(R.string.calculation43_text13), result5)}         
            ${getLine(requireContext().resources.getString(R.string.calculation43_text15), result7)}  
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
                val id = 43
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
        input4.doAfterTextChanged {
            checkMetricFields()
        }
        input5.doAfterTextChanged {
            checkMetricFields()
        }
        input6.doAfterTextChanged {
            checkMetricFields()
        }
        input7.doAfterTextChanged {
            checkMetricFields()
        }
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                setInput1()
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                checkMetricFields()
                if(spinner7.selectedItemPosition==2)
                {
                    txt.visibility=View.VISIBLE
                    input7.visibility=View.VISIBLE
                    spinner8.visibility=View.VISIBLE
                }
                else
                {
                    txt.visibility=View.GONE
                    input7.visibility=View.GONE
                    spinner8.visibility=View.GONE
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
    }
}