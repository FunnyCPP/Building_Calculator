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
import kotlin.math.floor

class CalculationsFragment24 : Fragment() {

    val ARRAY= arrayOf("Aksolit N100"," Ceresit CN 173"," Ceresit CN 175"," Ceresit CN 178"," Ceresit CN 68"," Ceresit CN 76"," Ceresit DD",
            " Ceresit CN 83"," Ceresit CN 88"," Bergauf Easy Final"," Bergauf Easy Boden"," Bergauf Easy Boden Smart"," Bergauf Base",
            " Bergauf Boden Zement Gross"," Bergauf Boden Zement Medium"," Bergauf Boden Zement Final"," Bergauf Boden Inter Gross",
            " Bergauf Boden Turbo"," Bergauf Boden Novelit"," Bergauf Boden Street"," Gipsell Монолит Базовый"," Gipsell Монолит Финиш",
            " Glims CF-10"," Glimc CF-40"," Glims S-Base+"," Glims S-Line"," Glims S-Level"," Glims PRO FS Heavy Duty"," Knauf Tribon",
            " Litokol Litocem Pronto"," Litokol Litoliv S100"," Litokol Litoliv Basis"," Litokol Litoliv S10 Express"," Litokol Litoliv S30",
            " Litokol Litoliv S5"," UNIS Горизонт"," UNIS Горизонт Армированный"," UNIS Горизонт Ультра"," UNIS Горизонт Универсальный",
            " UNIS Горизонт Монолит"," UNIS Горизонт Финишный"," UNIS Floor Force"," Weber.vetonit 3000"," Weber.vetonit 3100"," Weber.vetonit 4100",
            " Weber.vetonit 4350"," Weber.veronit 4400"," Weber.vetonit 5000"," Weber.vetonit 5700"," Weber.vetonit 6000"," Weber.vetonit Fast Level",
            " Weber.vetonit Strong"," Weber.vetonit Finish Level"," Weber.vetonit Fast 4000"," Weber.vetonit 4650 Design color"," Weber.vetonit 4655",
            " Weber.vetonit 4610 Industry Top"," Weber.vetonit 4630 Industry Lit"," Weber.vetonit 4601"," Боларс Гипсовый CB-210"," Боларс Гипсовый CB-210 Оптим",
            " Боларс Express 1050"," Боларс CB-1030"," Боларс CB-1010"," Волма Нивелир Экспресс"," Волма Нивелир Арена"," Волма Нивелр Топ"," Волма Нивелир Комфорт",
            " Волма Ровнитель грубый"," Старатели Быстротвердеющий"," Старатели Высокопрочный Самонивелирующийся"," Старатели Практичный"," Старатели Толстый",
            " Старатели Тонкий"," Основит Ниплайн FC42 H",
            " Основит Скорлайн FK45 R"," Основит Ровилайн FK46"," Основит Ниплайн FK47"," Основит Ниплайн FC47"," Основит Скорлайн FK48 R")

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: TextView
    //private lateinit var spinner3: TextView
    private lateinit var spinner4: Spinner
    private lateinit var spinner5: Spinner
    private lateinit var spinner6: TextView
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
    private lateinit var result6: TextView

    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var checkBox3: CheckBox
    private lateinit var checkBox4: CheckBox

    private lateinit var imgBottomSave: ImageView
    private lateinit var imgBottomHome: ImageView
    private lateinit var imgBottomCopy: ImageView

    private lateinit var txt: TextView
    private lateinit var txt1: TextView
    private lateinit var txt2: TextView
    private lateinit var txt3: TextView
    private lateinit var txt4: TextView
    private lateinit var txt5: TextView

