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
import androidx.constraintlayout.widget.Group
import androidx.core.widget.doAfterTextChanged
import com.codart.building_calculator.R
import com.codart.building_calculator.calculations.Round
import com.codart.building_calculator.db.Note
import com.codart.building_calculator.db.NoteDB
import com.codart.building_calculator.ui.MainActivity
import com.codart.building_calculator.ui.SpinnerAdapter
import com.codart.building_calculator.ui.ValuesSpinnerAdapter
import kotlin.math.ceil
import kotlin.math.floor

class CalculationsFragment16 : Fragment() {

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

    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView
    private lateinit var result5: TextView
    private lateinit var result6: TextView

    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    private lateinit var switch1: Switch
    private lateinit var switch2: Switch
    private lateinit var switch3: Switch
    private lateinit var switch4: Switch

    private lateinit var group1: Group
    private lateinit var group2: Group
    private lateinit var group3: Group


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations16, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations16)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations16)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations16)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations16)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations16)
        spinner7 =requireView().findViewById(R.id.spinner7_calculations16)


        input1 =requireView().findViewById(R.id.calculations16_input1)
        input2 =requireView().findViewById(R.id.calculations16_input2)
        input3 =requireView().findViewById(R.id.calculations16_input3)
        input4 =requireView().findViewById(R.id.calculations16_input4)
        input5 =requireView().findViewById(R.id.calculations16_input5)
        input6 =requireView().findViewById(R.id.calculations16_input6)
        input7 =requireView().findViewById(R.id.calculations16_input7)


        result1 =requireView().findViewById(R.id.calculations16_result1)
        result2 =requireView().findViewById(R.id.calculations16_result2)
        result3 =requireView().findViewById(R.id.calculations16_result3)
        result4 =requireView().findViewById(R.id.calculations16_result4)
        result5 =requireView().findViewById(R.id.calculations16_result5)
        result6 =requireView().findViewById(R.id.calculations16_result6)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations16)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations16)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations16)

        switch1 =requireView().findViewById(R.id.switch1_calculations16)
        switch2 =requireView().findViewById(R.id.switch2_calculations16)
        switch3 =requireView().findViewById(R.id.switch3_calculations16)
        switch4 =requireView().findViewById(R.id.switch4_calculations16)

        group1 =requireView().findViewById(R.id.calculations16_group1)
        group2 =requireView().findViewById(R.id.calculations16_group2)
        group3 =requireView().findViewById(R.id.calculations16_group3)


        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        setSwitches()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty()  ) {
            calculate1to4results()
            if(input5.text.isNotEmpty() )
            {
                calculate4results()
            }
            if(input7.text.isNotEmpty())
            {
                calculate6results()
            }
            if(input6.text.isNotEmpty())
            {
                calculate5results()

            }
        }
    }
    private fun calculate1to4results(){
        val a=getFieldInM(input3, spinner3)
        val b=getFieldInM(input4, spinner4)
        val c=getFieldInM(input1, spinner1)
        val d=getFieldInM(input2, spinner2)

        val res3:Double
        val res1:Double = a*b
        val res2:Double = ceil(a/c) * ceil(b/d)
        res3=c*d*res2

        val res4=((res3/res1)-1)*100

        result1.text = "${Round.round(res1)} м2"
        result2.text = "${Round.round(res2)} ед"
        result3.text = "${Round.round(res3)} м2"
        result6.text = "${Round.round(res4)} %"


    }
    private fun calculate4results(){
        val a=getFieldInM(input3, spinner3)
        val b=getFieldInM(input4, spinner4)
        val c=getFieldInM(input1, spinner1)
        val d=getFieldInM(input2, spinner2)
        var e=0.0
        if(input5.text.isNotEmpty())
        {
           e=getFieldInM(input5, spinner5)
        }


        val res3:Double

        val res1:Double = a*b
        val res2:Double = ceil(a/(c+e+e)) * ceil(b/(d+e+e))
        res3=(c+e+e)*(d+e+e)*res2

        val res4=((res3/res1)-1)*100

        result1.text = "${Round.round(res1)} м2"
        result2.text = "${Round.round(res2)} ед"
        result3.text = "${Round.round(res3)} м2"
        result6.text = "${Round.round(res4)} %"


    }
    private fun calculate5results(){
        val a=getFieldInM(input3, spinner3)
        val b=getFieldInM(input4, spinner4)
        val c=getFieldInM(input1, spinner1)
        val d=getFieldInM(input2, spinner2)
        var e=0.0
        if(input5.text.isNotEmpty())
        {
            e=getFieldInM(input5, spinner5)
        }
        val f=input6.text.toString().toDouble()

        var res3:Double

        val res1:Double = a*b
        val res2:Double = ceil(a/(c+e+e)) * ceil(b/(d+e+e))
        res3=(c+e+e)*(d+e+e)*res2
        val res4= res2*(1+f/100)
        val res5=res3*(1+f/100)
        val res6=((res5/res1)-1)*100

        result3.text = "${Round.round(res3)} м2"
        result4.text = "${Round.round(res4)} шт \n${Round.round(res5)} м2"
        result6.text = "${Round.round(res6)} %"


    }
    private fun calculate6results(){
        val a=getFieldInM(input3, spinner3)
        val b=getFieldInM(input4, spinner4)
        val c=getFieldInM(input1, spinner1)
        val d=getFieldInM(input2, spinner2)
        var e=0.0
        if(input5.text.isNotEmpty())
        {
            e=getFieldInM(input5, spinner5)
        }
        var f=0.0
        if(input6.text.isNotEmpty())
        {
            f=input6.text.toString().toDouble()
        }
        val p=input7.text.toString().toDouble()
        var res1:Double
        var res2:Double
        var res3:Double

        res1=a*b
        res2= ceil(a/(c+e)) * ceil(b/(d+e))
        res3=(c+e)*(d+e)*res2
        var res4= res2*(1+f/100)
        var res5=res3*(1+f/100)
        val res6=1-(res1/res5)
        var res=0.0
        when(spinner7.selectedItemPosition)
        {
            0->{res=res4*p}
            1->{res=res5*p}
        }
        result5.text = "${Round.round(res)} "
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
        val customDropDownAdapter = ValuesSpinnerAdapter(requireContext(), array)
        spinner1.adapter=customDropDownAdapter
        spinner2.adapter=customDropDownAdapter
        spinner3.adapter=customDropDownAdapter
        spinner4.adapter=customDropDownAdapter
        spinner5.adapter=customDropDownAdapter
        array=resources.getStringArray(R.array.calculations16_array1)
        val adapter= SpinnerAdapter(requireContext(), array)
        spinner7.adapter=adapter


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
        val input1Value=requireContext().resources.getString(R.string.calculation16_text1)+" "+input1.text.toString()+" "+getSpinnerItem(spinner1)
        val input2Value=requireContext().resources.getString(R.string.calculation16_text2)+" "+input2.text.toString()+" "+getSpinnerItem(spinner2)
        val input3Value=requireContext().resources.getString(R.string.calculation16_text3)+" "+input3.text.toString()+" "+getSpinnerItem(spinner3)
        val input4Value=requireContext().resources.getString(R.string.calculation16_text4)+" "+input4.text.toString()+" "+getSpinnerItem(spinner4)
        val input5Value=requireContext().resources.getString(R.string.calculation16_text5)+" "+input5.text.toString()+" "+getSpinnerItem(spinner5)
        val input6Value=requireContext().resources.getString(R.string.calculation16_text5)+" "+input5.text.toString()+" %"
        val input7Value=requireContext().resources.getString(R.string.calculation16_text7)+" "+input7.text.toString()+" "+getSpinnerItem(spinner7)

        val res1Value=requireContext().resources.getString(R.string.calculation16_text9)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation16_text10)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation16_text11)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation16_text12)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation16_text13)+" "+result5.text.toString()
        val res6Value=requireContext().resources.getString(R.string.calculation16_text14)+" "+result6.text.toString()

        return """
            $input1Value
            $input2Value
            $input3Value
            $input4Value
            $input5Value
            $input6Value       
            $input7Value   
            $res1Value
            $res2Value
            $res3Value
            $res4Value
            $res5Value
            $res6Value
            
        """.trimIndent()
    }
    private fun getInfoResultAboutCalculations(): String{
        val res1Value=requireContext().resources.getString(R.string.calculation16_text8)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation16_text9)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation16_text10)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation16_text11)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation16_text12)+" "+result5.text.toString()
        val res6Value=requireContext().resources.getString(R.string.calculation16_text13)+" "+result6.text.toString()

        return """"
            $res1Value
            $res2Value
            $res3Value
            $res4Value
            $res5Value
            $res6Value      
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
                val id = 16
                val note = Note(title, info, id, result5.text.toString())
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
    fun setSwitches(){
        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked==true)
                group1.visibility=View.VISIBLE
            else
                group1.visibility=View.GONE
        }
        switch2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked==true)
                group2.visibility=View.VISIBLE
            else
                group2.visibility=View.GONE
        }
        switch3.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked==true)
                group3.visibility=View.VISIBLE
            else
                group3.visibility=View.GONE
        }
    }

}