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
import kotlin.math.PI
import kotlin.math.floor


class CalculationsFragment51 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner4: Spinner

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText

    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView
    private lateinit var result5: TextView
    private lateinit var result6: TextView
    private lateinit var result7: TextView
    private lateinit var result8: TextView


    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations51, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations51)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations51)


        input1 =requireView().findViewById(R.id.calculations51_input2)
        input2 =requireView().findViewById(R.id.calculations51_input3)
        input3 =requireView().findViewById(R.id.calculations51_input4)


        result1 =requireView().findViewById(R.id.calculations51_result1)
        result2 =requireView().findViewById(R.id.calculations51_result2)
        result3 =requireView().findViewById(R.id.calculations51_result3)
        result4 =requireView().findViewById(R.id.calculations51_result4)
        result5 =requireView().findViewById(R.id.calculations51_result5)
        result6 =requireView().findViewById(R.id.calculations51_result6)
        result7 =requireView().findViewById(R.id.calculations51_result7)
        result8 =requireView().findViewById(R.id.calculations51_result8)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations51)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations51)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations51)

        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        val ro=7850
        val d=getD()/2000
        var s=PI*d*d
        var m=s*ro
        s*=10000
        m= floor(m*1000.0) /1000.0
        s= floor(s*1000.0) /1000.0
        result1.text = "${Round.round(m)} кг"
        result2.text = "${Round.round(s)} см2"
        s/=10000
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty()) {
            calculate1to6results()
            if(input3.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun calculate1to6results(){
        val ro=7850
        val d=getD()/2000
        var s=PI*d*d
        var m=s*ro
        s*=10000
        m= floor(m*1000.0) /1000.0
        s= floor(s*1000.0) /1000.0
        result1.text = "${Round.round(m)} кг"
        result2.text = "${Round.round(s)} см2"
        s/=10000
        val l=input1.text.toString().toDouble()
        val n=input2.text.toString().toDouble()
        val res1=l*n
        val res2=l*m
        val res3= res2*n
        val res4= 1000/m

        result3.text = "${Round.round(res1)} м"
        result4.text = "${Round.round(res2)} кг"
        result5.text = "${Round.round(res3)} кг"
        result6.text = "${Round.round(res4)}"


    }
    fun calculatePrice() {
        val p = input3.text.toString().toDouble()
        val d = getD() / 2000
        val ro = 7850
        val s = PI * d * d
        val m = s * ro
        val l = input1.text.toString().toDouble()
        val n = input2.text.toString().toDouble()
        var res1 = l * n
        val res2 = l * m
        var res3 = res2 * n
        var res4 = 1000 / m
        val res5 = (p / 1000) * (res2)
        val res6 = res5 * n
        result7.text = "${Round.round(res5)} ${spinner4.selectedItem}"
        result8.text = "${Round.round(res6)} ${spinner4.selectedItem}"
    }
    fun getD(): Double{
        return when(spinner1.selectedItemPosition)
        {
            0->6
            1->8
            2->10
            3->12
            4->14
            5->16
            6->18
            7->20
            8->22
            9->25
            10->28
            11->32
            12->36
            13->40
            14->45
            15->50
            16->55
            17->60
            18->70
            19->80
            else->0
        }.toDouble()
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
        var array=resources.getStringArray(R.array.calculations51_array1)
        var adapter2 = SpinnerAdapter(requireContext(), array)
        spinner1.adapter=adapter2
        array=resources.getStringArray(R.array.array_currencies)
        adapter2 = SpinnerAdapter(requireContext(), array)
        spinner4.adapter=adapter2

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
        val spinner1Value=requireContext().resources.getString(R.string.calculation49_text1)+" "+requireContext().resources.getStringArray(R.array.calculations49_array1)[spinner1.selectedItemPosition]
        val input1Value=requireContext().resources.getString(R.string.calculation49_text2)+" "+input1.text.toString()+" м"
        val input2Value=requireContext().resources.getString(R.string.calculation49_text3)+" "+input2.text.toString()+" ед"
        val input3Value=requireContext().resources.getString(R.string.calculation49_text4)+" "+input3.text.toString()+" руб"
        val res1=requireContext().resources.getString(R.string.calculation49_text5)+" "+result1.text.toString()
        val res2=requireContext().resources.getString(R.string.calculation49_text6)+" "+result2.text.toString()
        val res3=requireContext().resources.getString(R.string.calculation49_text7)+" "+result3.text.toString()
        val res4=requireContext().resources.getString(R.string.calculation49_text8)+" "+result4.text.toString()
        val res5=requireContext().resources.getString(R.string.calculation49_text9)+" "+result5.text.toString()
        val res6=requireContext().resources.getString(R.string.calculation49_text10)+" "+result6.text.toString()

        return """
            $spinner1Value
            $input1Value
            $input2Value
            $input3Value           
            $res1
            $res2
            $res3
            $res4
            $res5
            $res6
        """.trimIndent()

    }
    private fun getInfoResultAboutCalculations(): String{
        val res1=requireContext().resources.getString(R.string.calculation49_text5)+" "+result1.text.toString()
        val res2=requireContext().resources.getString(R.string.calculation49_text6)+" "+result2.text.toString()
        val res3=requireContext().resources.getString(R.string.calculation49_text7)+" "+result3.text.toString()
        val res4=requireContext().resources.getString(R.string.calculation49_text8)+" "+result4.text.toString()
        val res5=requireContext().resources.getString(R.string.calculation49_text9)+" "+result5.text.toString()
        val res6=requireContext().resources.getString(R.string.calculation49_text10)+" "+result6.text.toString()
        return """"
            $res1
            $res2
            $res3
            $res4
            $res5
            $res6
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
                val id = 51
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

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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