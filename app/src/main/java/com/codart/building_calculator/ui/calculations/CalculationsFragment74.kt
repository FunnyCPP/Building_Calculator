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
import com.codart.building_calculator.calculations.CalculationsSquares
import com.codart.building_calculator.calculations.Round
import com.codart.building_calculator.db.Note
import com.codart.building_calculator.db.NoteDB
import com.codart.building_calculator.ui.MainActivity
import com.codart.building_calculator.ui.SpinnerAdapter


class CalculationsFragment74 : Fragment() {

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


    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView
    private lateinit var img: ImageView

    private lateinit var txt1: TextView
    private lateinit var txt2: TextView
    private lateinit var txt3: TextView
    private lateinit var txt4: TextView
    private lateinit var txt5: TextView
    private lateinit var txt6: TextView
    private lateinit var txt7: TextView

    private var calculationID =74

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations74, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        calculationID=requireActivity().intent.getIntExtra("id",74)
        spinner1 =requireView().findViewById(R.id.spinner1_calculations74)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations74)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations74)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations74)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations74)

        input1 =requireView().findViewById(R.id.calculations74_input1)
        input2 =requireView().findViewById(R.id.calculations74_input2)
        input3 =requireView().findViewById(R.id.calculations74_input3)
        input4 =requireView().findViewById(R.id.calculations74_input4)
        input5 =requireView().findViewById(R.id.calculations74_input5)


        result1 =requireView().findViewById(R.id.calculations74_result1)
        result2 =requireView().findViewById(R.id.calculations74_result2)




        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations74)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations74)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations74)
        img=requireView().findViewById(R.id.img_calculations74)

        txt1=requireView().findViewById(R.id.calculations74_txt1)
        txt2=requireView().findViewById(R.id.calculations74_txt2)
        txt3=requireView().findViewById(R.id.calculations74_txt3)
        txt4=requireView().findViewById(R.id.calculations74_txt4)
        txt5=requireView().findViewById(R.id.calculations74_txt5)
        txt6=requireView().findViewById(R.id.calculations74_txt6)
        txt7=requireView().findViewById(R.id.calculations74_txt7)


        setSpinnersAdapters()
        setBottomButtons()
        setLayout()
        checkFields()

        super.onViewCreated(view, savedInstanceState)
    }
    private fun setLayout(){
        when(calculationID)
        {
            74->layout74()
            75->layout75()
            76->layout76()
            77->layout77()
            78->layout78()
            79->layout79()
            80->layout80()
            81->layout81()
            82->layout82()
            83->layout83()
            84->layout84()
            85->layout85()
            86->layout86()
            87->layout87()
        }
    }
    private fun layout74(){
        fun calculate(){
           result1.text ="${Round.round(CalculationsSquares.calculateSofCircle(getFieldInM(input1,spinner1)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofCircle(getFieldInM(input1,spinner1)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_1)
            setVisibilityGone(txt2,input2,spinner2)
            setVisibilityGone(txt3,input3,spinner3)
            setVisibilityGone(txt4,input4,spinner4)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeD))
        }
        setView()
        if(input1.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout75(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofSquare(getFieldInM(input1,spinner1)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofSquare(getFieldInM(input1,spinner1)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_2)
            setVisibilityGone(txt2,input2,spinner2)
            setVisibilityGone(txt3,input3,spinner3)
            setVisibilityGone(txt4,input4,spinner4)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
        }
        setView()
        if(input1.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout76(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofRectangle(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofRectangle(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_3)
            setVisibilityGone(txt3,input3,spinner3)
            setVisibilityGone(txt4,input4,spinner4)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout77(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofTriangle(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofTriangle(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_4)
            setVisibilityGone(txt4,input4,spinner4)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
            setText(txt3,requireContext().resources.getString(R.string.sizeC))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout78(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofTrapezoid1(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofTrapezoid1(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_5)
            setVisibilityGone(txt4,input4,spinner4)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
            setText(txt3,requireContext().resources.getString(R.string.sizeC))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout79(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofTrapezoid2(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofTrapezoid2(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_6)
            setVisibilityGone(txt4,input4,spinner4)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
            setText(txt3,requireContext().resources.getString(R.string.sizeC))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout80(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofRectangle2(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofRectangle2(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_7)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
            setText(txt3,requireContext().resources.getString(R.string.sizeC))
            setText(txt4,requireContext().resources.getString(R.string.sizeD))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()&& input4.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout81(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofRectangle3(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofRectangle3(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_8)
            setVisibilityGone(txt4,input4,spinner4)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
            setText(txt3,requireContext().resources.getString(R.string.sizeC))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout82(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofCircle2(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofCircle2(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_9)
            setVisibilityGone(txt3,input3,spinner3)
            setVisibilityGone(txt4,input4,spinner4)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout83(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofRectangle4(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofRectangle4(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_10)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
            setText(txt3,requireContext().resources.getString(R.string.sizeC))
            setText(txt4,requireContext().resources.getString(R.string.sizeD))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()&& input4.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout84(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofRectangle5(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofRectangle5(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_11)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
            setText(txt3,requireContext().resources.getString(R.string.sizeC))
            setText(txt4,requireContext().resources.getString(R.string.sizeD))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()&& input4.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout85(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofCorner(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofCorner(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_12)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
            setText(txt3,requireContext().resources.getString(R.string.sizeC))
            setText(txt4,requireContext().resources.getString(R.string.sizeD))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()&& input4.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout86(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofRectangle6(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofRectangle6(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_13)
            setVisibilityGone(txt5,input5,spinner5)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
            setText(txt3,requireContext().resources.getString(R.string.sizeC))
            setText(txt4,requireContext().resources.getString(R.string.sizeD))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()&& input4.text.isNotEmpty()) {
            calculate()
        }
    }
    private fun layout87(){
        fun calculate(){
            result1.text ="${Round.round(CalculationsSquares.calculateSofChannel(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4),getFieldInM(input5,spinner5)))} м2"
            result2.text ="${Round.round(CalculationsSquares.calculatePofChannel(getFieldInM(input1,spinner1),getFieldInM(input2,spinner2),getFieldInM(input3,spinner3),getFieldInM(input4,spinner4),getFieldInM(input5,spinner5)))} м"
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_squares_detail_14)
            setText(txt1,requireContext().resources.getString(R.string.sizeA))
            setText(txt2,requireContext().resources.getString(R.string.sizeB))
            setText(txt3,requireContext().resources.getString(R.string.sizeC))
            setText(txt4,requireContext().resources.getString(R.string.sizeD))
            setText(txt5,requireContext().resources.getString(R.string.sizeE))
        }
        setView()
        if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()&& input4.text.isNotEmpty()&& input5.text.isNotEmpty()) {
            calculate()
        }
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

    private fun setSpinnersAdapters(){

        val adapter = SpinnerAdapter(requireContext(), requireContext().resources.getStringArray(R.array.array_values))
        spinner1.adapter=adapter
        spinner2.adapter=adapter
        spinner3.adapter=adapter
        spinner4.adapter=adapter
        spinner5.adapter=adapter


    }
    private fun getInfoAboutCalculations(): String{
        return """      
            ${getLine(txt1, input1, spinner1)}
            ${getLine(txt2, input2, spinner2)}
            ${getLine(txt3, input3, spinner3)}
            ${getLine(txt4, input4, spinner4)}
            ${getLine(txt5, input5, spinner5)}         
            ${getLine("Площадь", result1)}
            ${getLine("Периметр", result2)}         
        """.trimIndent()
    }
    private fun getInfoResultAboutCalculations(): String{
        return """"
           ${getLine("Площадь", result1)}
            ${getLine("Периметр", result2)} 
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

    }
}