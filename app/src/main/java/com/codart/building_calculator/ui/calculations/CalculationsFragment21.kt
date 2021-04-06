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


class CalculationsFragment21 : Fragment() {

    val ARRAY= arrayOf("Axton гипсовая"," Axton цементная"," Aksolit A1"," Aksolit M50"," Aksolit M35"," Bergauf BAU PUTZ GIPS",
            " Bergauf BAU PUTZ ZEMENT"," Bergauf PRIMA PUTZ GIPS"," Bergauf INTERIER"," Bergauf PRIMA INTERIER"," Bergauf EASY PLASTER",
            " Bergauf BAU BLOCK"," Bergauf EASY BAND"," Forman 01"," Forman 10"," Forman 11"," Forman 12"," Forman 14"," Forman 15"," Forman 61",
            " Gipsell Эконом МН"," Gipsell Фора МН"," Gipsell Ультра МН"," Gipsell Атика РН"," Gipsell Оптима РН"," Glims TS-70"," Glims SatiN",
            " Glims Tweed"," Glims VeluR"," Glims CS-50"," Knauf Rotband"," Knauf Grunband"," Knauf Eisberg"," Knauf Goldband"," Knauf MN Start",
            " Knauf MP 75"," Knauf MP 75 Ultra"," Knauf Profi"," Knauf HP Start"," Knauf Adgesiv"," Knauf Sockelputz"," Knauf Sevener"," Knauf Unterputz",
            " Unis Теплон Универсальный"," Unis Силин Универсальный"," Unis Теплон Армированный"," Unis Теплон Влагостойкий"," Unis Экослой"," Unis МН-180",
            " Unis Силин Фасадный"," Unis Силин Цокольный"," Weber.vetonit Easy Gyps"," Weber.vetonit Profi Gyps"," Weber.vetonit Mech Gyps"," Weber.vetonit TT",
            " Weber.vetonit TT40"," Weber.vetonit Facade Grey"," Weisbau WB101"," Weisbau WB104"," Weisbau WB105"," Боларс гипсовая Base"," Боларс гипсовая белая",
            " Боларс гипсовая серая"," Боларс для машинного нанесения"," Боларс Унипласт"," Боларс Фасадная"," Боларс Фасадная для машинного нанесения",
            " Боларс Фасадная морозостойкая"," Боларс EASYWALL теплоизоляционная"," Волма Слой"," Волма Слой Титан"," Волма Слой Ультра"," Волма Холст",
            " Волма Гросс"," Волма Пласт"," Волма Люкс"," Волма Старт"," Волма Титул"," Волма Акваслой"," Волма Цоколь"," Волма Аквапласт"," Волма Гипс-Актив",
            " Волма Гипс-Актив Экстра"," Волма Акваслой МН"," Волма Аквастарт"," Волма Цемент Актив"," Волам Обрызг"," Старатели MIXTER"," Старатели ТеплоЗвук",
            " Старатели Гипсовая белая"," Старатели Гипсовая"," Старатели Эколайт Гипсовая легкая"," Старатели Гипсовая машинного нанесения"," Старатели Гипсовая Профи",
            " Старатели Оптимум"," Старатели Цементно-Песчаная Легкая Эколайт"," Старатели Фасадная"," Старатели Цементная"," Старатели Обрызг"," Основит Профэлл PC20 М",
            " Основит Стартвэлл РС21 М"," Основит Стартвэлл РС21 Фасадная"," Основит Стартвэлл PC22 H Фасадная"," Основит РС23 фасадная"," Основит PC24/1 ML",
            " Основит ГИПСВЭЛЛ PG25"," Основит ГИПСВЭЛЛ PG25 W"," Основит PG26 M"," Основит PG26 MW")


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
        return inflater.inflate(R.layout.fragment_calculations21, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations21)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations21)
        //spinner3 =requireView().findViewById(R.id.spinner3_calculations21)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations21)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations21)
        spinner6 =requireView().findViewById(R.id.spinner6_calculations21)
        spinner8 =requireView().findViewById(R.id.spinner8_calculations21)


        input1 =requireView().findViewById(R.id.calculations21_input1)
        input2 =requireView().findViewById(R.id.calculations21_input2)
        input3 =requireView().findViewById(R.id.calculations21_input3)
        input4 =requireView().findViewById(R.id.calculations21_input4)
        input5 =requireView().findViewById(R.id.calculations21_input5)
        input6 =requireView().findViewById(R.id.calculations21_input6)
        input7 =requireView().findViewById(R.id.calculations21_input7)

        result1 =requireView().findViewById(R.id.calculations21_result1)
        result2 =requireView().findViewById(R.id.calculations21_result2)
        result3 =requireView().findViewById(R.id.calculations21_result3)
        result4 =requireView().findViewById(R.id.calculations21_result4)
        result5 =requireView().findViewById(R.id.calculations21_result5)
        result6 =requireView().findViewById(R.id.calculations21_result6)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations21)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations21)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations21)

        checkBox1=requireView().findViewById(R.id.calculations21_checkBox1)
        checkBox2=requireView().findViewById(R.id.calculations21_checkBox2)
        checkBox3=requireView().findViewById(R.id.calculations21_checkBox3)
        checkBox4=requireView().findViewById(R.id.calculations21_checkBox4)

        txt=requireView().findViewById(R.id.txt_calculations21)
        txt1=requireView().findViewById(R.id.txt1_calculations21)
        txt2=requireView().findViewById(R.id.txt2_calculations21)
        txt3=requireView().findViewById(R.id.txt3_calculations21)
        txt4=requireView().findViewById(R.id.txt4_calculations21)
        txt5=requireView().findViewById(R.id.txt5_calculations21)


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
            0->1.05
            1->1.4
            2->0.83
            3->0.85
            4->1.0
            5->1.2
            6->1.7
            7->1.05
            8->1.25
            9->1.25
            10->1.25
            11->1.6
            12->0.85
            13->0.75
            14->0.85
            15->1.15
            16->0.95
            17->1.05
            18->0.85
            19->1.4
            20->0.95
            21->1.05
            22->0.85
            23->0.95
            24->0.85
            25->0.95
            26->0.8
            27->1.2
            28->0.85
            29->1.45
            30->0.85
            31->1.2
            32->0.85
            33->0.85
            34->1.0
            35->0.85
            36->0.9
            37->0.85
            38->1.0
            39->1.6
            40->1.7
            41->0.5
            42->1.7
            43->1.25
            44->1.5
            45->1.0
            46->1.25
            47->1.05
            48->0.85
            49->1.5
            50->2.0
            51->0.95
            52->0.93
            53->0.95
            54->1.2
            55->1.7
            56->1.7
            57->0.95
            58->1.5
            59->0.95
            60->1.05
            61->1.0
            62->1.0
            63->1.2
            64->1.35
            65->1.35
            66->1.4
            67->0.24
            68->0.85
            69->0.85
            70->0.7
            71->0.95
            72->0.95
            73->1.0
            74->0.65
            75->1.2
            76->0.85
            77->1.15
            78->1.45
            79->1.7
            80->0.85
            81->0.8
            82->1.15
            83->1.5
            84->1.7
            85->1.05
            86->0.65
            87->0.85
            88->0.85
            89->0.55
            90->0.85
            91->1.15
            92->1.05
            93->0.65
            94->1.35
            95->1.45
            96->1.1
            97->1.6
            98->1.3
            99->1.65
            100->1.8
            101->1.7
            102->1.05
            103->0.9
            104->0.9
            105->0.9
            106->0.9
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
        var res1=s
        var res2=ro*n
        var res3=res1*res2
        var m=input6.text.toString().toDouble()
        var p=input7.text.toString().toDouble()
        var res4= ceil(res3/m)
        var res5=res4*p
        var res6=res3/m*p/res1

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
            val input=requireContext().resources.getString(R.string.calculation21_text1)+" "+ARRAY[spinner1.selectedItemPosition]
            val input2=requireContext().resources.getString(R.string.calculation21_text2)+" "+input2.text.toString()+" шт"
            text1= """
            $input           
            $input2
            
        """.trimIndent()
        }
        else{
            val input1Value=requireContext().resources.getString(R.string.calculation21_text3)+" "+input1.text.toString()+" кг/м2*мм"
            val input2Value=requireContext().resources.getString(R.string.calculation21_text2)+" "+input2.text.toString()+" "
            text1= """
            $input1Value
            $input2Value
         
        """.trimIndent()
        }
        var text2=""
        if(checkBox3.isChecked)
        {
            val input1Value=requireContext().resources.getString(R.string.calculation21_text4)+" "+input3.text.toString()+" "+spinner4.selectedItem.toString()
            val input2Value=requireContext().resources.getString(R.string.calculation21_text5)+" "+input4.text.toString()+" "+spinner5.selectedItem.toString()
            val input3Value=requireContext().resources.getString(R.string.calculation21_text7)+" "+input6.text.toString()+" кг"
            val input4Value=requireContext().resources.getString(R.string.calculation21_text8)+" "+input7.text.toString()+" руб"
            text2="""
                 $input1Value
                 $input2Value
                 $input3Value
                 $input4Value
                 
            """.trimIndent()
        }
        else
        {
            val input1Value=requireContext().resources.getString(R.string.calculation21_text6)+" "+input5.text.toString()+" м2"
            val input3Value=requireContext().resources.getString(R.string.calculation21_text6)+" "+input6.text.toString()+" кг"
            val input4Value=requireContext().resources.getString(R.string.calculation21_text7)+" "+input7.text.toString()+" руб"

            text2="""
                 $input1Value             
                 $input3Value
                 $input4Value
                 
            """.trimIndent()
        }
        val res="""
            ${requireContext().resources.getString(R.string.calculation21_text8)+" "+result1.text.toString()}
            ${requireContext().resources.getString(R.string.calculation21_text9)+" "+result2.text.toString()}
            ${requireContext().resources.getString(R.string.calculation21_text10)+" "+result3.text.toString()}
            ${requireContext().resources.getString(R.string.calculation21_text11)+" "+result4.text.toString()}
            ${requireContext().resources.getString(R.string.calculation21_text12)+" "+result5.text.toString()}
            ${requireContext().resources.getString(R.string.calculation21_text13)+" "+result6.text.toString()}
            
        """.trimIndent()
        return text1+text2+res
    }
    private fun getInfoResultAboutCalculations(): String{

        return  """
            ${requireContext().resources.getString(R.string.calculation21_text8)+" "+result1.text.toString()}
            ${requireContext().resources.getString(R.string.calculation21_text9)+" "+result2.text.toString()}
            ${requireContext().resources.getString(R.string.calculation21_text10)+" "+result3.text.toString()}
            ${requireContext().resources.getString(R.string.calculation21_text11)+" "+result4.text.toString()}
            ${requireContext().resources.getString(R.string.calculation21_text12)+" "+result5.text.toString()}
            ${requireContext().resources.getString(R.string.calculation21_text13)+" "+result6.text.toString()}           
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
                val id = 21
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