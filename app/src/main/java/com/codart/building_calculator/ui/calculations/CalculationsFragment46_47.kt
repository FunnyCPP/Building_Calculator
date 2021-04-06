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
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.doAfterTextChanged
import com.codart.building_calculator.R
import com.codart.building_calculator.calculations.CalculationsMetals
import com.codart.building_calculator.calculations.Round
import com.codart.building_calculator.db.Note
import com.codart.building_calculator.db.NoteDB
import com.codart.building_calculator.ui.MainActivity
import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.sin
import kotlin.math.sqrt


class CalculationsFragment46_47 : Fragment() {

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText
    private lateinit var input5: EditText
    private lateinit var input6: EditText

    private lateinit var txt1: TextView
    private lateinit var txt2: TextView

    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView
    private lateinit var img: ImageView

    private lateinit var btn1: AppCompatButton
    private lateinit var btn2: AppCompatButton

    private var calculationID=46

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations46_47, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        calculationID=requireActivity().intent.getIntExtra("id",46)

        input1 =requireView().findViewById(R.id.calculations46_input1)
        input2 =requireView().findViewById(R.id.calculations46_input2)
        input3 =requireView().findViewById(R.id.calculations46_input3)
        input4 =requireView().findViewById(R.id.calculations46_input4)
        input5 =requireView().findViewById(R.id.calculations46_input5)
        input6 =requireView().findViewById(R.id.calculations46_input6)
        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations46)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations46)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations46)
        img=requireView().findViewById(R.id.img_calculations46)
        txt1=requireView().findViewById(R.id.txt4_46)
        txt2=requireView().findViewById(R.id.txt5_46)
        btn1=requireView().findViewById(R.id.btn1_calculations46)
        btn2=requireView().findViewById(R.id.btn2_calculations46)
        setBottomButtons()
        setLayout()
        checkFields()
        setListeners()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun setLayout(){
        when(calculationID+1)
        {
            46->layout46()
            47->layout47()
        }
    }
    fun checkFields()
    {
        var nSide=0
        var nDeg=0
        if(input1.text.isNotEmpty())
            nSide++
        if(input2.text.isNotEmpty())
            nSide++
        if(input3.text.isNotEmpty())
            nSide++
        if(input4.text.isNotEmpty())
            nDeg++
        if(input5.text.isNotEmpty())
            nDeg++
        if(input6.text.isNotEmpty())
            nDeg++
        if(nDeg==1 && nSide==2 || nDeg==2 && nSide==1)
            calculate()
    }
    fun calculate(){
        var k=0.0
        if(input1.text.isNotEmpty() && input4.text.isNotEmpty())
        {
            k=input1.text.toString().toDouble()/ sin(input4.text.toString().toDouble()/360*2*PI)
        }
        else if(input2.text.isNotEmpty() && input5.text.isNotEmpty())
        {
            k=input2.text.toString().toDouble()/ sin(input5.text.toString().toDouble()/360*2*PI)
        }
        else if(input3.text.isNotEmpty() && input6.text.isNotEmpty())
        {
            k=input3.text.toString().toDouble()/ sin(input6.text.toString().toDouble()/360*2*PI)
        }

        if(input1.text.isNotEmpty() xor input4.text.isNotEmpty())
        {
            if(input1.text.isNotEmpty())
            {
                val deg= asin(input1.text.toString().toDouble()/k)/2/PI*360
                input4.setText(Round.round(deg).toString())
            }
            else
            {
                val side = k*sin(input4.text.toString().toDouble()/360*2*PI)
                input1.setText(Round.round(side).toString())
            }
        }
        else if(input2.text.isNotEmpty() xor input5.text.isNotEmpty())
        {
            if(input2.text.isNotEmpty())
            {
                val deg= asin(input2.text.toString().toDouble()/k)/2/PI*360
                input5.setText(Round.round(deg).toString())
            }
            else
            {
                val side = k*sin(input5.text.toString().toDouble()/360*2*PI)
                input2.setText(Round.round(side).toString())
            }
        }
        else if(input3.text.isNotEmpty() xor input6.text.isNotEmpty())
        {
            if(input3.text.isNotEmpty())
            {
                val deg= asin(input3.text.toString().toDouble()/k)/2/PI*360
                input6.setText(Round.round(deg).toString())
            }
            else
            {
                val side = k*sin(input6.text.toString().toDouble()/360*2*PI)
                input3.setText(Round.round(side).toString())
            }
        }
        if(input4.text.isEmpty())
        {
            input4.setText((180.0-input5.text.toString().toDouble()-input6.text.toString().toDouble()).toString())
        }
        if(input5.text.isEmpty())
        {
            input5.setText((180.0-input4.text.toString().toDouble()-input6.text.toString().toDouble()).toString())
        }
        if(input6.text.isEmpty())
        {
            input6.setText((180.0-input5.text.toString().toDouble()-input4.text.toString().toDouble()).toString())
        }
        if(input1.text.isEmpty())
        {
            val side = k*sin(input4.text.toString().toDouble()/360*2*PI)
            input1.setText(Round.round(side).toString())
        }
        if(input2.text.isEmpty())
        {
            val side = k*sin(input5.text.toString().toDouble()/360*2*PI)
            input2.setText(Round.round(side).toString())
        }
        if(input3.text.isEmpty())
        {
            val side = k*sin(input6.text.toString().toDouble()/360*2*PI)
            input3.setText(Round.round(side).toString())
        }
        if(calculationID==45)
        {
            val p = (input1.text.toString().toDouble()+input1.text.toString().toDouble()+input1.text.toString().toDouble())/2
            val s= sqrt(p*(p-input1.text.toString().toDouble())*(p-input2.text.toString().toDouble())*(p-input3.text.toString().toDouble()))
            val h=2*s/input3.text.toString().toDouble()
            txt1.setText("Площадь: ${Round.round(s)}")
            txt2.setText("h: ${Round.round(h)}")
        }
    }
    private fun getLine(s: String, input: EditText): String
    {
        return s+" "+input.text.toString()
    }
    private fun getInfoAboutCalculations(): String{
        return """
            ${getLine("a", input1)}
            ${getLine("b", input2)}
            ${getLine("c", input3)}
            ${getLine("α", input4)}
            ${getLine("β", input5)}
            ${getLine("γ", input6)}        
        """.trimIndent()
    }
    private fun getInfoResultAboutCalculations(): String{
        return """
            ${getLine("a", input1)}
            ${getLine("b", input2)}
            ${getLine("c", input3)}
            ${getLine("α", input4)}
            ${getLine("β", input5)}
            ${getLine("γ", input6)}        
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
                val id = calculationID+1
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
    private fun setBottomButtons(){
        setCopyButton()
        setHomeButton()
        setSaveButton()
    }
    private fun setListeners(){
        btn2.setOnClickListener {
            checkFields()
        }
        btn1.setOnClickListener {
            input1.text.clear()
            input2.text.clear()
            input3.text.clear()
            input4.text.clear()
            input5.text.clear()
            if(calculationID==45)
                input6.text.clear()
            txt1.text = ""
            txt2.text = ""
        }
    }
    private fun layout47(){

        fun setView(){
            img.setImageResource(R.drawable.ic_triangles_2)
           input6.setText("90")
            input6.isEnabled = false
        }
        setView()
    }
    private fun layout46(){

        fun setView(){
            img.setImageResource(R.drawable.ic_triangles_1)
        }
        setView()
    }
}