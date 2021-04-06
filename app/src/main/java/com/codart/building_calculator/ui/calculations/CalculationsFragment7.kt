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
import com.codart.building_calculator.models.Values
import com.codart.building_calculator.ui.MainActivity
import com.codart.building_calculator.ui.ValuesSpinnerAdapter


class CalculationsFragment7 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var sizeA: EditText
    private lateinit var sizeB: EditText
    private lateinit var sizeC: EditText
    private lateinit var price: EditText
    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView
    private lateinit var result5: TextView
    private lateinit var result6: TextView
    private lateinit var result7: TextView
    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations7, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations7)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations7)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations7)

        sizeA =requireView().findViewById(R.id.calculations7_sizeA)
        sizeB =requireView().findViewById(R.id.calculations7_sizeB)
        sizeC =requireView().findViewById(R.id.calculations7_sizeC)


        result1 =requireView().findViewById(R.id.calculations7_result1)
        result2 =requireView().findViewById(R.id.calculations7_result2)
        result3 =requireView().findViewById(R.id.calculations7_result3)
        result4 =requireView().findViewById(R.id.calculations7_result4)
        result5 =requireView().findViewById(R.id.calculations7_result5)
        result6 =requireView().findViewById(R.id.calculations7_result6)
        result7 =requireView().findViewById(R.id.calculations7_result7)

        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations7)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations7)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations7)



        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(sizeA.text.isNotEmpty() && sizeB.text.isNotEmpty() && sizeC.text.isNotEmpty()) {
            calculate1to6results()
        }

    }
    private fun calculate1to6results(){
        val a= getSizeAinMetres()
        val b= getSizeBinMetres()
        val c= getSizeCinMetres()

        var res2=a-2*c

        var res1=((Values.pi*a*a/4)-(res2*res2*Values.pi/4))*b
        var res3=(res2*res2*Values.pi*b/4)

        var res4=b
        var res5=Values.pi*(a+res2)/2
        var res6=res4*res5
        var res7=res1*Values.densityBeton

        if(a-2*c>0) {
            result1.text = "${Round.round(res1)} м3"
            result2.text = "${Round.round(res2)} м"
            result3.text = "${Round.round(res3)} м3"
            result4.text = "${Round.round(res4)} м"
            result5.text = "${Round.round(res5)} м"
            result6.text = "${Round.round(res6)} м2"
            result7.text = "${Round.round(res7)} кг"
        }
    }
    private fun getSizeAinMetres(): Double{
        return when(spinner1.selectedItemPosition){
            0 -> sizeA.text.toString().toDouble()
            1 -> sizeA.text.toString().toDouble() / 100
            2 -> sizeA.text.toString().toDouble() / 1000
            else -> 0.toDouble()
        }
    }
    private fun getSizeBinMetres(): Double{
        return when(spinner2.selectedItemPosition){
            0 -> sizeB.text.toString().toDouble()
            1 -> sizeB.text.toString().toDouble() / 100
            2 -> sizeB.text.toString().toDouble() / 1000
            else -> 0.toDouble()
        }
    }
    private fun getSizeCinMetres(): Double{
        return when(spinner3.selectedItemPosition){
            0 -> sizeC.text.toString().toDouble()
            1 -> sizeC.text.toString().toDouble() / 100
            2 -> sizeC.text.toString().toDouble() / 1000
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
        val array=resources.getStringArray(R.array.array_values)
        val customDropDownAdapter = ValuesSpinnerAdapter(requireContext(), array)
        spinner1.adapter=customDropDownAdapter
        spinner2.adapter=customDropDownAdapter
        spinner3.adapter=customDropDownAdapter
        spinner3.setSelection(1)
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
        val sizeAValue=requireContext().resources.getString(R.string.sizeA)+" "+sizeA.text.toString()+" "+getSpinnerItem(spinner1)
        val sizeBValue=requireContext().resources.getString(R.string.sizeB)+" "+sizeB.text.toString()+" "+getSpinnerItem(spinner2)
        val sizeCValue=requireContext().resources.getString(R.string.sizeC)+" "+sizeC.text.toString()+" "+getSpinnerItem(spinner3)
        val priceValue=requireContext().resources.getString(R.string.priceBeton)+" "+price.text.toString()
        val res1Value=requireContext().resources.getString(R.string.calculation1_result1)+" "+result1.text.toString()
        val res2Value=requireContext().resources.getString(R.string.calculation1_result2)+" "+result2.text.toString()
        val res3Value=requireContext().resources.getString(R.string.calculation1_result3)+" "+result3.text.toString()
        val res4Value=requireContext().resources.getString(R.string.calculation1_result4)+" "+result4.text.toString()
        val res5Value=requireContext().resources.getString(R.string.calculation1_result5)+" "+result5.text.toString()
        val res6Value=requireContext().resources.getString(R.string.calculation1_result6)+" "+result6.text.toString()
        val res7Value=requireContext().resources.getString(R.string.calculation1_result7)+" "+result7.text.toString()
        return """
            $sizeAValue
            $sizeBValue
            $sizeCValue
            $priceValue
            $res1Value
            $res2Value
            $res3Value
            $res4Value
            $res5Value
            $res6Value
            $res7Value
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
        return """"
            $res1Value
            $res2Value
            $res3Value
            $res4Value
            $res5Value
            $res6Value
            $res7Value
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
                val id = 7
                val note = Note(title, info, id, price.text.toString())
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
        sizeA.doAfterTextChanged {
            checkMetricFields()
        }
        sizeB.doAfterTextChanged {
            checkMetricFields()
        }
        sizeC.doAfterTextChanged {
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
    }

}