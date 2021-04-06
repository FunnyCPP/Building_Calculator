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
import kotlin.math.ceil


class CalculationsFragment27 : Fragment() {


    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner
    private lateinit var spinner5: Spinner

    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText
    private lateinit var input5: EditText

    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView

    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox


    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    private lateinit var txt1: TextView
    private lateinit var txt2: TextView
    private lateinit var txt3: TextView

    private lateinit var txt: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations27, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations27)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations27)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations27)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations27)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations27)


        input1 =requireView().findViewById(R.id.calculations27_input1)
        input2 =requireView().findViewById(R.id.calculations27_input2)
        input3 =requireView().findViewById(R.id.calculations27_input3)
        input4 =requireView().findViewById(R.id.calculations27_input4)
        input5 =requireView().findViewById(R.id.calculations27_input5)


        result1 =requireView().findViewById(R.id.calculations27_result1)
        result2 =requireView().findViewById(R.id.calculations27_result2)
        result3 =requireView().findViewById(R.id.calculations27_result3)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations27)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations27)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations27)

        checkBox1=requireView().findViewById(R.id.calculations27_checkBox1)
        checkBox2=requireView().findViewById(R.id.calculations27_checkBox2)


        txt1=requireView().findViewById(R.id.txt1_calculations27)
        txt2=requireView().findViewById(R.id.txt2_calculations27)
        txt3=requireView().findViewById(R.id.txt3_calculations27)
        txt=requireView().findViewById(R.id.txt15_calculations27)



        setCheckBoxes()
        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(checkBox1.isChecked)
        {

                if(input1.text.isNotEmpty() && input4.text.isNotEmpty()  && input5.text.isNotEmpty()  ) {
                    calculate1to6results()
                }
        }
        if(checkBox2.isChecked) {
            if(input1.text.isNotEmpty() &&input2.text.isNotEmpty() && input4.text.isNotEmpty()  && input5.text.isNotEmpty()  ) {
                calculate1to6results()
            }
        }
    }
    private fun calculate1to6results(){
        if(checkBox1.isChecked)
        {
            val res1= ceil(getFieldInM(input1, spinner1)/getFieldInM(input4,spinner4))
            val res2=res1 * input5.text.toString().toDouble()
            result1.text = "${Round.round(res1)} шт"
            result3.text = "${Round.round(res2)} ${spinner5.selectedItem}"
        }
        if(checkBox2.isChecked)
        {
            val res1= ceil(2*(getFieldInM(input2,spinner2)+getFieldInM(input3,spinner3))/getFieldInM(input4,spinner4))
            val res2=res1 * input5.text.toString().toDouble()
            val res=getFieldInM(input2,spinner2)*getFieldInM(input3,spinner3)
            result1.text = "${Round.round(res1)} шт"
            result2.text = "${Round.round(res)} м2"
            result3.text = "${Round.round(res2)} ${spinner5.selectedItem}"
        }


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

        var adapter = SpinnerAdapter(requireContext(), requireContext().resources.getStringArray(R.array.calculations27_array1))
        spinner5.adapter=adapter
        var array=resources.getStringArray(R.array.array_values)
        val adapter2 = ValuesSpinnerAdapter(requireContext(), array)
        spinner4.adapter=adapter2
        spinner3.adapter=adapter2
        spinner1.adapter=adapter2
        spinner2.adapter=adapter2
        array=resources.getStringArray(R.array.array_currencies)
        adapter = SpinnerAdapter(requireContext(), array)
        spinner5.adapter=adapter
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
        if(checkBox1.isChecked)
        {
            val input=requireContext().resources.getString(R.string.calculation27_text1)+" "+input1.text.toString()+" "+spinner1.selectedItem.toString()
            val input2=requireContext().resources.getString(R.string.calculation27_text4)+" "+input4.text.toString()+" "+spinner4.selectedItem.toString()
            val input3=requireContext().resources.getString(R.string.calculation27_text5)+" "+input5.text.toString()+" "+spinner5.selectedItem.toString()
            val res1=requireContext().resources.getString(R.string.calculation27_text7)+" "+result1.text.toString()
            val res2=requireContext().resources.getString(R.string.calculation27_text8)+" "+result2.text.toString()
            val res3=requireContext().resources.getString(R.string.calculation27_text9)+" "+result3.text.toString()
            return """
            $input           
            $input2
            $input3
            $res1
            $res2
            $res3
        """.trimIndent()
        }
        else{
            val input1=requireContext().resources.getString(R.string.calculation27_text2)+" "+input2.text.toString()+" "+spinner2.selectedItem.toString()
            val input2=requireContext().resources.getString(R.string.calculation27_text3)+" "+input3.text.toString()+" "+spinner3.selectedItem.toString()
            val input3=requireContext().resources.getString(R.string.calculation27_text4)+" "+input4.text.toString()+" "+spinner4.selectedItem.toString()
            val input4=requireContext().resources.getString(R.string.calculation27_text5)+" "+input5.text.toString()+" "+spinner5.selectedItem.toString()
            val res1=requireContext().resources.getString(R.string.calculation27_text7)+" "+result1.text.toString()
            val res2=requireContext().resources.getString(R.string.calculation27_text8)+" "+result2.text.toString()
            val res3=requireContext().resources.getString(R.string.calculation27_text9)+" "+result3.text.toString()
            return """
            $input1           
            $input2
            $input3
            $input4
            $res1
            $res2
            $res3
        """.trimIndent()
        }



    }
    private fun getInfoResultAboutCalculations(): String{
        val res1=requireContext().resources.getString(R.string.calculation27_text7)+" "+result1.text.toString()
        val res2=requireContext().resources.getString(R.string.calculation27_text8)+" "+result2.text.toString()
        val res3=requireContext().resources.getString(R.string.calculation27_text9)+" "+result3.text.toString()

        return """"
           $res1
           $res2
           $res3
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
                val id = 27
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
    fun setCheckBoxes()
    {
        checkBox1.setOnCheckedChangeListener { buttonView, isChecked -> buttonView.setOnClickListener {
            checkBox1.isChecked = true
            checkBox2.isChecked = false
            input1.visibility = View.VISIBLE
            txt1.visibility = View.VISIBLE
            spinner1.visibility = View.VISIBLE
            spinner2.visibility= View.GONE
            txt2.visibility = View.GONE
            input2.visibility = View.GONE
            spinner3.visibility= View.GONE
            txt3.visibility = View.GONE
            input3.visibility = View.GONE
            txt.visibility= View.GONE
            result2.visibility= View.GONE
        }

        }
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setOnClickListener {
                checkBox1.isChecked = false
                checkBox2.isChecked = true
                input1.visibility = View.GONE
                txt1.visibility = View.GONE
                spinner1.visibility = View.GONE
                spinner2.visibility= View.VISIBLE
                txt2.visibility = View.VISIBLE
                input2.visibility = View.VISIBLE
                spinner3.visibility= View.VISIBLE
                txt3.visibility = View.VISIBLE
                input3.visibility = View.VISIBLE
                txt.visibility= View.VISIBLE
                result2.visibility= View.VISIBLE
            }

        }

    }
}