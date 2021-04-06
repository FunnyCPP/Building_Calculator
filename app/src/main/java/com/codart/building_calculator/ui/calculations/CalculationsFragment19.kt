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
import com.codart.building_calculator.ui.ValuesSpinnerAdapter
import kotlin.math.ceil
import kotlin.math.floor


class CalculationsFragment19 : Fragment() {


    private lateinit var spinner1: Spinner
    private lateinit var spinner2: TextView
    //private lateinit var spinner3: TextView
    private lateinit var spinner4: Spinner
    private lateinit var spinner5: Spinner
    private lateinit var spinner6: TextView
    private lateinit var spinner8: Spinner

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

    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var checkBox3: CheckBox
    private lateinit var checkBox4: CheckBox

    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    private lateinit var txt: TextView
    private lateinit var txt1: TextView
    private lateinit var txt2: TextView
    private lateinit var txt3: TextView
    private lateinit var txt4: TextView
    private lateinit var txt5: TextView

    var ro = 0.0
    var n = 0
    var s = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations19, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations19)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations19)
        //spinner3 =requireView().findViewById(R.id.spinner3_calculations19)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations19)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations19)
        spinner6 =requireView().findViewById(R.id.spinner6_calculations19)
        spinner8 =requireView().findViewById(R.id.spinner8_calculations19)


        input1 =requireView().findViewById(R.id.calculations19_input1)
        input2 =requireView().findViewById(R.id.calculations19_input2)
        input3 =requireView().findViewById(R.id.calculations19_input3)
        input4 =requireView().findViewById(R.id.calculations19_input4)
        input5 =requireView().findViewById(R.id.calculations19_input5)
        input6 =requireView().findViewById(R.id.calculations19_input6)
        input7 =requireView().findViewById(R.id.calculations19_input7)

        result1 =requireView().findViewById(R.id.calculations19_result1)
        result2 =requireView().findViewById(R.id.calculations19_result2)
        result3 =requireView().findViewById(R.id.calculations19_result3)
        result4 =requireView().findViewById(R.id.calculations19_result4)
        result5 =requireView().findViewById(R.id.calculations19_result5)
        result6 =requireView().findViewById(R.id.calculations19_result6)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations19)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations19)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations19)

        checkBox1=requireView().findViewById(R.id.calculations19_checkBox1)
        checkBox2=requireView().findViewById(R.id.calculations19_checkBox2)
        checkBox3=requireView().findViewById(R.id.calculations19_checkBox3)
        checkBox4=requireView().findViewById(R.id.calculations19_checkBox4)

        txt=requireView().findViewById(R.id.txt_calculations19)
        txt1=requireView().findViewById(R.id.txt1_calculations19)
        txt2=requireView().findViewById(R.id.txt2_calculations19)
        txt3=requireView().findViewById(R.id.txt3_calculations19)
        txt4=requireView().findViewById(R.id.txt4_calculations19)
        txt5=requireView().findViewById(R.id.txt5_calculations19)


        setCheckBoxes()
        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(checkBox1.isChecked)
        {
            if(checkBox3.isChecked)
            {
                if(input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() ) {
                    ro=getMiddleRo()
                    txt.text="Средний расход - $ro кг/м2*мм"
                    n=input2.text.toString().toInt()
                    s=getFieldInM(input3, spinner4)*getFieldInM(input4, spinner5)
                    calculate1to6results()
                    if(input6.text.isNotEmpty() && input7.text.isNotEmpty())
                        calculatePriceResults()
                }
            }
            if(checkBox4.isChecked)
            {
                if(input2.text.isNotEmpty() && input5.text.isNotEmpty()  ) {
                    ro=getMiddleRo()
                    txt.text="Средний расход - $ro кг/м2*мм"
                    n=input2.text.toString().toInt()
                    s=input5.text.toString().toDouble()
                    calculate1to6results()
                    if(input6.text.isNotEmpty() && input7.text.isNotEmpty())
                        calculatePriceResults()
                }
            }
        }
        if(checkBox2.isChecked) {
            if (checkBox3.isChecked) {
                if (input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty()) {
                    ro = input1.text.toString().toDouble()
                    n = input2.text.toString().toInt()
                    s = getFieldInM(input3, spinner4) * getFieldInM(input4, spinner5)
                    calculate1to6results()
                    if(input6.text.isNotEmpty() && input7.text.isNotEmpty())
                        calculatePriceResults()
                }
            }
            if (checkBox4.isChecked) {
                if (input1.text.isNotEmpty() && input2.text.isNotEmpty() && input5.text.isNotEmpty()) {
                    ro = input1.text.toString().toDouble()
                    n = input2.text.toString().toInt()
                    s = input5.text.toString().toDouble()
                    calculate1to6results()
                    if(input6.text.isNotEmpty() && input7.text.isNotEmpty())
                        calculatePriceResults()
                }
            }
        }
    }
    fun getMiddleRo(): Double{
        return when(spinner1.selectedItemPosition)
        {
            0->0.225
            1->0.125
            2->0.175
            3->0.2
            4->0.225
            5->0.2
            6->0.225
            7->0.35
            8->0.15
            9->0.35
            10->0.2
            11->0.15
            12->0.1
            13->0.2
            14->0.05
            15->0.2
            16->0.35
            17->0.2
            18->0.1
            19->0.11
            20->0.14
            21->0.1
            22->0.1
            23->0.12
            24->0.08
            25->0.1
            26->0.08
            27->0.275
            28->0.2
            29->0.09
            30->0.08
            31->0.125
            32->0.25
            33->0.125
            else->0.0
        }
    }
    private fun calculate1to6results(){
        var res1=s
        var res2=ro*n
        var res3=res1*res2

        res1= floor(res1*10000.0) /10000.0
        res2= floor(res2*10000.0) /10000.0
        res3= floor(res3*10000.0) /10000.0

        result1.text = "${Round.round(res1)} м2"
        result2.text = "${Round.round(res2)} кг"
        result3.text = "${Round.round(res3)} кг"

    }
    private fun calculatePriceResults(){
        var res1=s
        var res2=ro*n
        var res3=res1*res2
        var m=input6.text.toString().toDouble()
        var p=input7.text.toString().toDouble()
        var res4= ceil(res3/m)
        var res5=res4*p
        var res6=res3/m*p/res1

        result4.text = "${Round.round(res4)} шт"
        result5.text = "${Round.round(res5)} ${spinner8.selectedItem}"
        result6.text = "${Round.round(res6)} ${spinner8.selectedItem}"

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
    private fun setSpinnersAdapters(){
        var array=resources.getStringArray(R.array.calculations19_array1)
        var adapter = SpinnerAdapter(requireContext(), array)
        spinner1.adapter=adapter
         array=resources.getStringArray(R.array.array_values)
        val adapter2 = ValuesSpinnerAdapter(requireContext(), array)
        spinner4.adapter=adapter2
        spinner5.adapter=adapter2
        array=resources.getStringArray(R.array.array_currencies)
        adapter = SpinnerAdapter(requireContext(), array)
        spinner8.adapter=adapter
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
        var text1=""
        if(checkBox1.isChecked)
        {
            val input=requireContext().resources.getString(R.string.calculation19_text1)+" "+requireContext().resources.
            getStringArray(R.array.calculations19_array1)[spinner1.selectedItemPosition]
            val input2=requireContext().resources.getString(R.string.calculation19_text2)+" "+input2.text.toString()+" шт"
            text1= """
            $input           
            $input2
            
        """.trimIndent()
        }
        else{
            val input1Value=requireContext().resources.getString(R.string.calculation19_text3)+" "+input1.text.toString()+" кг/м2*мм"
            val input2Value=requireContext().resources.getString(R.string.calculation19_text2)+" "+input2.text.toString()+" "
            text1= """
            $input1Value
            $input2Value
         
        """.trimIndent()
        }
        var text2=""
        if(checkBox3.isChecked)
        {
            val input1Value=requireContext().resources.getString(R.string.calculation19_text4)+" "+input3.text.toString()+" "+spinner4.selectedItem.toString()
            val input2Value=requireContext().resources.getString(R.string.calculation19_text5)+" "+input4.text.toString()+" "+spinner5.selectedItem.toString()
            val input3Value=requireContext().resources.getString(R.string.calculation19_text7)+" "+input6.text.toString()+" кг"
            val input4Value=requireContext().resources.getString(R.string.calculation19_text8)+" "+input7.text.toString()+" руб"
            text2="""
                 $input1Value
                 $input2Value
                 $input3Value
                 $input4Value
                 
            """.trimIndent()
        }
        else
        {
            val input1Value=requireContext().resources.getString(R.string.calculation19_text6)+" "+input5.text.toString()+" м2"
            val input3Value=requireContext().resources.getString(R.string.calculation19_text6)+" "+input6.text.toString()+" кг"
            val input4Value=requireContext().resources.getString(R.string.calculation19_text7)+" "+input7.text.toString()+" руб"

            text2="""
                 $input1Value             
                 $input3Value
                 $input4Value
                 
            """.trimIndent()
        }
        val res="""
            ${requireContext().resources.getString(R.string.calculation19_text8)+" "+result1.text.toString()}
            ${requireContext().resources.getString(R.string.calculation19_text9)+" "+result2.text.toString()}
            ${requireContext().resources.getString(R.string.calculation19_text10)+" "+result3.text.toString()}
            ${requireContext().resources.getString(R.string.calculation19_text11)+" "+result4.text.toString()}
            ${requireContext().resources.getString(R.string.calculation19_text12)+" "+result5.text.toString()}
            ${requireContext().resources.getString(R.string.calculation19_text13)+" "+result6.text.toString()}
            
        """.trimIndent()
        return text1+text2+res

    }
    private fun getInfoResultAboutCalculations(): String{
        return """"
            ${requireContext().resources.getString(R.string.calculation19_text8)+" "+result1.text.toString()}
            ${requireContext().resources.getString(R.string.calculation19_text9)+" "+result2.text.toString()}
            ${requireContext().resources.getString(R.string.calculation19_text10)+" "+result3.text.toString()}
            ${requireContext().resources.getString(R.string.calculation19_text11)+" "+result4.text.toString()}
            ${requireContext().resources.getString(R.string.calculation19_text12)+" "+result5.text.toString()}
            ${requireContext().resources.getString(R.string.calculation19_text13)+" "+result6.text.toString()}
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
                val id = 19
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
                checkMetricFields()
                ro=getMiddleRo()
                txt.text="Средний расход - $ro кг/м2*мм"
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
        spinner8.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
        checkBox1.setOnCheckedChangeListener { buttonView, isChecked -> buttonView.setOnClickListener {
            checkBox1.isChecked = true
            checkBox2.isChecked = false
            input1.visibility = View.GONE
            spinner2.visibility= View.GONE
            txt2.visibility = View.GONE
            txt1.visibility = View.VISIBLE
            spinner1.visibility = View.VISIBLE
            txt.visibility = View.VISIBLE
        }

        }
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setOnClickListener {
                checkBox1.isChecked = false
                checkBox2.isChecked = true
                input1.visibility = View.VISIBLE
                spinner2.visibility= View.VISIBLE
                txt2.visibility = View.VISIBLE
                txt1.visibility = View.GONE
                spinner1.visibility = View.GONE
                txt.visibility = View.GONE
            }

        }
        checkBox3.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setOnClickListener {
                checkBox4.isChecked = false
                checkBox3.isChecked = true
                txt3.visibility = View.VISIBLE
                input3.visibility= View.VISIBLE
                spinner4.visibility = View.VISIBLE
                txt4.visibility = View.VISIBLE
                input4.visibility= View.VISIBLE
                spinner5.visibility = View.VISIBLE
                txt5.visibility = View.GONE
                input5.visibility= View.GONE
                spinner6.visibility = View.GONE
            }

        }
        checkBox4.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setOnClickListener {
                checkBox4.isChecked = true
                checkBox3.isChecked = false
                txt3.visibility = View.GONE
                input3.visibility= View.GONE
                spinner4.visibility = View.GONE
                txt4.visibility = View.GONE
                input4.visibility= View.GONE
                spinner5.visibility = View.GONE
                txt5.visibility = View.VISIBLE
                input5.visibility= View.VISIBLE
                spinner6.visibility = View.VISIBLE
            }

        }
    }

}