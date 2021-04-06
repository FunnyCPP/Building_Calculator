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

class CalculationsFragment5 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner
    private lateinit var spinner5: Spinner
    private lateinit var sizeA: EditText
    private lateinit var sizeB: EditText
    private lateinit var sizeC: EditText
    private lateinit var sizeD: EditText
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
        return inflater.inflate(R.layout.fragment_calculations5, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations5)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations5)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations5)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations5)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations5)

        sizeA =requireView().findViewById(R.id.calculations5_sizeA)
        sizeB =requireView().findViewById(R.id.calculations5_sizeB)
        sizeC =requireView().findViewById(R.id.calculations5_sizeC)
        sizeD =requireView().findViewById(R.id.calculations5_sizeD)
        price =requireView().findViewById(R.id.calculations5_price)

        result1 =requireView().findViewById(R.id.calculations5_result1)
        result2 =requireView().findViewById(R.id.calculations5_result2)
        result3 =requireView().findViewById(R.id.calculations5_result3)
        result4 =requireView().findViewById(R.id.calculations5_result4)
        result5 =requireView().findViewById(R.id.calculations5_result5)
        result6 =requireView().findViewById(R.id.calculations5_result6)
        result7 =requireView().findViewById(R.id.calculations5_result7)

        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations5)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations5)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations5)



        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(sizeA.text.isNotEmpty() && sizeB.text.isNotEmpty() && sizeC.text.isNotEmpty() && sizeD.text.isNotEmpty()) {
            calculate1to6results()
            if(price.text.isNotEmpty())
                calculate7result()
        }

    }
    private fun calculate1to6results(){
        val a= getSizeAinMetres()
        val b= getSizeBinMetres()
        val c= getSizeCinMetres()
        val d= getSizeDinMetres()

        val res1=a*b-((a-2*d)*(b-2*d))+(a-2*d)*d+(b-2*d)*d-d*d
        val res2=res1*c
        val res3=(a+b)*2
        val res4=(a*c+b*c)*2
        val res5=res2* Values.densityBeton
        val res6=(res5/res1)/10000

        result1.text= "${Round.round(res1)} м2"
        result2.text= "${Round.round(res2)} м3"
        result3.text= "${Round.round(res3)} м"
        result4.text= "${Round.round(res4)} м2"
        result5.text= "${Round.round(res5)} кг"
        result6.text= "${Round.round(res6)} кг/см2"
    }
    private fun calculate7result(){
        val a= getSizeAinMetres()
        val b= getSizeBinMetres()
        val c= getSizeCinMetres()
        val d= getSizeDinMetres()

        val res1=a*b-((a-2*d)*(b-2*d))+(a-2*d)*d+(b-2*d)*d-d*d
        val res2=res1*c
        val res5=res2* Values.densityBeton
        val pr=getPrice()
        val res= Round.round(res2*pr)
        result7.text=  "$res ${spinner5.selectedItem}"
    }
    private fun getPrice(): Double{
        return price.text.toString().toDouble()
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
    private fun getSizeDinMetres(): Double{
        return when(spinner4.selectedItemPosition){
            0 -> sizeD.text.toString().toDouble()
            1 -> sizeD.text.toString().toDouble() / 100
            2 -> sizeD.text.toString().toDouble() / 1000
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
        spinner4.adapter=customDropDownAdapter
        spinner3.setSelection(1)
        spinner4.setSelection(1)
        array=resources.getStringArray(R.array.array_currencies)
        customDropDownAdapter = ValuesSpinnerAdapter(requireContext(), array)
        spinner5.adapter=customDropDownAdapter
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
        val sizeDValue=requireContext().resources.getString(R.string.sizeD)+" "+sizeD.text.toString()+" "+getSpinnerItem(spinner4)
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
            $sizeDValue
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
                val id = 5
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
        sizeD.doAfterTextChanged {
            checkMetricFields()
        }
        price.doAfterTextChanged {
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