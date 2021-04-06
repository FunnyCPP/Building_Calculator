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
import kotlin.math.ceil


class CalculationsFragment26 : Fragment() {

    val ARRAY= arrayOf("0,53 м. x 8 м.", "0,53 м. x 10 м."," 0,53 м. x 12 м."," 0,53 м. x 15 м.",
            " 0,60 м. x 8 м."," 0,60 м. x 10 м."," 0,74 м. x 10 м."," 1,06 м. x 5 м."," 1,06 м. x 10 м.",
            " 1,06 м. x 12 м."," 1,06 м. x 25 м.")

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: TextView
    private lateinit var spinner3: TextView
    private lateinit var spinner5: Spinner


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

    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox


    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    private lateinit var txt1: TextView
    private lateinit var txt2: TextView
    private lateinit var txt3: TextView
    private lateinit var txt4: TextView
    private lateinit var txt5: TextView

    var a = 0.0
    var b = 0.0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations26, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations26)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations26)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations26)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations26)


        input1 =requireView().findViewById(R.id.calculations26_input1)
        input2 =requireView().findViewById(R.id.calculations26_input2)
        input3 =requireView().findViewById(R.id.calculations26_input3)
        input4 =requireView().findViewById(R.id.calculations26_input4)
        input5 =requireView().findViewById(R.id.calculations26_input5)
        input6 =requireView().findViewById(R.id.calculations26_input6)


        result1 =requireView().findViewById(R.id.calculations26_result1)
        result2 =requireView().findViewById(R.id.calculations26_result2)
        result3 =requireView().findViewById(R.id.calculations26_result3)
        result4 =requireView().findViewById(R.id.calculations26_result4)
        result5 =requireView().findViewById(R.id.calculations26_result5)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations26)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations26)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations26)

        checkBox1=requireView().findViewById(R.id.calculations26_checkBox1)
        checkBox2=requireView().findViewById(R.id.calculations26_checkBox2)

        txt1=requireView().findViewById(R.id.txt1_calculations26)
        txt2=requireView().findViewById(R.id.txt2_calculations26)
        txt3=requireView().findViewById(R.id.txt3_calculations26)
        txt4=requireView().findViewById(R.id.txt4_calculations26)
        txt5=requireView().findViewById(R.id.txt5_calculations26)


        setCheckBoxes()
        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(checkBox1.isChecked)
        {
            if(input3.text.isNotEmpty() && input4.text.isNotEmpty() && input5.text.isNotEmpty() && input6.text.isNotEmpty()  ) {
                getSizes()
                calculate1to6results()
            }
        }
        if(checkBox2.isChecked) {
            if(input1.text.isNotEmpty() && input2.text.isNotEmpty() &&input3.text.isNotEmpty() && input4.text.isNotEmpty() && input5.text.isNotEmpty() && input6.text.isNotEmpty()  ) {
                a=input1.text.toString().toDouble()
                b=input2.text.toString().toDouble()
                calculate1to6results()
            }
        }
    }
    fun getSizes(){
         when(spinner1.selectedItemPosition)
        {
            0->{a=0.53;b=8.0}
            1->{a=0.53;b=10.0}
            2->{a=0.53;b=12.0}
            3->{a=0.53;b=15.0}
            4->{a=0.6;b=8.8}
            5->{a=0.6;b=10.0}
            6->{a=0.74;b=10.0}
            7->{a=1.06;b=5.0}
            8->{a=1.06;b=10.0}
            9->{a=1.06;b=12.0}
            10->{a=1.06;b=25.0}
        }
    }
    private fun calculate1to6results(){
        val c=input5.text.toString().toDouble()
        val d=input6.text.toString().toDouble()
        val e=input3.text.toString().toDouble()/100

        var res1=c*d
        var res3= ceil(c/a)
        var res4=ceil(d/e)*e
        var res2= ceil((res3*res4)/b)
        var res5= res2*input4.text.toString().toDouble()

        result1.text = "${Round.round(res1)} м2"
        result2.text = "${Round.round(res2)} шт"
        result3.text = "${Round.round(res3)} шт"
        result4.text = "${Round.round(res4)} м"
        result5.text = "${Round.round(res5)} ${spinner5.selectedItem}"

    }
    private fun setSpinnersAdapters(){

        var adapter = SpinnerAdapter(requireContext(), ARRAY)
        spinner1.adapter=adapter
        val array=resources.getStringArray(R.array.array_currencies)
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
        var text1=""
        if(checkBox1.isChecked)
        {
            val input=requireContext().resources.getString(R.string.calculation26_text1)+" "+ARRAY[spinner1.selectedItemPosition]
            val input2=requireContext().resources.getString(R.string.calculation26_text4)+" "+input3.text.toString()+" см"
            val input3=requireContext().resources.getString(R.string.calculation26_text5)+" "+input4.text.toString()+" руб"
            val input4=requireContext().resources.getString(R.string.calculation26_text6)+" "+input5.text.toString()+" м"
            val input5=requireContext().resources.getString(R.string.calculation26_text7)+" "+input6.text.toString()+" м"
            text1= """
            $input           
            $input2
            $input3
            $input4
            
        """.trimIndent()
        }
        else{
            val input1Value=requireContext().resources.getString(R.string.calculation26_text2)+" "+input1.text.toString()+" м"
            val input2Value=requireContext().resources.getString(R.string.calculation26_text3)+" "+input1.text.toString()+" м"
            val input2=requireContext().resources.getString(R.string.calculation26_text4)+" "+input3.text.toString()+" см"
            val input3=requireContext().resources.getString(R.string.calculation26_text5)+" "+input4.text.toString()+" руб"
            val input4=requireContext().resources.getString(R.string.calculation26_text6)+" "+input5.text.toString()+" м"
            val input5=requireContext().resources.getString(R.string.calculation26_text7)+" "+input6.text.toString()+" м"
            text1= """
            $input1Value
          
         
        """.trimIndent()
        }
        val res="""
            ${requireContext().resources.getString(R.string.calculation26_text8)+" "+result1.text.toString()}
            ${requireContext().resources.getString(R.string.calculation26_text9)+" "+result2.text.toString()}
            ${requireContext().resources.getString(R.string.calculation26_text10)+" "+result3.text.toString()}
            ${requireContext().resources.getString(R.string.calculation26_text11)+" "+result4.text.toString()}
            ${requireContext().resources.getString(R.string.calculation26_text12)+" "+result5.text.toString()}
        """.trimIndent()
        return text1+res

    }
    private fun getInfoResultAboutCalculations(): String{
        return """
            ${requireContext().resources.getString(R.string.calculation26_text8)+" "+result1.text.toString()}
            ${requireContext().resources.getString(R.string.calculation26_text9)+" "+result2.text.toString()}
            ${requireContext().resources.getString(R.string.calculation26_text10)+" "+result3.text.toString()}
            ${requireContext().resources.getString(R.string.calculation26_text11)+" "+result4.text.toString()}
            ${requireContext().resources.getString(R.string.calculation26_text12)+" "+result5.text.toString()}
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
                val id = 26
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
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
            input1.visibility = View.GONE
            input2.visibility = View.GONE
            spinner2.visibility= View.GONE
            spinner3.visibility= View.GONE
            txt2.visibility = View.GONE
            txt3.visibility = View.GONE
            txt1.visibility = View.VISIBLE
            spinner1.visibility = View.VISIBLE
        }

        }
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setOnClickListener {
                checkBox1.isChecked = false
                checkBox2.isChecked = true
                input1.visibility = View.VISIBLE
                input2.visibility = View.VISIBLE
                spinner2.visibility= View.VISIBLE
                spinner3.visibility= View.VISIBLE
                txt2.visibility = View.VISIBLE
                txt3.visibility = View.VISIBLE
                txt1.visibility = View.GONE
                spinner1.visibility = View.GONE
            }

        }
    }

}