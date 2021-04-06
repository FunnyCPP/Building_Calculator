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



class CalculationsFragment22 : Fragment() {

    val ARRAY= arrayOf("Aksolit S8"," Aksolit S3"," Aksolit R90"," Bergauf FUGEN GIPS"," Bergauf SILK PLAST",
            " Bergauf SILK ZEMENT"," Bergauf EASY SILK"," Bergauf EASY FINISH"," Bergauf LR PASTA"," Bergauf FINISH PLAST",
            " Bergauf FINISH POLYMER+"," Bergauf FINISH ZEMENT"," Bergauf FINISH GIPS"," Bergauf GLATTE ZEMENT"," Bergauf UNI FINISH",
            " Bergauf EASY SOFT"," Bergauf SILK POLYMER+"," Bergauf SILK GIPS"," Ceresit CT 127"," Ceresit CT 95"," Ceresit CT 225",
            " Ceresit IN 95"," Gipsell Финишная Премиум"," Gipsell Базовая Комфорт"," Glims Optimum"," Glims WhitePolymer"," Glims FinishГипс",
            " Glims Finish-LightRoom+"," Glims MasterFlott"," Glims Plast-R"," Glims Finish-R"," Glims SuperFinish PASTA"," Glims Stukko-RF",
            " Glims Finish-F"," UNIS Финишная шпатлевка"," UNIS Мастерслой"," UNIS Супер Финиш"," UNIS Белый жемчуг (LR Plus)"," UNIS Блик",
            " UNIS Фасад Белый"," UNIS Фасад Серый"," Weber.vetonit JS"," Weber.vetonit JS Plus"," Weber.vetonit Facade White"," Weber.vetonit KR",
            " Weber.vetonit LR+"," Weber.vetonit LR+ Silk"," Weber.vetonit LR Fine"," Weber.vetonit VH"," Weber.vetonit VH grey"," Weber.vetonit LR pasta",
            " Weber.vetonit deluxe pasta"," Боларс Гипсовая"," Боларс Saten"," Боларс Гипс-Эластик"," Боларс Финишная LR"," Боларс Фонишная SUPER",
            " Боларс Цементная Водостойкая"," Боларс Цементная Выравнивающая"," Боларс Цементная Универсаль"," Боларс Цементная Фасадная",
            " Боларс Фасадная Финишная"," Основит БАЗСИЛК PC30 MG"," Основит БАЗСИЛК PC30 MW"," Основит ГРЕЙСИЛК PC31 G"," Основит БЕЛСИЛК PC32 W",
            " Основит ШОВСИЛК PG33 H"," Основит ЭКОНСИЛК PG34 G"," Основит ЭКОНСИЛК PG35 W"," Основит ЭЛИСИЛК PG36 W"," Основит ЭЛИСИЛК PP37 W",
            " Основит ЭКОНСИЛК PP38 W"," Основит ЭЛИСИЛК PA39 W")

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
        return inflater.inflate(R.layout.fragment_calculations22, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        spinner1 =requireView().findViewById(R.id.spinner1_calculations22)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations22)
        //spinner3 =requireView().findViewById(R.id.spinner3_calculations22)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations22)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations22)
        spinner6 =requireView().findViewById(R.id.spinner6_calculations22)
        spinner8 =requireView().findViewById(R.id.spinner8_calculations22)

        input1 =requireView().findViewById(R.id.calculations22_input1)
        input2 =requireView().findViewById(R.id.calculations22_input2)
        input3 =requireView().findViewById(R.id.calculations22_input3)
        input4 =requireView().findViewById(R.id.calculations22_input4)
        input5 =requireView().findViewById(R.id.calculations22_input5)
        input6 =requireView().findViewById(R.id.calculations22_input6)
        input7 =requireView().findViewById(R.id.calculations22_input7)

