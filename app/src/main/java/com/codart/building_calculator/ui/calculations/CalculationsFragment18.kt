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
import com.codart.building_calculator.ui.ValuesSpinnerAdapter
import kotlin.math.floor


class CalculationsFragment18 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner
    private lateinit var spinner6: Spinner
    private lateinit var spinner7: Spinner
    private lateinit var spinner8: Spinner

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input4: EditText
    private lateinit var input5: EditText
    private lateinit var input6: EditText
    private lateinit var input7: EditText
    private lateinit var input8: EditText

    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView

    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations18, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations18)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations18)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations18)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations18)
        spinner6 =requireView().findViewById(R.id.spinner6_calculations18)
        spinner7 =requireView().findViewById(R.id.spinner7_calculations18)
        spinner8 =requireView().findViewById(R.id.spinner8_calculations18)



        input1 =requireView().findViewById(R.id.calculations18_input1)
        input2 =requireView().findViewById(R.id.calculations18_input2)
        input4 =requireView().findViewById(R.id.calculations18_input4)
        input5 =requireView().findViewById(R.id.calculations18_input5)
        input6 =requireView().findViewById(R.id.calculations18_input6)
        input7 =requireView().findViewById(R.id.calculations18_input7)
        input8 =requireView().findViewById(R.id.calculations18_input8)


        result1 =requireView().findViewById(R.id.calculations18_result1)
        result2 =requireView().findViewById(R.id.calculations18_result2)
        result3 =requireView().findViewById(R.id.calculations18_result3)
        result4 =requireView().findViewById(R.id.calculations18_result4)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations18)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations18)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations18)

        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input4.text.isNotEmpty() && input6.text.isNotEmpty() && input7.text.isNotEmpty()  ) {
            calculate1to3results()
            if(input5.text.isNotEmpty() && input8.text.isNotEmpty() )
            {
                calculatePriceResults()
            }
        }
    }
    private fun calculate1to3results(){
        val a=getFieldInM(input1, spinner1)
        val b=getFieldInM(input2, spinner2)
        val e=getFieldInM(input4, spinner4)
        val c=getFieldInM(input7, spinner7)
        val d=getFieldInM(input6, spinner6)

        val res1=d*c
        val res2=(c/a)*(d/(b-e))

        result1.text = "${Round.round(res1)} м2"
        result2.text = "${Round.round(res2)} ед"

    }
    private fun calculatePriceResults(){
        val a=getFieldInM(input1, spinner1)
        val b=getFieldInM(input2, spinner2)
        val e=getFieldInM(input4, spinner4)
        val c=getFieldInM(input7, spinner7)
        val d=getFieldInM(input6, spinner6)

        var res1=d*c
        var res2=(c/a)*(d/(b-e))
        var res3=res2/input5.text.toString().toInt()
        var res4=res3*input8.text.toString().toDouble()

        result3.text = "${Round.round(res3)} ед"
        result4.text = "${Round.round(res4)} ${spinner8.selectedItem}"


    }
    private fun getFieldInM(input: EditText, spinner: Spinner): Double
    {
        return when(spinner.selectedItemPosition)
        {
            0->input.text.toString().toDouble()
            1->input.text.toString().toDouble()/100
            2->input.text.toString().toDouble()/1000
            else -> 0.0
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
    private fun setSpinnersAdapters(){
        var array=resources.getStringArray(R.array.array_values)
        var customDropDownAdapter = ValuesSpinnerAdapter(requireContext(), array)
        spinner1.adapter=customDropDownAdapter
        spinner2.adapter=customDropDownAdapter
        spinner3.adapter=customDropDownAdapter
        spinner4.adapter=customDropDownAdapter
        spinner6.adapter=customDropDownAdapter
        spinner7.adapter=customDropDownAdapter
        array=resources.getStringArray(R.array.array_currencies)
        customDropDownAdapter = ValuesSpinnerAdapter(requireContext(), array)
        spinner8.adapter=customDropDownAdapter
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
        val input1Value=requireContext().resources.getString(R.string.calculation18_text1)+" "+input1.text.toString()+" "+getSpinnerItem(spinner1)
        val input2Value=requireContext().resources.getString(R.string.calculation18_text2)+" "+input2.text.toString()+" "+getSpinnerItem(spinner2)
        val input4Value=requireContext().resources.getString(R.string.calculation18_text4)+" "+input4.text.toString()+" "+getSpinnerItem(spinner4)
        val input5Value=requireContext().resources.getString(R.string.calculation18_text5)+" "+input5.text.toString()+" ед"
        val input6Value=requireContext().resources.getString(R.string.calculation18_text5)+" "+input5.text.toString()+" "+getSpinnerItem(spinner6)
        val input7Value=requireContext().resources.getString(R.string.calculation18_text7)+" "+input7.text.toString()+" "+getSpinnerItem(spinner7)
        val input8Value=requireContext().resources.getString(R.string.calculation18_text8)+" "+input8.text.toString()+" руб"

        val res1Value=requireContext().resources.getString(R.string.calculation16_text9)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation16_text10)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation16_text11)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation16_text12)+" "+result4.text.toString()


        return """
            $input1Value
            $input2Value         
            $input4Value
            $input5Value
            $input6Value       
            $input7Value   
            $input8Value   
            $res1Value
            $res2Value
            $res3Value
            $res4Value          
        """.trimIndent()
    }
    private fun getInfoResultAboutCalculations(): String{
        val res1Value=requireContext().resources.getString(R.string.calculation16_text9)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation16_text10)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation16_text11)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation16_text12)+" "+result4.text.toString()

        return """"
            $res1Value
            $res2Value
            $res3Value
            $res4Value
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
                val id = 18
                val note = Note(title, info, id, result4.text.toString())
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
        input8.doAfterTextChanged {
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
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner8.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
    }

}