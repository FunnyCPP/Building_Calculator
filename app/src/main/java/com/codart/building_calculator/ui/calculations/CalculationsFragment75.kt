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
import com.codart.building_calculator.calculations.CalculationsConverters
import com.codart.building_calculator.db.Note
import com.codart.building_calculator.db.NoteDB
import com.codart.building_calculator.ui.MainActivity

class CalculationsFragment75 : Fragment() {


    private lateinit var input1: EditText
    private lateinit var input2: EditText

    private lateinit var result1: TextView
    private lateinit var result2: TextView


    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    private lateinit var txt1: TextView
    private lateinit var txt2: TextView
    private lateinit var txt3: TextView
    private lateinit var txt4: TextView

    private var calculationID =74

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations75, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        calculationID=requireActivity().intent.getIntExtra("id",88)
        input1 =requireView().findViewById(R.id.calculations75_input1)
        input2 =requireView().findViewById(R.id.calculations75_input3)


        result1 =requireView().findViewById(R.id.calculations75_input2)
        result2 =requireView().findViewById(R.id.calculations75_input4)




        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations75)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations75)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations75)

        txt1=requireView().findViewById(R.id.txt1_calculations75)
        txt2=requireView().findViewById(R.id.txt2_calculations75)
        txt3=requireView().findViewById(R.id.txt3_calculations75)
        txt4=requireView().findViewById(R.id.txt4_calculations75)


        setBottomButtons()
        setLayout()
        checkFields()

        super.onViewCreated(view, savedInstanceState)
    }
    private fun setLayout(){
        when(calculationID)
        {
            88->layout88()
            89->layout89()
            90->layout90()
            91->layout91()
            92->layout92()
            93->layout93()
            94->layout94()
            95->layout95()
            96->layout96()
            97->layout97()
            98->layout98()
            99->layout99()
            100->layout100()
        }
    }
    private fun calculate(){
        if(input1.text.isNotEmpty()) {
            when (calculationID) {
                88 -> {
                    result1.text = "${CalculationsConverters.CtoF(input1.text.toString().toDouble())}"

                }
                89 -> {
                    result1.text = "${CalculationsConverters.SmtoD(input1.text.toString().toDouble())}"

                }
                90 -> {
                    result1.text = "${CalculationsConverters.MtoF(input1.text.toString().toDouble())}"

                }
                91 -> {
                    result1.text = "${CalculationsConverters.MtoYards(input1.text.toString().toDouble())}"

                }
                92 -> {
                    result1.text = "${CalculationsConverters.KgtoFunts(input1.text.toString().toDouble())}"

                }
                93 -> {
                    result1.text = "${CalculationsConverters.GtoFunts(input1.text.toString().toDouble())}"

                }
                94 -> {
                    result1.text = "${CalculationsConverters.GtoOunces(input1.text.toString().toDouble())}"

                }
                95 -> {
                    result1.text = "${CalculationsConverters.JtoKcal(input1.text.toString().toDouble())}"

                }
                96 -> {
                    result1.text = "${CalculationsConverters.JtoKvatt_H(input1.text.toString().toDouble())}"

                }
                97 -> {
                    result1.text = "${CalculationsConverters.LtoPints(input1.text.toString().toDouble())}"

                }
                98 -> {
                    result1.text = "${CalculationsConverters.LtoGallons(input1.text.toString().toDouble())}"

                }
                99 -> {
                    result1.text = "${CalculationsConverters.MpatoKg(input1.text.toString().toDouble())}"

                }
                100 -> {
                    result1.text = "${CalculationsConverters.MpatoFunts(input1.text.toString().toDouble())}"

                }
            }
        }
        if(input2.text.isNotEmpty()) {
            when (calculationID) {
                88 -> {

                    result2.text = "${CalculationsConverters.FtoC(input2.text.toString().toDouble())}"
                }
                89 -> {

                    result2.text = "${CalculationsConverters.DtoSm(input2.text.toString().toDouble())}"
                }
                90 -> {

                    result2.text = "${CalculationsConverters.FtoM(input2.text.toString().toDouble())}"
                }
                91 -> {

                    result2.text = "${CalculationsConverters.YardstoM(input2.text.toString().toDouble())}"
                }
                92 -> {

                    result2.text = "${CalculationsConverters.FuntstoKg(input2.text.toString().toDouble())}"
                }
                93 -> {

                    result2.text = "${CalculationsConverters.FuntstoG(input2.text.toString().toDouble())}"
                }
                94 -> {

                    result2.text = "${CalculationsConverters.OuncestoG(input2.text.toString().toDouble())}"
                }
                95 -> {

                    result2.text = "${CalculationsConverters.KcaltoJ(input2.text.toString().toDouble())}"
                }
                96 -> {

                    result2.text = "${CalculationsConverters.KvatttoJ(input2.text.toString().toDouble())}"
                }
                97 -> {

                    result2.text = "${CalculationsConverters.PintstoL(input2.text.toString().toDouble())}"
                }
                98 -> {

                    result2.text = "${CalculationsConverters.GallonstoL(input2.text.toString().toDouble())}"
                }
                99 -> {

                    result2.text = "${CalculationsConverters.KgtoMpa(input2.text.toString().toDouble())}"
                }
                100 -> {
                    result2.text = "${CalculationsConverters.FuntstoMpa(input2.text.toString().toDouble())}"
                }
            }
        }
    }
    private fun layout88(){
        setText(txt1,requireContext().resources.getString(R.string.calculation88_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation88_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation88_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation88_text1))
    }
    private fun layout89(){
        setText(txt1,requireContext().resources.getString(R.string.calculation89_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation89_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation89_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation89_text1))
    }
    private fun layout90(){
        setText(txt1,requireContext().resources.getString(R.string.calculation90_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation90_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation90_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation90_text1))

    }
    private fun layout91(){
        setText(txt1,requireContext().resources.getString(R.string.calculation91_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation91_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation91_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation91_text1))
    }
    private fun layout92(){
        setText(txt1,requireContext().resources.getString(R.string.calculation92_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation92_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation92_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation92_text1))
    }
    private fun layout93(){
        setText(txt1,requireContext().resources.getString(R.string.calculation93_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation93_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation93_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation93_text1))
    }
    private fun layout94(){
        setText(txt1,requireContext().resources.getString(R.string.calculation94_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation94_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation94_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation94_text1))
    }
    private fun layout95(){
        setText(txt1,requireContext().resources.getString(R.string.calculation95_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation95_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation95_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation95_text1))

    }
    private fun layout96(){
        setText(txt1,requireContext().resources.getString(R.string.calculation96_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation96_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation96_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation96_text1))

    }
    private fun layout97(){
        setText(txt1,requireContext().resources.getString(R.string.calculation97_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation97_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation97_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation97_text1))
    }
    private fun layout98(){
        setText(txt1,requireContext().resources.getString(R.string.calculation98_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation98_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation98_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation98_text1))

    }
    private fun layout99(){
        setText(txt1,requireContext().resources.getString(R.string.calculation99_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation99_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation99_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation99_text1))

    }
    private fun layout100(){
        setText(txt1,requireContext().resources.getString(R.string.calculation100_text1))
        setText(txt2,requireContext().resources.getString(R.string.calculation100_text2))
        setText(txt3,requireContext().resources.getString(R.string.calculation100_text2))
        setText(txt4,requireContext().resources.getString(R.string.calculation100_text1))

    }
    private fun setText(txt: TextView, s: String)
    {
        txt.text=s
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
    private fun getLine(txt: TextView, input: EditText, spinner: Spinner): String
    {
        return if(txt.visibility!=View.GONE)
            txt.text.toString()+" "+input.text+" "+spinner.toString()
        else
            ""
    }
    private fun getLine(txt: TextView, input: EditText, s: String): String
    {
        return if(txt.visibility!=View.GONE)
            txt.text.toString()+" "+input.text+" "+s
        else
            ""
    }
    private fun getLine(txt: TextView, result: TextView): String
    {
        return if(txt.visibility!=View.GONE)
            txt.text.toString()+" "+result.text
        else
            ""
    }
    private fun getLine(s: String, result: TextView): String
    {
        return if(result.visibility!=View.GONE)
            s+" "+result.text
        else
            ""
    }
    private fun getLine(spinner: Spinner): String =spinner.toString()

    private fun getInfoAboutCalculations(): String{
        return """      
            ${getLine(txt1, input1)}
            ${getLine(txt2, result1)}
            ${getLine(txt3, input2)}
            ${getLine(txt4, result2)}     
        """.trimIndent()
    }
    private fun getInfoResultAboutCalculations(): String{
        return """"
           ${getLine(txt2, result1)}
            ${getLine(txt4, result2)} 
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
                val id = calculationID
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
    private fun checkFields(){
        input1.doAfterTextChanged {
            calculate()
        }
        input2.doAfterTextChanged {
            calculate()
        }

    }
}