    var ro = 0.0
    var n = 0
    var s = 0.0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations24, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations24)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations24)
        //spinner3 =requireView().findViewById(R.id.spinner3_calculations24)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations24)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations24)
        spinner6 =requireView().findViewById(R.id.spinner6_calculations24)
        spinner8 =requireView().findViewById(R.id.spinner8_calculations24)

        input1 =requireView().findViewById(R.id.calculations24_input1)
        input2 =requireView().findViewById(R.id.calculations24_input2)
        input3 =requireView().findViewById(R.id.calculations24_input3)
        input4 =requireView().findViewById(R.id.calculations24_input4)
        input5 =requireView().findViewById(R.id.calculations24_input5)
        input6 =requireView().findViewById(R.id.calculations24_input6)
        input7 =requireView().findViewById(R.id.calculations24_input7)

        result1 =requireView().findViewById(R.id.calculations24_result1)
        result2 =requireView().findViewById(R.id.calculations24_result2)
        result3 =requireView().findViewById(R.id.calculations24_result3)
        result4 =requireView().findViewById(R.id.calculations24_result4)
        result5 =requireView().findViewById(R.id.calculations24_result5)
        result6 =requireView().findViewById(R.id.calculations24_result6)

        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations24)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations24)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations24)

        checkBox1=requireView().findViewById(R.id.calculations24_checkBox1)
        checkBox2=requireView().findViewById(R.id.calculations24_checkBox2)
        checkBox3=requireView().findViewById(R.id.calculations24_checkBox3)
        checkBox4=requireView().findViewById(R.id.calculations24_checkBox4)

        txt=requireView().findViewById(R.id.txt_calculations24)
        txt1=requireView().findViewById(R.id.txt1_calculations24)
        txt2=requireView().findViewById(R.id.txt2_calculations24)
        txt3=requireView().findViewById(R.id.txt3_calculations24)
        txt4=requireView().findViewById(R.id.txt4_calculations24)
        txt5=requireView().findViewById(R.id.txt5_calculations24)


        setCheckBoxes()
        checkFields()
        setSpinnersAdapters()
        setBottomButtons()
        super.onViewCreated(view, savedInstanceState)
    }
    fun checkMetricFields(){
        if(checkBox1.isChecked)
        {
            if(checkBox3.isChecked)
            {
                if(input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() ) {
                    ro=getMiddleRo()
                    txt.text="Средний расход - $ro кг/м2*мм"
                    n=input2.text.toString().toInt()
                    s=getFieldInM(input3, spinner4)*getFieldInM(input4, spinner5)
                    calculate1to6results()
                    if(input6.text.isNotEmpty() && input7.text.isNotEmpty())
                        calculatePriceResults()
                }
            }
            if(checkBox4.isChecked)
            {
                if(input2.text.isNotEmpty() && input5.text.isNotEmpty()  ) {
                    ro=getMiddleRo()
                    txt.text="Средний расход - $ro кг/м2*мм"
                    n=input2.text.toString().toInt()
                    s=input5.text.toString().toDouble()
                    calculate1to6results()
                    if(input6.text.isNotEmpty() && input7.text.isNotEmpty())
                        calculatePriceResults()
                }
            }
        }
        if(checkBox2.isChecked) {
            if (checkBox3.isChecked) {
                if (input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty()) {
                    ro = input1.text.toString().toDouble()
                    n = input2.text.toString().toInt()
                    s = getFieldInM(input3, spinner4) * getFieldInM(input4, spinner5)
                    calculate1to6results()
                    if(input6.text.isNotEmpty() && input7.text.isNotEmpty())
                        calculatePriceResults()
                }
            }
            if (checkBox4.isChecked) {
                if (input1.text.isNotEmpty() && input2.text.isNotEmpty() && input5.text.isNotEmpty()) {
                    ro = input1.text.toString().toDouble()
                    n = input2.text.toString().toInt()
                    s = input5.text.toString().toDouble()
                    calculate1to6results()
                    if(input6.text.isNotEmpty() && input7.text.isNotEmpty())
                        calculatePriceResults()
                }
            }
        }
    }
    fun getMiddleRo(): Double{
        return when(spinner1.selectedItemPosition)
        {
            0->1.3
            1->1.6
            2->1.6
            3->2.0
            4->1.6
            5->2.0
            6->1.5
            7->2.0
            8->1.9
            9->1.7
            10->1.5
            11->1.5
            12->1.9
            13->1.9
            14->1.9
            15->1.7
            16->1.5
            17->1.5
            18->1.7
            19->1.9
            20->1.9
            21->1.5
            22->1.5
            23->1.8
            24->1.3
            25->1.3
            26->1.3
            27->2.0
            28->1.7
            29->1.9
            30->1.6

            31->1.75
            32->1.25
            33->1.6
            34->1.4
            35->1.85
            36->1.8
            37->1.35
            38->1.3
            39->1.35
            40->1.25
            41->1.8
            42->1.5
            43->1.6
            44->1.6
            45->1.7
            46->1.6
            47->1.8
            48->1.6
            49->1.8
            50->2.6
            51->1.7
            52->1.5
            53->1.6
            54->1.7
            55->1.7
            56->1.7
            57->1.9
            58->1.8
            59->1.5
            60->1.5
            61->1.6
            62->1.6
            63->1.6
            64->1.25
            65->1.55
            66->1.6
            67->1.2
            68->1.9
            69->1.4
            70->1.7
            71->1.45
            72->1.7
            73->1.45
            74->1.7
            75->1.65
            76->1.6
            77->1.7
            78->1.8
            79->1.45
            else->0.0
        }
    }
    private fun calculate1to6results(){
        val res1=s
        val res2=ro*n
        val res3=res1*res2

        result1.text = "${Round.round(res1)} м2"
        result2.text = "${Round.round(res2)} кг"
        result3.text = "${Round.round(res3)} кг"

    }
    private fun calculatePriceResults(){
        val res1=s
        val res2=ro*n
        val res3=res1*res2
        val m=input6.text.toString().toDouble()
        val p=input7.text.toString().toDouble()
        val res4= ceil(res3/m)
        val res5=res4*p
        val res6=res3/m*p/res1

        result4.text = "${Round.round(res4)} шт"
        result5.text = "${Round.round(res5)} ${spinner8.selectedItem}"
        result6.text = "${Round.round(res6)} ${spinner8.selectedItem}"
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

        var adapter = SpinnerAdapter(requireContext(), ARRAY)
        spinner1.adapter=adapter
        var array=resources.getStringArray(R.array.array_values)
        val adapter2 = ValuesSpinnerAdapter(requireContext(), array)
        spinner4.adapter=adapter2
        spinner5.adapter=adapter2
        array=resources.getStringArray(R.array.array_currencies)
        adapter = SpinnerAdapter(requireContext(), array)
        spinner8.adapter=adapter
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
            val input=requireContext().resources.getString(R.string.calculation24_text1)+" "+ARRAY[spinner1.selectedItemPosition]
            val input2=requireContext().resources.getString(R.string.calculation24_text2)+" "+input2.text.toString()+" шт"
            text1= """
            $input           
            $input2
            
        """.trimIndent()
        }
        else{
            val input1Value=requireContext().resources.getString(R.string.calculation24_text3)+" "+input1.text.toString()+" кг/м2*мм"
            val input2Value=requireContext().resources.getString(R.string.calculation24_text2)+" "+input2.text.toString()+" "
            text1= """
            $input1Value
            $input2Value
         
        """.trimIndent()
        }
        var text2=""
        if(checkBox3.isChecked)
        {
            val input1Value=requireContext().resources.getString(R.string.calculation24_text4)+" "+input3.text.toString()+" "+spinner4.selectedItem.toString()
            val input2Value=requireContext().resources.getString(R.string.calculation24_text5)+" "+input4.text.toString()+" "+spinner5.selectedItem.toString()
            val input3Value=requireContext().resources.getString(R.string.calculation24_text7)+" "+input6.text.toString()+" кг"
            val input4Value=requireContext().resources.getString(R.string.calculation24_text8)+" "+input7.text.toString()+" руб"
            text2="""
                 $input1Value
                 $input2Value
                 $input3Value
                 $input4Value
                 
            """.trimIndent()
        }
        else
        {
            val input1Value=requireContext().resources.getString(R.string.calculation24_text6)+" "+input5.text.toString()+" м2"
            val input3Value=requireContext().resources.getString(R.string.calculation24_text6)+" "+input6.text.toString()+" кг"
            val input4Value=requireContext().resources.getString(R.string.calculation24_text7)+" "+input7.text.toString()+" руб"

            text2="""
                 $input1Value             
                 $input3Value
                 $input4Value
                 
            """.trimIndent()
        }
        val res="""
            ${requireContext().resources.getString(R.string.calculation24_text8)+" "+result1.text.toString()}
            ${requireContext().resources.getString(R.string.calculation24_text9)+" "+result2.text.toString()}
            ${requireContext().resources.getString(R.string.calculation24_text10)+" "+result3.text.toString()}
            ${requireContext().resources.getString(R.string.calculation24_text11)+" "+result4.text.toString()}
            ${requireContext().resources.getString(R.string.calculation24_text12)+" "+result5.text.toString()}
            ${requireContext().resources.getString(R.string.calculation24_text13)+" "+result6.text.toString()}
            
        """.trimIndent()
        return text1+text2+res
    }
    private fun getInfoResultAboutCalculations(): String{
        return """
            ${requireContext().resources.getString(R.string.calculation24_text8)+" "+result1.text.toString()}
            ${requireContext().resources.getString(R.string.calculation24_text9)+" "+result2.text.toString()}
            ${requireContext().resources.getString(R.string.calculation24_text10)+" "+result3.text.toString()}
            ${requireContext().resources.getString(R.string.calculation24_text11)+" "+result4.text.toString()}
            ${requireContext().resources.getString(R.string.calculation24_text12)+" "+result5.text.toString()}
            ${requireContext().resources.getString(R.string.calculation24_text13)+" "+result6.text.toString()}
            
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
                val id = 24
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
        input7.doAfterTextChanged {
            checkMetricFields()
        }
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                checkMetricFields()
                ro=getMiddleRo()
                txt.text="Средний расход - $ro кг/м2*мм"
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
        spinner8.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
            spinner2.visibility= View.GONE
            txt2.visibility = View.GONE
            txt1.visibility = View.VISIBLE
            spinner1.visibility = View.VISIBLE
            txt.visibility = View.VISIBLE
        }

        }
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setOnClickListener {
                checkBox1.isChecked = false
                checkBox2.isChecked = true
                input1.visibility = View.VISIBLE
                spinner2.visibility= View.VISIBLE
                txt2.visibility = View.VISIBLE
                txt1.visibility = View.GONE
                spinner1.visibility = View.GONE
                txt.visibility = View.GONE
            }

        }
        checkBox3.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setOnClickListener {
                checkBox4.isChecked = false
                checkBox3.isChecked = true
                txt3.visibility = View.VISIBLE
                input3.visibility= View.VISIBLE
                spinner4.visibility = View.VISIBLE
                txt4.visibility = View.VISIBLE
                input4.visibility= View.VISIBLE
                spinner5.visibility = View.VISIBLE
                txt5.visibility = View.GONE
                input5.visibility= View.GONE
                spinner6.visibility = View.GONE
            }

        }
        checkBox4.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.setOnClickListener {
                checkBox4.isChecked = true
                checkBox3.isChecked = false
                txt3.visibility = View.GONE
                input3.visibility= View.GONE
                spinner4.visibility = View.GONE
                txt4.visibility = View.GONE
                input4.visibility= View.GONE
                spinner5.visibility = View.GONE
                txt5.visibility = View.VISIBLE
                input5.visibility= View.VISIBLE
                spinner6.visibility = View.VISIBLE
            }

        }
    }
}