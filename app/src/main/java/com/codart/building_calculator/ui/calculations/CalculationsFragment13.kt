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
import com.codart.building_calculator.db.Note
import com.codart.building_calculator.db.NoteDB
import com.codart.building_calculator.ui.MainActivity
import com.codart.building_calculator.ui.SpinnerAdapter
import kotlin.math.floor

class CalculationsFragment13 : Fragment() {

    private lateinit var spinner1: Spinner

    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView


    private lateinit var txt1: TextView
    private lateinit var txt2: TextView
    private lateinit var txt3: TextView
    private lateinit var txt4: TextView
    private lateinit var txt5: TextView
    private lateinit var txt6: TextView

    val array1= arrayOf("","35-150 кг/см2","10-50 кг/см2","5-20 кг/см2","20-50 кг/см2","25-75 кг/см2","50-150 кг/см2")
    val array2= arrayOf("","600-1800 кг/м3","450-900 кг/м3","200-600 кг/м3","500-900 кг/м3","500-1000 кг/м3","1000-2000 кг/м3")
    val array3= arrayOf("","0.15-0.45 Вт/м*С","0.10-0.40 Вт/м*С","0.10-0.30 Вт/м*С","0.20-0.30 Вт/м*С","0.30-0.50 Вт/м*С","0.30-0.80 Вт/м*С")
    val array4= arrayOf("","50-200 цикл","25-50 цикл","10-30 цикл","25-100 цикл","20 цикл","50-200 цикл")
    val array5= arrayOf("","0 %","0.6-1.2 %","1.5 %","0.5-1.0 %","0 %","0 %")
    val array6= arrayOf("","50 %","95 %","100 %","60-80 %","75 %","40 %")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations13, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations13)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations13)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations13)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations13)

        txt1=requireView().findViewById(R.id.calculations13_txt1)
        txt2=requireView().findViewById(R.id.calculations13_txt2)
        txt3=requireView().findViewById(R.id.calculations13_txt3)
        txt4=requireView().findViewById(R.id.calculations13_txt4)
        txt5=requireView().findViewById(R.id.calculations13_txt5)
        txt6=requireView().findViewById(R.id.calculations13_txt6)

        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    private fun calculate(){
        txt1.setText(array1[spinner1.selectedItemPosition])
        txt2.setText(array2[spinner1.selectedItemPosition])
        txt3.setText(array3[spinner1.selectedItemPosition])
        txt4.setText(array4[spinner1.selectedItemPosition])
        txt5.setText(array5[spinner1.selectedItemPosition])
        txt6.setText(array6[spinner1.selectedItemPosition])
    }



    private fun setSpinnersAdapters(){
        val array=resources.getStringArray(R.array.calculations13_array1)
        val adapter = SpinnerAdapter(requireContext(), array)
        spinner1.adapter=adapter
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
            val input1Value=requireContext().resources.getString(R.string.calculation13_text1)+" "+spinner1.selectedItem.toString()
            val input2Value=requireContext().resources.getString(R.string.calculation11_text3)+" "+txt1.text
            val input3Value=requireContext().resources.getString(R.string.calculation11_text4)+" "+txt2.text
            val input4Value=requireContext().resources.getString(R.string.calculation11_text2)+" "+txt3.text
            val input5Value=requireContext().resources.getString(R.string.calculation11_text3)+" "+txt4.text
            val input6Value=requireContext().resources.getString(R.string.calculation11_text4)+" "+txt5.text
            val input7Value=requireContext().resources.getString(R.string.calculation11_text5)+" "+txt6.text
            return """
            $input1Value
            $input2Value
            $input3Value
            $input4Value
            $input5Value
            $input6Value
            $input7Value          
        """.trimIndent()

    }
    private fun getInfoResultAboutCalculations(): String{
        val input1Value=requireContext().resources.getString(R.string.calculation13_text1)+" "+spinner1.selectedItem.toString()
        val input2Value=requireContext().resources.getString(R.string.calculation11_text3)+" "+txt1.text
        val input3Value=requireContext().resources.getString(R.string.calculation11_text4)+" "+txt2.text
        val input4Value=requireContext().resources.getString(R.string.calculation11_text2)+" "+txt3.text
        val input5Value=requireContext().resources.getString(R.string.calculation11_text3)+" "+txt4.text
        val input6Value=requireContext().resources.getString(R.string.calculation11_text4)+" "+txt5.text
        val input7Value=requireContext().resources.getString(R.string.calculation11_text5)+" "+txt6.text
        return """
            $input1Value
            $input2Value
            $input3Value
            $input4Value
            $input5Value
            $input6Value
            $input7Value          
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
                val id = 13
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

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                calculate()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
    }
}