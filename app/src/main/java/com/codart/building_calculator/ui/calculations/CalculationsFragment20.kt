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


class CalculationsFragment20 : Fragment() {


    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner
    private lateinit var spinner6: Spinner


    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText
    private lateinit var input5: EditText
    private lateinit var input6: EditText


    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView
    private lateinit var result5: TextView


    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations20, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        spinner3 =requireView().findViewById(R.id.spinner3_calculations20)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations20)
        spinner6 =requireView().findViewById(R.id.spinner6_calculations20)


        input1 =requireView().findViewById(R.id.calculations20_input1)
        input2 =requireView().findViewById(R.id.calculations20_input2)
        input3 =requireView().findViewById(R.id.calculations20_input3)
        input4 =requireView().findViewById(R.id.calculations20_input4)
        input5 =requireView().findViewById(R.id.calculations20_input5)
        input6 =requireView().findViewById(R.id.calculations20_input6)

        result1 =requireView().findViewById(R.id.calculations20_result1)
        result2 =requireView().findViewById(R.id.calculations20_result2)
        result3 =requireView().findViewById(R.id.calculations20_result3)
        result4 =requireView().findViewById(R.id.calculations20_result4)
        result5 =requireView().findViewById(R.id.calculations20_result5)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations20)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations20)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations20)

        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){

                if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() ) {
                    calculate1to6results()
                    if (input5.text.isNotEmpty() && input6.text.isNotEmpty())
                        calculatePriceResults()
                }

    }

    private fun calculate1to6results(){
        val ro=input1.text.toString().toDouble()/1000
        val n=input2.text.toString().toDouble()
        val a=getFieldInM(input3, spinner3)
        val b=getFieldInM(input4, spinner4)
        val res1=a*b
        val res2=res1*ro*n

        result1.text = "${Round.round(res1)} м2"
        result2.text = "${Round.round(res2)} л"

    }
    private fun calculatePriceResults(){
        val ro=input1.text.toString().toDouble()/1000
        val n=input2.text.toString().toDouble()
        val a=getFieldInM(input3, spinner3)
        val b=getFieldInM(input4, spinner4)
        val p=input6.text.toString().toDouble()
        val res1=a*b
        val res2=res1*ro*n
        val res3=res2/input5.text.toString().toDouble()
        val res5=res3*p
        val res4=res5/res1

        result3.text = "${Round.round(res3)} шт"
        result4.text = "${Round.round(res4)} ${spinner6.selectedItem}"
        result5.text = "${Round.round(res5)} ${spinner6.selectedItem}"

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
        var array=resources.getStringArray(R.array.array_values)
        var adapter = ValuesSpinnerAdapter(requireContext(), array)
        spinner3.adapter=adapter
        spinner4.adapter=adapter
        array=resources.getStringArray(R.array.array_currencies)
        adapter = ValuesSpinnerAdapter(requireContext(), array)
        spinner6.adapter=adapter
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
    private fun getSpinnerItem(spinner: Spinner): String{
        return when(spinner.selectedItemPosition){
            0 -> "М"
            1 -> "СМ"
            2 -> "ММ"
            else -> ""
        }
    }
    private fun getInfoAboutCalculations(): String{
        val input1Value=requireContext().resources.getString(R.string.calculation20_text1)+" "+input1.text.toString()+" "
        val input2Value=requireContext().resources.getString(R.string.calculation20_text2)+" "+input2.text.toString()+" "
        val input4Value=requireContext().resources.getString(R.string.calculation20_text4)+" "+input4.text.toString()+" "+getSpinnerItem(spinner3)
        val input5Value=requireContext().resources.getString(R.string.calculation20_text5)+" "+input5.text.toString()+" "+getSpinnerItem(spinner4)
        val input6Value=requireContext().resources.getString(R.string.calculation20_text5)+" "+input5.text.toString()+" "
        val input7Value=requireContext().resources.getString(R.string.calculation20_text6)+" "+input6.text.toString()+" "

        val res1Value=requireContext().resources.getString(R.string.calculation20_text7)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation20_text8)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation20_text9)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation20_text10)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation20_text11)+" "+result5.text.toString()


        return """
            $input1Value
            $input2Value         
            $input4Value
            $input5Value
            $input6Value       
            $input7Value           
            $res1Value
            $res2Value
            $res3Value
            $res4Value    
            $res5Value    
        """.trimIndent()
    }
    private fun getInfoResultAboutCalculations(): String{
        val res1Value=requireContext().resources.getString(R.string.calculation20_text7)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation20_text8)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation20_text9)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation20_text10)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation20_text11)+" "+result5.text.toString()

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
                .setTitle("Login Form")
        //show dialog
        val mAlertDialog = mBuilder.show()
        //login button click of custom layout

        mDialogView.findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.btnSave).setOnClickListener {
            //dismiss dialog
            title = mDialogView.findViewById<EditText>(R.id.txtDialogTitle).text.toString()
            if(title!="") {
                val info = getInfoAboutCalculations()
                val id = 20
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
        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
        spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
    }

}