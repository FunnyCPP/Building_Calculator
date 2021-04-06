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
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.codart.building_calculator.R
import com.codart.building_calculator.calculations.Round
import com.codart.building_calculator.db.Note
import com.codart.building_calculator.db.NoteDB
import com.codart.building_calculator.ui.CalculationsActivity
import com.codart.building_calculator.ui.MainActivity
import com.codart.building_calculator.ui.SpinnerAdapter
import com.codart.building_calculator.ui.ValuesSpinnerAdapter
import kotlin.math.ceil

class CalculationsFragment10 : Fragment() {

    private lateinit var spinner1: TextView
    private lateinit var spinner2: TextView
    private lateinit var spinner3: TextView
    private lateinit var spinner4: Spinner
    private lateinit var spinner5: Spinner
    private lateinit var spinner6: Spinner
    private lateinit var spinner7: TextView
    private lateinit var spinner8: Spinner
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
    private lateinit var btnAdd: AppCompatButton
    private var s: Double = CalculationsActivity.calculateSquare().toString().toDouble()
    var a=0.0
    var b=0.0
    var c=0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations10, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations10)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations10)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations10)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations10)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations10)
        spinner6 =requireView().findViewById(R.id.spinner6_calculations10)
        spinner7 =requireView().findViewById(R.id.spinner7_calculations10)
        spinner8 =requireView().findViewById(R.id.spinner8_calculations10)


        input1 =requireView().findViewById(R.id.calculations10_input1)
        input2 =requireView().findViewById(R.id.calculations10_input2)
        input3 =requireView().findViewById(R.id.calculations10_input3)
        input4 =requireView().findViewById(R.id.calculations10_input4)
        input5 =requireView().findViewById(R.id.calculations10_input5)
        input6 =requireView().findViewById(R.id.calculations10_input6)
        input7 =requireView().findViewById(R.id.calculations10_input7)
        input8 =requireView().findViewById(R.id.calculations10_input8)


        result1 =requireView().findViewById(R.id.calculations10_result1)
        result2 =requireView().findViewById(R.id.calculations10_result2)
        result3 =requireView().findViewById(R.id.calculations10_result3)
        result4 =requireView().findViewById(R.id.calculations10_result4)
        result5 =requireView().findViewById(R.id.calculations10_result5)
        result6 =requireView().findViewById(R.id.calculations10_result6)
        result7 =requireView().findViewById(R.id.calculations10_result7)
        result8 =requireView().findViewById(R.id.calculations10_result8)
        result9 =requireView().findViewById(R.id.calculations10_result9)

        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations10)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations10)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations10)
        btnAdd = requireView().findViewById(R.id.calculations10_btn)
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_calculationsFragment10_to_addSpaceFragment)
        }
        if(s!=0.0)
            btnAdd.text = "Площадь проёмов: $s м2"
        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() && input5.text.isNotEmpty() && input6.text.isNotEmpty() && input7.text.isNotEmpty() && input8.text.isNotEmpty() ) {
            calculate1to6results()
        }

    }
    private fun calculate1to6results(){
        setSizeOfBrick()
        val d=getFieldInM(input4,spinner4)
        val e=getFieldInM(input5,spinner5)
        val m=input6.text.toString().toDouble()
        val p=input8.text.toString().toDouble()
        val res1=d*e
        val res2=getThicknessInMM()

        var res3=getNumberBricks(res1*1000*1000)
        res3= ceil(res3)
        val res4=a*b*c*res3/1000000000
        val res5= ceil(res3/res4)
        val res6= res1*res2/1000-res4
        val res7=m*res3
        val res8=res7/(getThicknessInMM()/10*d*100)
        val res9=res3*p

        result1.text = "${Round.round(res1)} м2"
        result2.text = "${Round.round(res2)} мм"
        result3.text = "${Round.round(res3)} шт"
        result4.text = "${Round.round(res4)} м3"
        result5.text = "${Round.round(res5)} шт"
        result6.text = "${Round.round(res6)} м3"
        result7.text = "${Round.round(res7)} кг"
        result8.text = "${Round.round(res8)} кг/см2"
        result9.text = "${Round.round(res9)} ${spinner8.selectedItem}"


    }
    private fun setSizeOfBrick(){
        a=input1.text.toString().toDouble()
        b=input2.text.toString().toDouble()
        c=input3.text.toString().toDouble()
    }
    private fun getNumberBricks(s: Double): Double{
        val t=input3.text.toString().toDouble()
        return (when(spinner4.selectedItemPosition){
            0->s/(a+t)/(c+t)
            1->s/(b+t)/(c+t)
            2->s/(a+t)/(c+t)+s/(b+t)/(c+t)
            3->s/(b+t)/(c+t)*2
            4->s/(a+t)/(c+t)+s/(b+t)/(c+t)*2
            else ->0.0
        })
    }
    private fun getThicknessInMM(): Double {
        return when(spinner6.selectedItemPosition){
            0 -> b.toDouble()
            1 -> a.toDouble()
            2 -> a+b+getLiquorThicknessInMM()
            4 -> a+a+getLiquorThicknessInMM()
            5 -> a+a+b+2*getLiquorThicknessInMM()
            else ->0.0
        }
    }
    private fun getFieldInM(input: EditText, spinner: Spinner): Double {
        return when(spinner.selectedItemPosition){
            0 -> input.text.toString().toDouble()
            1 -> input.text.toString().toDouble()/100
            2 -> input.text.toString().toDouble()/1000
            else ->0.0
        }
    }

    private fun getLiquorThicknessInMM(): Double {
        return input7.text.toString().toDouble()
    }
    private fun getSpinnerItem(spinner: Spinner): String{
        return when(spinner.selectedItemPosition){
            0 -> "М"
            1 -> "СМ"
            2 -> "ММ"
            else -> ""
        }
    }
    private fun getSpinner4Item(): String{
        return requireContext().resources.getStringArray(R.array.calculations8_array2)[spinner6.selectedItemPosition]
    }
    private fun setSpinnersAdapters(){
        var array=resources.getStringArray(R.array.array_values)
        var customDropDownAdapter = ValuesSpinnerAdapter(requireContext(), array)
        spinner4.adapter=customDropDownAdapter
        spinner5.adapter=customDropDownAdapter
        array=resources.getStringArray(R.array.calculations9_array2)
        var customAdapter = SpinnerAdapter(requireContext(), array)
        spinner6.adapter=customAdapter
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
        val input1Value=requireContext().resources.getString(R.string.calculation10_text1)+" "+input1.text.toString()+" мм"
        val input2Value=requireContext().resources.getString(R.string.calculation10_text2)+" "+input2.text.toString()+" мм"
        val input3Value=requireContext().resources.getString(R.string.calculation10_text3)+" "+input3.text.toString()+" мм"
        val input4Value=requireContext().resources.getString(R.string.calculation10_text4)+" "+input4.text.toString()+" "+getSpinnerItem(spinner4)
        val input5Value=requireContext().resources.getString(R.string.calculation10_text5)+" "+input5.text.toString()+" "+getSpinnerItem(spinner5)
        val input6Value=requireContext().resources.getString(R.string.calculation10_text6)+" "+input5.text.toString()+" кг"
        val spinner6Value=requireContext().resources.getString(R.string.calculation10_text7)+" "+getSpinner4Item()
        val input7Value=requireContext().resources.getString(R.string.calculation10_text8)+" "+input5.text.toString()+" мм"
        val input8Value=requireContext().resources.getString(R.string.calculation10_text9)+" "+input5.text.toString()+" руб"

        val res1Value=requireContext().resources.getString(R.string.calculation10_text10)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation10_text11)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation10_text12)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation10_text13)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation10_text14)+" "+result5.text.toString()
        val res6Value=requireContext().resources.getString(R.string.calculation10_text15)+" "+result6.text.toString()
        val res7Value=requireContext().resources.getString(R.string.calculation10_text16)+" "+result7.text.toString()
        val res8Value=requireContext().resources.getString(R.string.calculation10_text17)+" "+result8.text.toString()
        val res9Value=requireContext().resources.getString(R.string.calculation10_text18)+" "+result9.text.toString()

        return """
            $input1Value
            $input2Value
            $input3Value
            $input4Value
            $input5Value
            $input6Value
            $spinner6Value
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
        val res1Value=requireContext().resources.getString(R.string.calculation1_result1)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation1_result2)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation1_result3)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation1_result4)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation1_result5)+" "+result5.text.toString()
        val res6Value=requireContext().resources.getString(R.string.calculation1_result6)+" "+result6.text.toString()
        val res7Value=requireContext().resources.getString(R.string.calculation1_result7)+" "+result7.text.toString()
        val res8Value=requireContext().resources.getString(R.string.calculation1_result5)+" "+result8.text.toString()
        val res9Value=requireContext().resources.getString(R.string.calculation1_result6)+" "+result9.text.toString()

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
                val id = 10
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
        spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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