        result1 =requireView().findViewById(R.id.calculations22_result1)
        result2 =requireView().findViewById(R.id.calculations22_result2)
        result3 =requireView().findViewById(R.id.calculations22_result3)
        result4 =requireView().findViewById(R.id.calculations22_result4)
        result5 =requireView().findViewById(R.id.calculations22_result5)
        result6 =requireView().findViewById(R.id.calculations22_result6)

        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations22)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations22)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations22)

        checkBox1=requireView().findViewById(R.id.calculations22_checkBox1)
        checkBox2=requireView().findViewById(R.id.calculations22_checkBox2)
        checkBox3=requireView().findViewById(R.id.calculations22_checkBox3)
        checkBox4=requireView().findViewById(R.id.calculations22_checkBox4)

        txt=requireView().findViewById(R.id.txt_calculations22)
        txt1=requireView().findViewById(R.id.txt1_calculations22)
        txt2=requireView().findViewById(R.id.txt2_calculations22)
        txt3=requireView().findViewById(R.id.txt3_calculations22)
        txt4=requireView().findViewById(R.id.txt4_calculations22)
        txt5=requireView().findViewById(R.id.txt5_calculations22)


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
            0->1.0
            1->0.9
            2->1.0
            3->1.0
            4->1.3
            5->1.0
            6->1.0
            7->1.0
            8->1.0
            9->1.3
            10->1.0
            11->1.0
            12->1.0
            13->1.0
            14->1.0
            15->1.0
            16->1.0
            17->1.0
            18->1.25
            19->1.7
            20->1.2
            21->1.7
            22->1.1
            23->1.1
            24->1.2
            25->1.2
            26->1.2
            27->1.2
            28->1.2
            29->1.5
            30->1.2
            31->1.15
            32->1.5
            33->1.5
            34->1.3
            35->1.0
            36->1.0
            37->0.95
            38->0.9
            39->0.95
            40->1.05
            41->1.2
            42->1.2
            43->1.2
            44->1.2
            45->1.2
            46->1.2
            47->1.2
            48->1.2
            49->1.2
            50->1.2
            51->1.67
            52->1.67
            53->1.0
            54->1.0
            55->1.0
            56->1.15
            57->1.0
            58->1.3
            59->1.4
            60->1.4
            61->1.05
            62->1.0
            63->1.0
            64->1.3
            65->1.2
            66->0.5
            67->0.9
            68->0.85
            69->1.0
            70->1.0
            71->1.1
            72->1.6
            else->0.0
        }
    }
    private fun calculate1to6results(){
        var res1=s
        var res2=ro*n
        var res3=res1*res2

        res1= floor(res1*10000.0) /10000.0
        res2= floor(res2*10000.0) /10000.0
        res3= floor(res3*10000.0) /10000.0

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
            val input=requireContext().resources.getString(R.string.calculation22_text1)+" "+ARRAY[spinner1.selectedItemPosition]
            val input2=requireContext().resources.getString(R.string.calculation22_text2)+" "+input2.text.toString()+" шт"
            text1= """
            $input           
            $input2
            
        """.trimIndent()
        }
        else{
            val input1Value=requireContext().resources.getString(R.string.calculation22_text3)+" "+input1.text.toString()+" кг/м2*мм"
            val input2Value=requireContext().resources.getString(R.string.calculation22_text2)+" "+input2.text.toString()+" "
            text1= """
            $input1Value
            $input2Value
         
        """.trimIndent()
        }
        var text2=""
        if(checkBox3.isChecked)
        {
            val input1Value=requireContext().resources.getString(R.string.calculation22_text4)+" "+input3.text.toString()+" "+spinner4.selectedItem.toString()
            val input2Value=requireContext().resources.getString(R.string.calculation22_text5)+" "+input4.text.toString()+" "+spinner5.selectedItem.toString()
            val input3Value=requireContext().resources.getString(R.string.calculation22_text7)+" "+input6.text.toString()+" кг"
            val input4Value=requireContext().resources.getString(R.string.calculation22_text8)+" "+input7.text.toString()+" руб"
            text2="""
                 $input1Value
                 $input2Value
                 $input3Value
                 $input4Value
                 
            """.trimIndent()
        }
        else
        {
            val input1Value=requireContext().resources.getString(R.string.calculation22_text6)+" "+input5.text.toString()+" м2"
            val input3Value=requireContext().resources.getString(R.string.calculation22_text6)+" "+input6.text.toString()+" кг"
            val input4Value=requireContext().resources.getString(R.string.calculation22_text7)+" "+input7.text.toString()+" руб"

            text2="""
                 $input1Value             
                 $input3Value
                 $input4Value
                 
            """.trimIndent()
        }
        val res="""
            ${requireContext().resources.getString(R.string.calculation22_text8)+" "+result1.text.toString()}
            ${requireContext().resources.getString(R.string.calculation22_text9)+" "+result2.text.toString()}
            ${requireContext().resources.getString(R.string.calculation22_text10)+" "+result3.text.toString()}
            ${requireContext().resources.getString(R.string.calculation22_text11)+" "+result4.text.toString()}
            ${requireContext().resources.getString(R.string.calculation22_text12)+" "+result5.text.toString()}
            ${requireContext().resources.getString(R.string.calculation22_text13)+" "+result6.text.toString()}
            
        """.trimIndent()
        return text1+text2+res
    }
    private fun getInfoResultAboutCalculations(): String{

        return """
            ${requireContext().resources.getString(R.string.calculation22_text8)+" "+result1.text.toString()}
            ${requireContext().resources.getString(R.string.calculation22_text9)+" "+result2.text.toString()}
            ${requireContext().resources.getString(R.string.calculation22_text10)+" "+result3.text.toString()}
            ${requireContext().resources.getString(R.string.calculation22_text11)+" "+result4.text.toString()}
            ${requireContext().resources.getString(R.string.calculation22_text12)+" "+result5.text.toString()}
            ${requireContext().resources.getString(R.string.calculation22_text13)+" "+result6.text.toString()}
            
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
                val id = 22
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