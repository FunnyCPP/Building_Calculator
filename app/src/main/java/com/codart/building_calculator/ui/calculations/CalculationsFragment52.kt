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
import com.codart.building_calculator.calculations.CalculationsMetals
import com.codart.building_calculator.calculations.Round
import com.codart.building_calculator.db.Note
import com.codart.building_calculator.db.NoteDB
import com.codart.building_calculator.ui.MainActivity
import com.codart.building_calculator.ui.SpinnerAdapter

class CalculationsFragment52 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner
    private lateinit var spinner5: Spinner
    private lateinit var spinner6: TextView
    private lateinit var spinner7: TextView
    private lateinit var spinner8: Spinner


    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText
    private lateinit var input5: EditText
    private lateinit var input6: EditText
    private lateinit var input7: EditText

    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView
    private lateinit var result5: TextView

    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    private lateinit var txt1: TextView
    private lateinit var txt2: TextView
    private lateinit var txt3: TextView
    private lateinit var txt4: TextView
    private lateinit var txt5: TextView
    private lateinit var txt6: TextView
    private lateinit var txt7: TextView
    private lateinit var txt8: TextView
    private lateinit var txt9: TextView
    private lateinit var txt10: TextView
    private lateinit var txt11: TextView
    private lateinit var txt12: TextView

    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox

    private lateinit var img: ImageView


    private var s=0.0
    private var calculationID=52


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations52, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         calculationID=requireActivity().intent.getIntExtra("id",52)
        spinner1 =requireView().findViewById(R.id.spinner1_calculations52)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations52)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations52)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations52)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations52)
        spinner6 =requireView().findViewById(R.id.spinner6_calculations52)
        spinner7 =requireView().findViewById(R.id.spinner7_calculations52)
        spinner8 =requireView().findViewById(R.id.spinner8_calculations52)

        input1 =requireView().findViewById(R.id.calculations52_input1)
        input2 =requireView().findViewById(R.id.calculations52_input2)
        input3 =requireView().findViewById(R.id.calculations52_input3)
        input4 =requireView().findViewById(R.id.calculations52_input4)
        input5 =requireView().findViewById(R.id.calculations52_input5)
        input6 =requireView().findViewById(R.id.calculations52_input6)
        input7 =requireView().findViewById(R.id.calculations52_input7)


        result1 =requireView().findViewById(R.id.calculations52_result1)
        result2 =requireView().findViewById(R.id.calculations52_result2)
        result3 =requireView().findViewById(R.id.calculations52_result3)
        result4 =requireView().findViewById(R.id.calculations52_result4)
        result5 =requireView().findViewById(R.id.calculations52_result5)



        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations52)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations52)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations52)

        txt1=requireView().findViewById(R.id.calculations52_txt1)
        txt2=requireView().findViewById(R.id.calculations52_txt2)
        txt3=requireView().findViewById(R.id.calculations52_txt3)
        txt4=requireView().findViewById(R.id.calculations52_txt4)
        txt5=requireView().findViewById(R.id.calculations52_txt5)
        txt6=requireView().findViewById(R.id.calculations52_txt6)
        txt7=requireView().findViewById(R.id.calculations52_txt7)
        txt8=requireView().findViewById(R.id.calculations52_txt8)
        txt9=requireView().findViewById(R.id.calculations52_txt9)
        txt10=requireView().findViewById(R.id.calculations52_txt10)
        txt11=requireView().findViewById(R.id.calculations52_txt11)
        txt12=requireView().findViewById(R.id.calculations52_txt12)

        checkBox1=requireView().findViewById(R.id.calculations52_checkBox1)
        checkBox2=requireView().findViewById(R.id.calculations52_checkBox2)

        img=requireView().findViewById(R.id.img_calculations52)

        setSpinnersAdapters()
        setBottomButtons()
        setCheckboxes()
        setLayout()
        checkFields()

        super.onViewCreated(view, savedInstanceState)
    }
    private fun setLayout(){
        when(calculationID+1)
        {
            52->layout52()
            58->layout58()
            60->layout60()
            64->layout64()
            67->layout67()
            71->layout71()
            72->layout72()
            73->layout73()
        }
    }
    private fun layout52(){
        fun setS(){
            s= CalculationsMetals.calculateSofPipe(
                    getFieldInM(input1,spinner2),getFieldInM(input2,spinner3),getFieldInM(input3,spinner4)
            )
        }
        fun setView(){
            val imageTitle= "ic_metals_pipe_ab"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            setVisibilityGone(txt4,input4,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.calculation52_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation52_text2))
            setText(txt3,requireContext().resources.getString(R.string.calculation52_text3))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input5.text.isNotEmpty()  ) {
            setS()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout58(){
        fun setS(){
            s= CalculationsMetals.calculateSofPipe(
                    getFieldInM(input1,spinner2),getFieldInM(input2,spinner3)
            )
        }
        fun setView(){
            val imageTitle= "ic_metals_circle"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            setVisibilityGone(txt3,input3,spinner4)
            setVisibilityGone(txt4,input4,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.calculation52_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation52_text2))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input5.text.isNotEmpty()  ) {
            setS()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout60(){
        fun setS(){
            s= CalculationsMetals.calculateSofCorner(
                    getFieldInM(input1,spinner2),getFieldInM(input2,spinner3),getFieldInM(input3,spinner4)
            )
        }
        fun setView(){
            val imageTitle= "ic_metals_corner_1"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            setVisibilityGone(txt4,input4,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.calculation52_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation52_text2))
            setText(txt3,requireContext().resources.getString(R.string.c))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input5.text.isNotEmpty()  ) {
            setS()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout64(){
        fun setS(){
            s= CalculationsMetals.calculateSofChannel(
                    getFieldInM(input1,spinner2),getFieldInM(input2,spinner3),getFieldInM(input3,spinner4)
            )
        }
        fun setView(){
            val imageTitle= "ic_metals_channel_1"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            setVisibilityGone(txt4,input4,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.calculation52_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation52_text2))
            setText(txt3,requireContext().resources.getString(R.string.c))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input5.text.isNotEmpty()  ) {
            setS()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout67(){
        fun setS(){
            s= CalculationsMetals.calculateSofBeam(
                    getFieldInM(input1,spinner2),getFieldInM(input2,spinner3),getFieldInM(input3,spinner4),getFieldInM(input4,spinner5)
            )
        }
        fun setView(){
            val imageTitle= "ic_metals_beam_1"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            setText(txt1,requireContext().resources.getString(R.string.calculation52_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation52_text2))
            setText(txt3,requireContext().resources.getString(R.string.c))
            setText(txt4,requireContext().resources.getString(R.string.d))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() && input5.text.isNotEmpty()  ) {
            setS()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout71(){
        fun setS(){
            s= CalculationsMetals.calculateSofRectangle(
                    getFieldInM(input1,spinner2),getFieldInM(input1,spinner2)
            )
        }
        fun setView(){
            val imageTitle= "ic_metals_square"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            setVisibilityGone(txt2,input2,spinner3)
            setVisibilityGone(txt3,input3,spinner4)
            setVisibilityGone(txt4,input4,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.calculation52_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation52_text2))
        }
        setView()
        if(input1.text.isNotEmpty()  && input5.text.isNotEmpty()  ) {
            setS()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout72(){
        fun setS(){
            s= CalculationsMetals.calculateSofCircle(
                    getFieldInM(input1,spinner2)
            )
        }
        fun setView(){
            val imageTitle= "ic_metals_circle_1"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            setVisibilityGone(txt2,input2,spinner3)
            setVisibilityGone(txt3,input3,spinner4)
            setVisibilityGone(txt4,input4,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.calculation52_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation52_text2))
        }
        setView()
        if(input1.text.isNotEmpty()  && input5.text.isNotEmpty()  ) {
            setS()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout73(){
        fun setS(){
            s= CalculationsMetals.calculateSofRectangle(
                    getFieldInM(input1,spinner2),getFieldInM(input2,spinner3)
            )
        }
        fun setView(){
            val imageTitle= "ic_metals_rectangle"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            setVisibilityGone(txt3,input3,spinner4)
            setVisibilityGone(txt4,input4,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.calculation52_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation52_text2))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input5.text.isNotEmpty()  ) {
            setS()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun calculateResult1(){

        result1.text = if(checkBox1.isChecked){
            "${Round.round(CalculationsMetals.calculateM(spinner1.selectedItemPosition, s, input5.text.toString().toDouble()))} кг"
        }
        else
        {
            "${Round.round(CalculationsMetals.calculateL(input5.text.toString().toDouble(), spinner1.selectedItemPosition, s))} м"
        }

    }
    private fun calculateResults2_3()
    {
        if(checkBox1.isChecked)
        {
            result2.text="${Round.round(CalculationsMetals.round(CalculationsMetals.calculateM(spinner1.selectedItemPosition,s ,input5.text.toString().toDouble()))*
                    input6.text.toString().toDouble())} кг"
            result3.text="${Round.round(CalculationsMetals.round(input5.text.toString().toDouble()*input6.text.toString().toDouble()))} м"
        }
        else
        {
            val l=CalculationsMetals.calculateL(input5.text.toString().toDouble(), spinner1.selectedItemPosition,
                    CalculationsMetals.calculateSofPipe(
                            getFieldInM(input1,spinner2),getFieldInM(input2,spinner3),getFieldInM(input3,spinner4)
                    )
            )
            result2.text="${Round.round(l*input6.text.toString().toDouble())} м"
            result3.text="${Round.round(CalculationsMetals.round(input5.text.toString().toDouble()*input6.text.toString().toDouble()))} кг"
        }
    }
    private fun calculatePrice()
    {
        val p: Double= when(spinner8.selectedItemPosition)
        {
            0->{
                CalculationsMetals.calculatePrice( input7.text.toString().toDouble()/1000,
                        CalculationsMetals.calculateM(spinner1.selectedItemPosition,s ,input5.text.toString().toDouble()))
            }
            1->{
                CalculationsMetals.calculatePrice(input7.text.toString().toDouble(),
                        CalculationsMetals.calculateM(spinner1.selectedItemPosition,s ,input5.text.toString().toDouble()))
            }
            2->input7.text.toString().toDouble()
            else-> 0.0
        }
        result4.text="${Round.round(p)} руб"
        result5.text=if(input6.text.isNotEmpty())
            "${Round.round(input6.text.toString().toDouble()*p)} руб"
        else
            "${Round.round(p)} руб"

    }
    private fun setVisibilityGone(txt: TextView, input: EditText, spinner: Spinner)
    {
        txt.visibility=View.GONE
        input.visibility=View.GONE
        spinner.visibility=View.GONE
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
            txt.text.toString()+" "+input.text+" "+spinner.selectedItem.toString()
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
    private fun getLine(spinner: Spinner): String =spinner.selectedItem.toString()

    private fun setSpinnersAdapters(){

        var adapter = SpinnerAdapter(requireContext(), requireContext().resources.getStringArray(R.array.array_values))

        spinner3.adapter=adapter
        spinner3.adapter=adapter
        spinner4.adapter=adapter
        spinner5.adapter=adapter
        spinner5.adapter=adapter
        spinner2.adapter=adapter
        adapter = SpinnerAdapter(requireContext(), CalculationsMetals.metalsArray)
        spinner1.adapter=adapter
        adapter = SpinnerAdapter(requireContext(), arrayOf("За тонну","За кг","За штуку"))
        spinner8.adapter=adapter
    }
    private fun getInfoAboutCalculations(): String{
        return """
            ${getLine(spinner1)}
            ${getLine(txt1, input1, spinner2)}
            ${getLine(txt2, input2, spinner3)}
            ${getLine(txt3, input3, spinner4)}
            ${getLine(txt4, input4, spinner5)}
            ${getLine(txt5, input5, "м")}
            ${getLine(txt6, input6, "ед")}
            ${getLine(txt7, input7, spinner8)}
            ${getLine(txt8, result1)}
            ${getLine(txt9, result2)}
            ${getLine(txt10, result3)}
            ${getLine(txt11, result4)}
            ${getLine(txt12, result5)}
        """.trimIndent()
    }
    private fun getInfoResultAboutCalculations(): String{
        return """"
           ${getLine(txt8, result1)}
            ${getLine(txt9, result2)}
            ${getLine(txt10, result3)}
            ${getLine(txt11, result4)}
            ${getLine(txt12, result5)}
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
    private fun checkFields(){
        input1.doAfterTextChanged {
            setLayout()
        }
        input2.doAfterTextChanged {
            setLayout()
        }
        input3.doAfterTextChanged {
            setLayout()
        }
        input4.doAfterTextChanged {
            setLayout()
        }
        input5.doAfterTextChanged {
            setLayout()
        }
        input6.doAfterTextChanged {
            setLayout()
        }
        input7.doAfterTextChanged {
            setLayout()
        }
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                setLayout()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                setLayout()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                setLayout()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                setLayout()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                setLayout()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        spinner8.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                setLayout()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
    }
    private fun setCheckboxes(){
        checkBox1.setOnCheckedChangeListener { buttonView, _ ->
            buttonView.setOnClickListener {
                checkBox1.isChecked=true
                checkBox2.isChecked=false
                txt5.text = requireContext().resources.getString(R.string.calculation52_text4)
                spinner6.text="м"
                txt8.text = requireContext().resources.getString(R.string.calculation52_text8)
                txt9.text = requireContext().resources.getString(R.string.calculation52_text10)
                txt10.text = requireContext().resources.getString(R.string.calculation52_text11)

            }
        }
        checkBox2.setOnCheckedChangeListener { buttonView, _ ->
            buttonView.setOnClickListener {
                checkBox1.isChecked=false
                checkBox2.isChecked=true
                txt5.text = requireContext().resources.getString(R.string.calculation52_text5)
                spinner6.text="кг"
                txt8.text = requireContext().resources.getString(R.string.calculation52_text4)
                txt9.text = requireContext().resources.getString(R.string.calculation52_text11)
                txt10.text = requireContext().resources.getString(R.string.calculation52_text10)

            }
        }
    }
}