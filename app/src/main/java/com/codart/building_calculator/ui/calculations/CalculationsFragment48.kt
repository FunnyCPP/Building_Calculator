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
import kotlin.math.floor

class CalculationsFragment48 : Fragment() {


    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText


    private lateinit var result1: TextView



    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations48, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {




        input1 =requireView().findViewById(R.id.calculations48_input1)
        input2 =requireView().findViewById(R.id.calculations48_input2)
        input3 =requireView().findViewById(R.id.calculations48_input3)

        result1 =requireView().findViewById(R.id.calculations48_result1)



        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations48)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations48)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations48)

        checkFields()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty()  && input3.text.isNotEmpty()){
            calculate1to6results()
        }
    }
    private fun calculate1to6results(){
        val a=input1.text.toString().toDouble()
        val b=input2.text.toString().toDouble()
        val c=input3.text.toString().toDouble()

        var res1=a*c/b
        result1.text = "${Round.round(res1)} Па\n${Round.round(res1/1000)} кПа\n${Round.round(res1/100000)} Бар\n${Round.round(res1/100000/9.80666)} Атм\n${Round.round(res1/100000*0.9806)} кГс/см2\n${Round.round(res1/100000*0.068947)} фунт/дюйм2\n"

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
        val input1Value=requireContext().resources.getString(R.string.calculation48_text1)+" "+input1.text.toString()+" кг"
        val input2Value=requireContext().resources.getString(R.string.calculation48_text2)+" "+input2.text.toString()+" м2"
        val input3Value=requireContext().resources.getString(R.string.calculation48_text3)+" "+input3.text.toString()+" м/cм2"

        val res1=requireContext().resources.getString(R.string.calculation48_text4)+" "+result1.text.toString()


        return """
            $input1Value
            $input2Value
            $input3Value       
            $res1                   
        """.trimIndent()

    }
    private fun getInfoResultAboutCalculations(): String{
        val res1=requireContext().resources.getString(R.string.calculation48_text4)+" "+result1.text.toString()
        return """"
            $res1         
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
                val id = 48
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
    }

}