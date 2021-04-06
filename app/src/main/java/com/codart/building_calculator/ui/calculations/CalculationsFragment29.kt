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
import kotlin.math.floor


class CalculationsFragment29 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner5: Spinner


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


    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations29, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations29)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations29)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations29)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations29)


        input1 =requireView().findViewById(R.id.calculations29_input1)
        input2 =requireView().findViewById(R.id.calculations29_input2)
        input3 =requireView().findViewById(R.id.calculations29_input3)
        input4 =requireView().findViewById(R.id.calculations29_input4)
        input5 =requireView().findViewById(R.id.calculations29_input5)


        result1 =requireView().findViewById(R.id.calculations29_result1)
        result2 =requireView().findViewById(R.id.calculations29_result2)
        result3 =requireView().findViewById(R.id.calculations29_result3)
        result4 =requireView().findViewById(R.id.calculations29_result4)
        result5 =requireView().findViewById(R.id.calculations29_result5)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations29)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations29)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations29)

        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty()  && input3.text.isNotEmpty()&& input4.text.isNotEmpty()  && input5.text.isNotEmpty()  ) {
            calculate1to6results()
        }
    }
    private fun calculate1to6results(){
        val a=getFieldInM(input1,spinner1)
        val b=getFieldInM(input2,spinner2)
        val c=getFieldInM(input3,spinner3)
        val n=input4.text.toString().toInt()
        val p=input5.text.toString().toDouble()
        val res1= 1.0/(a*b*c)
        val res2=(a*b*c)
        val res3= n/res2
        val res4=p/res1
        val res5=n*p
        result1.text = "${Round.round(res1)} ед"
        result2.text = "${Round.round(res2)} м3"
        result3.text = "${Round.round(res3)} ед"
        result4.text = "${Round.round(res4)} ${spinner5.selectedItem}"
        result5.text = "${Round.round(res5)} ${spinner5.selectedItem}"

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
        var adapter2 = ValuesSpinnerAdapter(requireContext(), array)
        spinner3.adapter=adapter2
        spinner1.adapter=adapter2
        spinner2.adapter=adapter2
        array=resources.getStringArray(R.array.array_currencies)
        adapter2 = ValuesSpinnerAdapter(requireContext(), array)
        spinner5.adapter=adapter2
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
    private fun getInfoAboutCalculations(): String{
        val input1Value=requireContext().resources.getString(R.string.calculation29_text1)+" "+input1.text.toString()+" "+getSpinnerItem(spinner1)
        val input2Value=requireContext().resources.getString(R.string.calculation29_text2)+" "+input2.text.toString()+" "+getSpinnerItem(spinner2)
        val input3Value=requireContext().resources.getString(R.string.calculation29_text3)+" "+input3.text.toString()+" "+getSpinnerItem(spinner3)
        val input4Value=requireContext().resources.getString(R.string.calculation29_text4)+" "+input4.text.toString()+" ед"
        val input5Value=requireContext().resources.getString(R.string.calculation29_text5)+" "+input5.text.toString()+" руб"
        val res1=requireContext().resources.getString(R.string.calculation29_text6)+" "+result1.text.toString()
        val res2=requireContext().resources.getString(R.string.calculation29_text7)+" "+result2.text.toString()
        val res3=requireContext().resources.getString(R.string.calculation29_text8)+" "+result3.text.toString()
        val res4=requireContext().resources.getString(R.string.calculation29_text9)+" "+result4.text.toString()
        val res5=requireContext().resources.getString(R.string.calculation29_text10)+" "+result5.text.toString()

        return """
            $input1Value
            $input2Value
            $input3Value
            $input4Value
            $input5Value
            $res1
            $res2
            $res3
            $res4
            $res5                       
        """.trimIndent()

    }
    private fun getInfoResultAboutCalculations(): String{
        val res1=requireContext().resources.getString(R.string.calculation29_text6)+" "+result1.text.toString()
        val res2=requireContext().resources.getString(R.string.calculation29_text7)+" "+result2.text.toString()
        val res3=requireContext().resources.getString(R.string.calculation29_text8)+" "+result3.text.toString()
        val res4=requireContext().resources.getString(R.string.calculation29_text9)+" "+result4.text.toString()
        val res5=requireContext().resources.getString(R.string.calculation29_text10)+" "+result5.text.toString()
        return """"
            $res1
            $res2
            $res3
            $res4
            $res5            
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
                val id = 29
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
        spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                checkMetricFields()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
    }

}