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
import kotlin.math.ceil
import kotlin.math.floor


class CalculationsFragment14 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner
    private lateinit var spinner5: Spinner
    private lateinit var spinner7: Spinner

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText
    private lateinit var input5: EditText
    private lateinit var input6: EditText
    private lateinit var input7: EditText
    private lateinit var input8: EditText


    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView
    private lateinit var result5: TextView
    private lateinit var result6: TextView
    private lateinit var result7: TextView
    private lateinit var result8: TextView
    private lateinit var result9: TextView

    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    //private lateinit var checkBox1: CheckBox
    //private lateinit var checkBox2: CheckBox



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations14, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations14)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations14)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations14)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations14)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations14)
        spinner7 =requireView().findViewById(R.id.spinner7_calculations14)

        input1 =requireView().findViewById(R.id.calculations14_input1)
        input2 =requireView().findViewById(R.id.calculations14_input2)
        input3 =requireView().findViewById(R.id.calculations14_input3)
        input4 =requireView().findViewById(R.id.calculations14_input4)
        input5 =requireView().findViewById(R.id.calculations14_input5)
        input6 =requireView().findViewById(R.id.calculations14_input6)
        input7 =requireView().findViewById(R.id.calculations14_input7)
        input8 =requireView().findViewById(R.id.calculations14_input8)


        result1 =requireView().findViewById(R.id.calculations14_result1)
        result2 =requireView().findViewById(R.id.calculations14_result2)
        result3 =requireView().findViewById(R.id.calculations14_result3)
        result4 =requireView().findViewById(R.id.calculations14_result4)
        result5 =requireView().findViewById(R.id.calculations14_result5)
        result6 =requireView().findViewById(R.id.calculations14_result6)
        result7 =requireView().findViewById(R.id.calculations14_result7)
        result8 =requireView().findViewById(R.id.calculations14_result8)
        result9 =requireView().findViewById(R.id.calculations14_result9)

        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations14)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations14)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations14)

        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()  ) {
            calculate1to3results()
            if(input4.text.isNotEmpty() && input5.text.isNotEmpty() && input6.text.isNotEmpty() )
            {
                calculate4to7results()
                if( input7.text.isNotEmpty() && input8.text.isNotEmpty())
                {
                    calculate8to9results()
                }
            }
        }

    }
    private fun calculate1to3results(){
        val a=getFieldInM(input1, spinner1)
        val b=getFieldInM(input2, spinner2)
        val c=getFieldInM(input3, spinner3)

        val res1=a*b
        val res2=a*b*c
        val res3=1/res2

        result1.text = "${Round.round(res1)} м2"
        result2.text = "${Round.round(res2)} м3"
        result3.text = "${Round.round(res3)}"




    }
    private fun calculate4to7results(){
        val a=getFieldInM(input1, spinner1)
        val b=getFieldInM(input2, spinner2)
        val c=getFieldInM(input3, spinner3)
        val d=getFieldInM(input4, spinner4)
        val e=getFieldInM(input5, spinner5)
        val f=input6.text.toString().toDouble()

        val res4=d*e
        val res5= c*1000*f
        val res6= res4*c*f
        val res7=res4/(a*b)*f

        result4.text = "${Round.round(res4)} м2"
        result5.text = "${Round.round(res5)} мм"
        result6.text = "${Round.round(res6)} м3"
        result7.text = "${Round.round(res7)}"
    }
    private fun calculate8to9results(){
        val a=getFieldInM(input1, spinner1)
        val b=getFieldInM(input2, spinner2)
        val c=getFieldInM(input3, spinner3)
        val d=getFieldInM(input4, spinner4)
        val e=getFieldInM(input5, spinner5)
        val f=input6.text.toString().toDouble()

        var res4=d*e
        var res6= res4*c*f
        var res7=res4/(a*b)*f
        var res8=res7*input7.text.toString().toDouble()
        var res9=res6*input8.text.toString().toDouble()

        result8.text = "${Round.round(res8)} ${spinner7.selectedItem}"
        result9.text = "${Round.round(res9)} кг"

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
        spinner5.adapter=customDropDownAdapter
        array=resources.getStringArray(R.array.array_currencies)
        customDropDownAdapter = ValuesSpinnerAdapter(requireContext(), array)
        spinner7.adapter=customDropDownAdapter

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
        val input1Value=requireContext().resources.getString(R.string.calculation14_text1)+" "+input1.text.toString()+" "+getSpinnerItem(spinner1)
        val input2Value=requireContext().resources.getString(R.string.calculation14_text2)+" "+input2.text.toString()+" "+getSpinnerItem(spinner2)
        val input3Value=requireContext().resources.getString(R.string.calculation14_text3)+" "+input3.text.toString()+" "+getSpinnerItem(spinner3)
        val input4Value=requireContext().resources.getString(R.string.calculation14_text4)+" "+input4.text.toString()+" "+getSpinnerItem(spinner4)
        val input5Value=requireContext().resources.getString(R.string.calculation14_text5)+" "+input5.text.toString()+" "+getSpinnerItem(spinner5)
        val input6Value=requireContext().resources.getString(R.string.calculation14_text6)+" "+input6.text.toString()+""
        val input7Value=requireContext().resources.getString(R.string.calculation14_text7)+" "+input7.text.toString()+" руб"
        val input8Value=requireContext().resources.getString(R.string.calculation14_text8)+" "+input8.text.toString()+" кг/м3"

        val res1Value=requireContext().resources.getString(R.string.calculation14_text9)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation14_text10)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation14_text11)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation14_text12)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation14_text13)+" "+result5.text.toString()
        val res6Value=requireContext().resources.getString(R.string.calculation14_text14)+" "+result6.text.toString()
        val res7Value=requireContext().resources.getString(R.string.calculation14_text15)+" "+result7.text.toString()
        val res8Value=requireContext().resources.getString(R.string.calculation14_text16)+" "+result8.text.toString()
        val res9Value=requireContext().resources.getString(R.string.calculation14_text17)+" "+result9.text.toString()

        return """
            $input1Value
            $input2Value
            $input3Value
            $input4Value
            $input5Value
            $input6Value       
            $input7Value
            $input8Value
            $res1Value
            $res2Value
            $res3Value
            $res4Value
            $res5Value
            $res6Value
            $res7Value
            $res8Value
            $res9Value
        """.trimIndent()
    }
    private fun getInfoResultAboutCalculations(): String{
        val res1Value=requireContext().resources.getString(R.string.calculation14_text9)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation14_text10)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation14_text11)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation14_text12)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation14_text13)+" "+result5.text.toString()
        val res6Value=requireContext().resources.getString(R.string.calculation14_text14)+" "+result6.text.toString()
        val res7Value=requireContext().resources.getString(R.string.calculation14_text15)+" "+result7.text.toString()
        val res8Value=requireContext().resources.getString(R.string.calculation14_text16)+" "+result8.text.toString()
        val res9Value=requireContext().resources.getString(R.string.calculation14_text17)+" "+result9.text.toString()

        return """"
            $res1Value
            $res2Value
            $res3Value
            $res4Value
            $res5Value
            $res6Value
            $res7Value
            $res8Value
            $res9Value
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
                val id = 14
                val note = Note(title, info, id, result9.text.toString())
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
        spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
    }

}