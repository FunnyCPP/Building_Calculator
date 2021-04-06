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
import com.codart.building_calculator.calculations.CalculationsMetals
import com.codart.building_calculator.calculations.Round
import com.codart.building_calculator.db.Note
import com.codart.building_calculator.db.NoteDB
import com.codart.building_calculator.ui.MainActivity
import com.codart.building_calculator.ui.SpinnerAdapter
import com.codart.building_calculator.ui.ValuesSpinnerAdapter
import kotlin.math.PI
import kotlin.math.atan
import kotlin.math.sqrt


class CalculationsFragment30 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner
    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText
    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView
    private lateinit var result5: TextView
    private lateinit var result6: TextView
    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations30, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations30)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations30)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations30)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations30)

        input1 =requireView().findViewById(R.id.calculations30_input1)
        input2 =requireView().findViewById(R.id.calculations30_input2)
        input3 =requireView().findViewById(R.id.calculations30_input3)
        input4 =requireView().findViewById(R.id.calculations30_input4)

        result1 =requireView().findViewById(R.id.calculations30_result1)
        result2 =requireView().findViewById(R.id.calculations30_result2)
        result3 =requireView().findViewById(R.id.calculations30_result3)
        result4 =requireView().findViewById(R.id.calculations30_result4)
        result5 =requireView().findViewById(R.id.calculations30_result5)
        result6 =requireView().findViewById(R.id.calculations30_result6)

        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations30)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations30)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations30)



        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() ) {
            calculate1to6results()
            if(input4.text.isNotEmpty())
                calculate7result()
        }

    }
    private fun calculate1to6results(){
        val a= getFieldinMetres(spinner1,input1)
        val b= getFieldinMetres(spinner2,input2)
        val h= getFieldinMetres(spinner3,input3)

        var res1= sqrt(b*b+h*h)*a
        var res2= atan(h/b)*360/2/PI
        var res3= sqrt(b*b+h*h)*1000
        var res4=b*h/2
        Round.round(res1)

        result1.text= "${Round.round(res1)} м2"
        result2.text= "${Round.round(res2)} градусов"
        result3.text= "${Round.round(res3)} мм"
        result4.text= "${Round.round(res4)} м2"

    }
    private fun calculate7result(){
        val a= getFieldinMetres(spinner1,input1)
        val b= getFieldinMetres(spinner2,input2)
        val h= getFieldinMetres(spinner3,input3)

        val p= input4.text.toString().toDouble()
        var res1= sqrt(b*b+h*h)*a
        val res5=p*res1
        val res6= res5
        result5.text="${Round.round(res5)} ${spinner4.selectedItem}"
        result5.text="${Round.round(res5)} ${spinner4.selectedItem}"
    }
    private fun getFieldinMetres(spinner: Spinner, input: EditText): Double{
        return when(spinner.selectedItemPosition){
            0 -> input.text.toString().toDouble()
            1 -> input.text.toString().toDouble() / 100
            2 -> input.text.toString().toDouble() / 1000
            else -> 0.toDouble()
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
        array=resources.getStringArray(R.array.array_currencies)
        customDropDownAdapter = ValuesSpinnerAdapter(requireContext(), array)
        spinner4.adapter=customDropDownAdapter
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
        val sizeAValue=requireContext().resources.getString(R.string.calculation30_text1)+" "+input1.text.toString()+" "+getSpinnerItem(spinner1)
        val sizeBValue=requireContext().resources.getString(R.string.calculation30_text2)+" "+input2.text.toString()+" "+getSpinnerItem(spinner2)
        val sizeCValue=requireContext().resources.getString(R.string.calculation30_text3)+" "+input3.text.toString()+" "+getSpinnerItem(spinner3)
        val sizeDValue=requireContext().resources.getString(R.string.calculation30_text4)+" "+input4.text.toString()+" "
        val res1Value=requireContext().resources.getString(R.string.calculation30_text5)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation30_text6)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation30_text7)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation30_text8)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation30_text9)+" "+result5.text.toString()
        val res6Value=requireContext().resources.getString(R.string.calculation30_text10)+" "+result6.text.toString()
        return """
            $sizeAValue
            $sizeBValue
            $sizeCValue
            $sizeDValue        
            $res1Value
            $res2Value
            $res3Value
            $res4Value
            $res5Value
            $res6Value
        """.trimIndent()
    }
    private fun getInfoResultAboutCalculations(): String{
        val res1Value=requireContext().resources.getString(R.string.calculation30_text5)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation30_text6)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation30_text7)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation30_text8)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation30_text9)+" "+result5.text.toString()
        val res6Value=requireContext().resources.getString(R.string.calculation30_text10)+" "+result6.text.toString()
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
                val id = 30
                val note = Note(title, info, id, result6.text.toString())
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
    }
}