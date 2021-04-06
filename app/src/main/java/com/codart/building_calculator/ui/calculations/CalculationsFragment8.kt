package com.codart.building_calculator.ui.calculations

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import java.lang.Exception
import kotlin.math.ceil


class CalculationsFragment8 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner
    private lateinit var spinner5: TextView
    private lateinit var spinner6: TextView
    private lateinit var spinner7: Spinner
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText
    private lateinit var input5: EditText
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
    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    private lateinit var btnAdd: AppCompatButton

    private var s: Any = CalculationsActivity.calculateSquare()
    var a=0
    var b=0
    var c=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations8, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations8)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations8)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations8)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations8)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations8)
        spinner6 =requireView().findViewById(R.id.spinner6_calculations8)
        spinner7 =requireView().findViewById(R.id.spinner7_calculations8)


        input1 =requireView().findViewById(R.id.calculations8_input1)
        input2 =requireView().findViewById(R.id.calculations8_input2)
        input3 =requireView().findViewById(R.id.calculations8_input3)
        input4 =requireView().findViewById(R.id.calculations8_input4)
        input5 =requireView().findViewById(R.id.calculations8_input5)


        result1 =requireView().findViewById(R.id.calculations8_result1)
        result2 =requireView().findViewById(R.id.calculations8_result2)
        result3 =requireView().findViewById(R.id.calculations8_result3)
        result4 =requireView().findViewById(R.id.calculations8_result4)
        result5 =requireView().findViewById(R.id.calculations8_result5)
        result6 =requireView().findViewById(R.id.calculations8_result6)
        result7 =requireView().findViewById(R.id.calculations8_result7)
        result8 =requireView().findViewById(R.id.calculations8_result8)
        result9 =requireView().findViewById(R.id.calculations8_result9)
        result10 =requireView().findViewById(R.id.calculations8_result10)

        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations8)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations8)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations8)

        btnAdd = requireView().findViewById(R.id.calculations8_btn_add)
        btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_calculationsFragment8_to_addSpaceFragment)
        }
        if(s!=0.0 && s!=0)
            btnAdd.text = "Площадь проёмов: $s м2"
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
        checkFields()
    }
    fun checkMetricFields(){
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() && input5.text.isNotEmpty() ) {
           calculate1to6results()
        }

    }
    private fun calculate1to6results(){
        setSizeOfBrick()
        val d=getFieldInM(input1,spinner2)
        val e=getFieldInM(input2,spinner3)
        val m=input4.text.toString().toDouble()
        val p=input5.text.toString().toDouble()
        var res1=d*e-s.toString().toDouble()
        var res2=getThicknessInMM()

        var res3=getNumberBricks(res1*1000*1000)
        res3= ceil(res3)
        var res4=a*b*c*res3/1000000000
        var res5= ceil(res3/res4)
        var res6= ceil(e*1000/(c+input3.text.toString().toDouble()))
        var res7=m
        var res8=m*res3
        var res9=res8/(getThicknessInMM()/10*d*100)
        var res10=res3*p

        result1.text = "${Round.round(res1)} м2"
        result2.text = "${Round.round(res2)} мм"
        result3.text = "${Round.round(res3)} шт"
        result4.text = "${Round.round(res4)} м3"
        result5.text = "${Round.round(res5)} шт"
        result6.text = "${Round.round(res6)}"
        result7.text = "${Round.round(res7)} кг"
        result8.text = "${Round.round(res8)} кг"
        result9.text = "${Round.round(res9)} кг/см2"
        result10.text = "${Round.round(res10)} ${spinner7.selectedItem}"

    }
    private fun setSizeOfBrick(){

         when(spinner1.selectedItemPosition!!){
             0->{a=250;b=120;c=65}
             1->{a=250;b=120;c=65}
             2->{a=250;b=120;c=88}
             3->{a=250;b=120;c=140}
             4->{a=250;b=85;c=65}
             5->{a=288;b=63;c=138}
             6->{a=250;b=120;c=138}
        }
    }
    private fun getNumberBricks(s: Double): Double{
        val t=input3.text.toString().toDouble()
        return (when(spinner4.selectedItemPosition!!){
            0->s/(a+t)/(c+t)
            1->s/(b+t)/(c+t)
            2->s/(a+t)/(c+t)+s/(b+t)/(c+t)
            3->s/(b+t)/(c+t)*2
            4->s/(a+t)/(c+t)+s/(b+t)/(c+t)*2
            else ->0.0
        })
    }

    private fun getThicknessInMM(): Double {
        return when(spinner4.selectedItemPosition!!){
            0 -> b.toDouble()
            1 -> a.toDouble()
            2 -> a+b+getLiquorThicknessInMM()
            4 -> a+a+getLiquorThicknessInMM()
            5 -> a+a+b+2*getLiquorThicknessInMM()
            else ->0.0
        }
    }
    private fun getFieldInM(input: EditText, spinner: Spinner): Double {
        return when(spinner.selectedItemPosition!!){
            0 -> input.text.toString().toDouble()
            1 -> input.text.toString().toDouble()/100
            2 -> input.text.toString().toDouble()/1000
            else ->0.0
        }
    }

    private fun getLiquorThicknessInMM(): Double {
            return input3.text.toString().toDouble()
    }
    private fun getSpinnerItem(spinner: Spinner): String{
        return when(spinner.selectedItemPosition){
            0 -> "М"
            1 -> "СМ"
            2 -> "ММ"
            else -> ""
        }
    }
    private fun getSpinner1Item(): String{
        return requireContext().resources.getStringArray(R.array.calculations8_array1)[spinner1.selectedItemPosition]
    }
    private fun getSpinner4Item(): String{
        return requireContext().resources.getStringArray(R.array.calculations8_array2)[spinner4.selectedItemPosition]
    }
    private fun setSpinnersAdapters(){
        var array=resources.getStringArray(R.array.array_values)
        var customDropDownAdapter = ValuesSpinnerAdapter(requireContext(), array)
        spinner2.adapter=customDropDownAdapter
        spinner3.adapter=customDropDownAdapter
        array=resources.getStringArray(R.array.calculations8_array1)
        var customAdapter = SpinnerAdapter(requireContext(), array)
        spinner1.adapter=customAdapter
        array=resources.getStringArray(R.array.calculations8_array2)
        customAdapter = SpinnerAdapter(requireContext(), array)
        spinner4.adapter=customAdapter
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
        val spinner1Value=requireContext().resources.getString(R.string.calculation8_text1)+" "+getSpinner1Item()
        val input1Value=requireContext().resources.getString(R.string.calculation8_text2)+" "+input1.text.toString()+" "+getSpinnerItem(spinner2)
        val input2Value=requireContext().resources.getString(R.string.calculation8_text3)+" "+input2.text.toString()+" "+getSpinnerItem(spinner3)
        val spinner4Value=requireContext().resources.getString(R.string.calculation8_text4)+" "+getSpinner4Item()
        val input3Value=requireContext().resources.getString(R.string.calculation8_text5)+" "+input3.text.toString()+" мм"
        val input4Value=requireContext().resources.getString(R.string.calculation8_text6)+" "+input4.text.toString()
        val input5Value=requireContext().resources.getString(R.string.calculation8_text7)+" "+input5.text.toString()
        val res1Value=requireContext().resources.getString(R.string.calculation1_result1)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation1_result2)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation1_result3)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation1_result4)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation1_result5)+" "+result5.text.toString()
        val res6Value=requireContext().resources.getString(R.string.calculation1_result6)+" "+result6.text.toString()
        val res7Value=requireContext().resources.getString(R.string.calculation1_result7)+" "+result7.text.toString()
        val res8Value=requireContext().resources.getString(R.string.calculation1_result5)+" "+result8.text.toString()
        val res9Value=requireContext().resources.getString(R.string.calculation1_result6)+" "+result9.text.toString()
        val res10Value=requireContext().resources.getString(R.string.calculation1_result7)+" "+result10.text.toString()
        return """
            $spinner1Value
            $input1Value
            $input2Value
            $spinner4Value
            $input3Value
            $input4Value
            $input5Value
            $res1Value
            $res2Value
            $res3Value
            $res4Value
            $res5Value
            $res6Value
            $res7Value
            $res8Value
            $res9Value
            $res10Value
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
        val res10Value=requireContext().resources.getString(R.string.calculation1_result7)+" "+result10.text.toString()
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
            $res10Value
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
                val id = 8
                val note = Note(title, info, id, result10.text.toString())
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
        input1!!.doAfterTextChanged {
            checkMetricFields()
        }
        input2!!.doAfterTextChanged {
            checkMetricFields()
        }
        input3!!.doAfterTextChanged {
            checkMetricFields()
        }
        input4!!.doAfterTextChanged {
            checkMetricFields()
        }
        input5!!.doAfterTextChanged {
            checkMetricFields()
        }
        spinner1!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner2!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner3!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner4!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner7!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
    }

}