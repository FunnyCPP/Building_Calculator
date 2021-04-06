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


class CalculationsFragment15 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner
    private lateinit var spinner5: Spinner
    private lateinit var spinner6: Spinner
    private lateinit var spinner7: Spinner
    private lateinit var spinner8: Spinner
    private lateinit var spinner9: Spinner
    private lateinit var spinner10: Spinner
    private lateinit var spinner11: Spinner
    private lateinit var spinner12: Spinner
    private lateinit var spinner13: Spinner
    private lateinit var spinner14: Spinner
    private lateinit var spinner15: Spinner
    private lateinit var spinner16: Spinner
    private lateinit var spinner17: TextView
    private lateinit var spinner18: Spinner
    private lateinit var spinner19: Spinner


    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText
    private lateinit var input5: EditText
    private lateinit var input6: EditText
    private lateinit var input7: EditText
    private lateinit var input8: EditText
    private lateinit var input9: EditText
    private lateinit var input10: EditText
    private lateinit var input11: EditText
    private lateinit var input12: EditText
    private lateinit var input13: EditText
    private lateinit var input14: EditText
    private lateinit var input15: EditText
    private lateinit var input16: EditText
    private lateinit var input17: EditText



    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView
    private lateinit var result5: TextView
    private lateinit var result6: TextView
    private lateinit var result7: TextView
    private lateinit var result8: TextView
    private lateinit var result9: TextView
    private lateinit var result10: TextView
    private lateinit var result11: TextView
    private lateinit var result12: TextView
    private lateinit var result13: TextView
    private lateinit var result14: TextView
    private lateinit var result15: TextView

    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var checkBox3: CheckBox
    private lateinit var checkBox4: CheckBox

    private lateinit var switch1: Switch
    private lateinit var switch2: Switch
    private lateinit var switch3: Switch

    private lateinit var group1: Group
    private lateinit var group2: Group
    private lateinit var group3: Group

    private lateinit var txtLength: TextView
    private lateinit var txtStep: TextView

    private var valueLag = 0.0
    private var nLag=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations15, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations15)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations15)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations15)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations15)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations15)
        spinner6 =requireView().findViewById(R.id.spinner6_calculations15)

        spinner8 =requireView().findViewById(R.id.spinner8_calculations15)
        spinner9 =requireView().findViewById(R.id.spinner9_calculations15)
        spinner10 =requireView().findViewById(R.id.spinner10_calculations15)
        spinner11 =requireView().findViewById(R.id.spinner11_calculations15)
        spinner12 =requireView().findViewById(R.id.spinner12_calculations15)

        spinner13 =requireView().findViewById(R.id.spinner13_calculations15)
        spinner14 =requireView().findViewById(R.id.spinner14_calculations15)
        spinner15 =requireView().findViewById(R.id.spinner15_calculations15)
        spinner16 =requireView().findViewById(R.id.spinner16_calculations15)
        spinner17 =requireView().findViewById(R.id.spinner17_calculations15)

        spinner7 =requireView().findViewById(R.id.spinner7_calculations15)
        spinner18 =requireView().findViewById(R.id.spinner7_2_calculations15)
        spinner19 =requireView().findViewById(R.id.spinner7_3_calculations15)


        input1 =requireView().findViewById(R.id.calculations15_input1)
        input2 =requireView().findViewById(R.id.calculations15_input2)
        input3 =requireView().findViewById(R.id.calculations15_input3)
        input4 =requireView().findViewById(R.id.calculations15_input4)
        input5 =requireView().findViewById(R.id.calculations15_input5)
        input6 =requireView().findViewById(R.id.calculations15_input6)

        input8 =requireView().findViewById(R.id.calculations15_input8)
        input9 =requireView().findViewById(R.id.calculations15_input9)
        input10 =requireView().findViewById(R.id.calculations15_input10)
        input11 =requireView().findViewById(R.id.calculations15_input11)

        input12 =requireView().findViewById(R.id.calculations15_input12)
        input13 =requireView().findViewById(R.id.calculations15_input13)
        input14 =requireView().findViewById(R.id.calculations15_input14)
        input15 =requireView().findViewById(R.id.calculations15_input15)

        input7 =requireView().findViewById(R.id.calculations15_input7)
        input16 =requireView().findViewById(R.id.calculations15_input7_2)
        input17 =requireView().findViewById(R.id.calculations15_input7_3)


        result1 =requireView().findViewById(R.id.calculations15_result1)
        result2 =requireView().findViewById(R.id.calculations15_result2)
        result3 =requireView().findViewById(R.id.calculations15_result3)

        result4 =requireView().findViewById(R.id.calculations15_result4)
        result5 =requireView().findViewById(R.id.calculations15_result5)
        result6 =requireView().findViewById(R.id.calculations15_result6)
        result7 =requireView().findViewById(R.id.calculations15_result7)
        result8 =requireView().findViewById(R.id.calculations15_result8)
        result9 =requireView().findViewById(R.id.calculations15_result9)

        result10 =requireView().findViewById(R.id.calculations15_result10)
        result11 =requireView().findViewById(R.id.calculations15_result11)

        result12 =requireView().findViewById(R.id.calculations15_result12)
        result13 =requireView().findViewById(R.id.calculations15_result13)
        result14 =requireView().findViewById(R.id.calculations15_result14)
        result15 =requireView().findViewById(R.id.calculations15_result15)


        checkBox1 =requireView().findViewById(R.id.calculations15_checkBox1)
        checkBox2 =requireView().findViewById(R.id.calculations15_checkBox2)
        checkBox3 =requireView().findViewById(R.id.checkbox3_calculations15)
        checkBox4 =requireView().findViewById(R.id.checkbox4_calculations15)

        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations15)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations15)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations15)

        switch1 =requireView().findViewById(R.id.switch1_calculations15)
        switch2 =requireView().findViewById(R.id.switch2_calculations15)
        switch3 =requireView().findViewById(R.id.switch3_calculations15)

        group1 =requireView().findViewById(R.id.calculations15_group1)
        group2 =requireView().findViewById(R.id.calculations15_group2)
        group3 =requireView().findViewById(R.id.calculations15_group3)
        txtLength =requireView().findViewById(R.id.txt_length)
        txtStep =requireView().findViewById(R.id.txt_step)

        setCheckBoxes()
        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        setSwitches()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() && input5.text.isNotEmpty() && input6.text.isNotEmpty() ) {
            calculate1to3results()
            if( input7.text.isNotEmpty())
            {
                calculatePriceResults()
            }
            if(input8.text.isNotEmpty() && input9.text.isNotEmpty() && input10.text.isNotEmpty() && input11.text.isNotEmpty())
            {
                calculate4to9results()
            }
            if(input12.text.isNotEmpty() && input13.text.isNotEmpty() && input14.text.isNotEmpty() && input15.text.isNotEmpty())
            {
                calculate10to11results()
            }
            if(input8.text.isNotEmpty())
                calculateLength()
        }
    }
    private fun calculate1to3results(){
        var a=getFieldInM(input1, spinner1)
        var b=getFieldInM(input2, spinner2)
        val c=getFieldInM(input3, spinner3)
        val d=getFieldInM(input4, spinner4)
        val e=getFieldInM(input5, spinner5)
        val f=getFieldInM(input6, spinner6)
        val res1:Double = a*b
        val res2:Double = ceil(a*b/c/(d+f))
        val res3:Double =res2*c*d*e

        result1.text = "${Round.round(res1)} м2"
        result2.text = "${Round.round(res2)} "
        result3.text = "${Round.round(res3)} м3"

    }
    fun calculate4to9results(){
        var n=0
        var lengthLag=0.0
        var stepLag= 0.0
        if(spinner12.selectedItemPosition == 0)
        {
             n=input11.text.toString().toInt()
             lengthLag = if(checkBox1.isChecked){
                getFieldInM(input2,spinner2)+getFieldInM(input8, spinner8)*2
            }
            else{
                getFieldInM(input1,spinner1)+getFieldInM(input8, spinner8)*2
            }
             stepLag = if(checkBox3.isChecked)
            {
                if(checkBox1.isChecked)
                {
                    (getFieldInM(input1,spinner1)-getFieldInM(input9,spinner9))/(n-1)
                }
                else
                {
                    (getFieldInM(input2,spinner2)-getFieldInM(input9,spinner9))/(n-1)
                }

            }
            else
            {
                if(checkBox1.isChecked)
                {
                    getFieldInM(input1,spinner1)/(n+1)
                }
                else
                {
                    getFieldInM(input2,spinner2)/(n+1)
                }
            }
        }
        if(spinner12.selectedItemPosition == 1)
        {
            stepLag=getFieldInM(input11,spinner11)
            lengthLag = if(checkBox1.isChecked){
                getFieldInM(input2,spinner2)+getFieldInM(input8, spinner8)
            }
            else{
                getFieldInM(input1,spinner1)+getFieldInM(input8, spinner8)
            }
            n = if(checkBox3.isChecked)
            {
                if(checkBox1.isChecked)
                {
                    floor((getFieldInM(input1,spinner1)-getFieldInM(input9,spinner9))/(stepLag)).toInt()
                }
                else
                {
                    floor((getFieldInM(input2,spinner2)-getFieldInM(input9,spinner9))/stepLag).toInt()
                }
            }
            else
            {
               0
            }
        }
        txtStep.text="Шаг лаг: ${Round.round(stepLag*1000)}мм"
        val res4 = stepLag-getFieldInM(input9, spinner9)
        val res5 = n*lengthLag*getFieldInM(input9, spinner9)*getFieldInM(input10, spinner10)
        val res6 = (n-1)*lengthLag*res4*getFieldInM(input10, spinner10)
        valueLag=res5
        nLag=n
        result4.text = "$n"
        result5.text = "${Round.round(lengthLag)} м"
        result6.text = "${Round.round(stepLag)} м"
        result7.text = "${Round.round(res4)} м"
        result8.text = "${Round.round(res5)} м3"
        result9.text = "${Round.round(res6)} м3"
    }
    fun calculate10to11results(){
        val res10 = ceil(getFieldInM(input1,spinner1)* getFieldInM(input2,spinner2)/(getFieldInM(input12,spinner13)*(getFieldInM(input13,spinner14)+getFieldInM(input15,spinner16))))
        val res11 = res10*getFieldInM(input12,spinner13)*getFieldInM(input13,spinner14)*getFieldInM(input14,spinner15)
        result10.text = "${Round.round(res10)}"
        result11.text = "${Round.round(res11)} м3"
    }
    private fun calculatePriceResults(){
        var a=getFieldInM(input1, spinner1)
        var b=getFieldInM(input2, spinner2)
        val c=getFieldInM(input3, spinner3)
        val d=getFieldInM(input4, spinner4)
        val e=getFieldInM(input5, spinner5)
        val f=getFieldInM(input6, spinner6)
        val res2:Double
        val res3:Double
        var res4=0.0
        var res5=0.0
        var res6=0.0
        if(checkBox1.isChecked)
        {
            res2= ceil(a/(d+f)) * ceil(b/(d+f))
            res3=c*d*e*res2
            when(spinner7.selectedItemPosition) {
                0 -> {
                    res4=res2*input7.text.toString().toDouble()
                }
                1 ->{
                    res4=res3*input7.text.toString().toDouble()
                }
            }
        }
        else
        {
            val t=a
            a=b
            b=t

            res2= ceil(a/(d+f)) * ceil(b/(d+f))
            res3=c*d*e*res2
            res4 = when(spinner7.selectedItemPosition) {
                0 -> {
                    res2*input7.text.toString().toDouble()
                }
                1 ->{
                    res3*input7.text.toString().toDouble()
                }
                else -> 0.0
            }
        }
        if(input8.text.isNotEmpty() && input9.text.isNotEmpty() && input10.text.isNotEmpty() && input11.text.isNotEmpty())
        {
             res5 = when(spinner7.selectedItemPosition)
            {
                0 -> {
                    valueLag*input7.text.toString().toDouble()
                }
                1 ->{
                    nLag*input7.text.toString().toDouble()
                }
                else -> 0.0
            }
        }

        if(input12.text.isNotEmpty() && input13.text.isNotEmpty() && input14.text.isNotEmpty() && input15.text.isNotEmpty())
        {
            val res10 = ceil(getFieldInM(input1,spinner1)* getFieldInM(input2,spinner2)/(getFieldInM(input12,spinner13)*(getFieldInM(input13,spinner14)+getFieldInM(input15,spinner16))))
            val res11 = res10*getFieldInM(input12,spinner13)*getFieldInM(input13,spinner14)*getFieldInM(input14,spinner15)
             res6 = when(spinner7.selectedItemPosition)
            {
                0 -> {
                    res11*input7.text.toString().toDouble()
                }
                1 ->{
                    res10*input7.text.toString().toDouble()
                }
                else -> 0.0
            }
        }
        result12.text = "${Round.round(res4)} "
        result13.text = "${Round.round(res5)} "
        result14.text = "${Round.round(res6)} "
        result15.text = "${Round.round(res4+res5+res6)} "

    }
    fun calculateLength(){
        val lengthLag = if(checkBox1.isChecked){
            getFieldInM(input2,spinner2)+getFieldInM(input8, spinner8)*2
        }
        else{
            getFieldInM(input1,spinner1)+getFieldInM(input8, spinner8)*2
        }
        txtLength.text = "Длина лаг с учетом нахлеста: ${lengthLag*1000}мм"
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
        spinner6.adapter=customDropDownAdapter
        spinner8.adapter=customDropDownAdapter
        spinner9.adapter=customDropDownAdapter
        spinner10.adapter=customDropDownAdapter
        spinner13.adapter=customDropDownAdapter
        spinner14.adapter=customDropDownAdapter
        spinner15.adapter=customDropDownAdapter
        spinner16.adapter=customDropDownAdapter
        spinner1.setSelection(2)
        spinner2.setSelection(2)
        spinner3.setSelection(2)
        spinner4.setSelection(2)
        spinner5.setSelection(2)
        spinner6.setSelection(2)
        spinner8.setSelection(2)
        spinner9.setSelection(2)
        spinner10.setSelection(2)
        spinner11.setSelection(2)
        spinner13.setSelection(2)
        spinner14.setSelection(2)
        spinner15.setSelection(2)
        spinner16.setSelection(2)
        setSpinner11()

        array=resources.getStringArray(R.array.calculations15_array1)
        var adapter=SpinnerAdapter(requireContext(), array)
        spinner7.adapter=adapter
        spinner18.adapter=adapter
        spinner19.adapter=adapter

        array = arrayOf("Количество", "Шаг[D]")
        adapter=SpinnerAdapter(requireContext(), array)
        spinner12.adapter=adapter

    }
    fun setSpinner11(){
        if(spinner12.selectedItemPosition==0)
        {
            var array= arrayOf("шт")
            val customDropDownAdapter = ValuesSpinnerAdapter(requireContext(), array)
            spinner11.adapter=customDropDownAdapter
            //spinner11.findViewById<ImageView>(R.id.imgSpinner).visibility = View.GONE
        }
        else
        {
            var array=resources.getStringArray(R.array.array_values)
            val customDropDownAdapter = ValuesSpinnerAdapter(requireContext(), array)
            spinner11.adapter=customDropDownAdapter
        }
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
        val input1Value=requireContext().resources.getString(R.string.calculation15_text1)+" "+input1.text.toString()+" "+getSpinnerItem(spinner1)
        val input2Value=requireContext().resources.getString(R.string.calculation15_text2)+" "+input2.text.toString()+" "+getSpinnerItem(spinner2)
        val input3Value=requireContext().resources.getString(R.string.calculation15_text3)+" "+spinner3.toString()
        val input4Value=requireContext().resources.getString(R.string.calculation15_text4)+" "+input3.text.toString()+" "+getSpinnerItem(spinner4)
        val input5Value=requireContext().resources.getString(R.string.calculation15_text5)+" "+input4.text.toString()+" "+getSpinnerItem(spinner5)
        val input6Value=requireContext().resources.getString(R.string.calculation15_text6)+" "+input5.text.toString()+" "+getSpinnerItem(spinner6)
        val input7Value=requireContext().resources.getString(R.string.calculation15_text7)+" "+input6.text.toString()+" "+getSpinnerItem(spinner7)
        val input8Value=requireContext().resources.getString(R.string.calculation15_text8)+" "+input7.text.toString()+" "+getSpinnerItem(spinner7)

        val res1Value=requireContext().resources.getString(R.string.calculation14_text9)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation14_text10)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation14_text11)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation14_text12)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation14_text13)+" "+result5.text.toString()

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
            
        """.trimIndent()
    }
    private fun getInfoResultAboutCalculations(): String{
        val res1Value=requireContext().resources.getString(R.string.calculation14_text9)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation14_text10)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation14_text11)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation14_text12)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation14_text13)+" "+result5.text.toString()
        return """"
            $res1Value
            $res2Value
            $res3Value
            $res4Value
            $res5Value         
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
                val id = 15
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
        addListener(input1)
        addListener(input2)
        addListener(input3)
        addListener(input4)
        addListener(input5)
        addListener(input6)
        addListener(input7)
        addListener(input8)
        addListener(input9)
        addListener(input10)
        addListener(input11)
        addListener(input12)
        addListener(input13)
        addListener(input14)
        addListener(input15)
        addListener(input16)
        addListener(input17)
        addListener(spinner1)
        addListener(spinner2)
        addListener(spinner3)
        addListener(spinner4)
        addListener(spinner5)
        addListener(spinner6)
        addListener(spinner7)
        addListener(spinner8)
        addListener(spinner9)
        addListener(spinner10)
        addListener(spinner11)
        addListener(spinner12)
        addListener(spinner13)
        addListener(spinner14)
        addListener(spinner15)
        addListener(spinner16)
        addListener(spinner18)
        addListener(spinner19)
    }
    private fun addListener(input: EditText)
    {
        input.doAfterTextChanged {
            checkMetricFields()
        }
    }
    private fun addListener(spinner: Spinner)
    {
        if(spinner == spinner12)
        {
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    setSpinner11()
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }
        else {
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }
    }
    private fun setCheckBoxes()
    {
        checkBox1.setOnCheckedChangeListener { buttonView, isChecked->
            buttonView.setOnClickListener{
                checkBox1.isChecked = true
                checkBox2.isChecked = false
                checkMetricFields()
            }

        }
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setOnClickListener{
                checkBox1.isChecked = false
                checkBox2.isChecked = true
                checkMetricFields()
            }


        }
        checkBox3.setOnCheckedChangeListener { buttonView, isChecked->
            buttonView.setOnClickListener{
                checkBox3.isChecked = true
                checkBox4.isChecked = false
                checkMetricFields()
            }

        }
        checkBox4.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setOnClickListener{
                checkBox3.isChecked = false
                checkBox4.isChecked = true
                checkMetricFields()
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