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
import java.lang.Exception


class CalculationsFragment53_57_59_61_63_65_66_68_73 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner6: TextView
    private lateinit var spinner8: Spinner

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

    private lateinit var txt: TextView
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
    private var isViewSet: Boolean=false

    private var ro=0.0
    private var calculationID=52

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_calculations53_57_59_61_63_65_66_68_73,
            container,
            false
        )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        calculationID=requireActivity().intent.getIntExtra("id",53)
        spinner1 =requireView().findViewById(R.id.spinner1_calculations53)
        spinner6 =requireView().findViewById(R.id.spinner2_calculations53)
        spinner8 =requireView().findViewById(R.id.spinner4_calculations53)

        input5 =requireView().findViewById(R.id.calculations53_input1)
        input6 =requireView().findViewById(R.id.calculations53_input2)
        input7 =requireView().findViewById(R.id.calculations53_input6)


        result1 =requireView().findViewById(R.id.calculations53_result1)
        result2 =requireView().findViewById(R.id.calculations53_result2)
        result3 =requireView().findViewById(R.id.calculations53_result3)
        result4 =requireView().findViewById(R.id.calculations53_result4)
        result5 =requireView().findViewById(R.id.calculations53_result5)



        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations53)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations53)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations53)

        txt5=requireView().findViewById(R.id.calculations53_txt2)
        txt6=requireView().findViewById(R.id.calculations53_txt3)
        txt7=requireView().findViewById(R.id.calculations53_txt4)
        txt8=requireView().findViewById(R.id.calculations53_txt5)
        txt9=requireView().findViewById(R.id.calculations53_txt6)
        txt10=requireView().findViewById(R.id.calculations53_txt7)
        txt11=requireView().findViewById(R.id.calculations53_txt8)
        txt12=requireView().findViewById(R.id.calculations53_txt9)

        checkBox1=requireView().findViewById(R.id.calculations53_checkBox1)
        checkBox2=requireView().findViewById(R.id.calculations53_checkBox2)

        img=requireView().findViewById(R.id.img_calculations53)

        setSpinnersAdapters()
        setBottomButtons()
        setCheckboxes()
        setLayout()
        checkFields()

        super.onViewCreated(view, savedInstanceState)
    }
    private fun setLayout(){
        try {
            when (calculationID+1) {
                53 -> layout53()
                54 -> layout54()
                55 -> layout55()
                56 -> layout56()
                57 -> layout57()
                59 -> layout59()
                61 -> layout61()
                62 -> layout62()
                63 -> layout63()
                65 -> layout65()
                66 -> layout66()
                68 -> layout68()
                69 -> layout69()
                70 -> layout70()

            }
        }
        catch (e: Exception)
        {

        }

    }
    private fun layout53(){
        val array = arrayOf("10 * 0.8", "10 * 0.9", "10 * 1", "10 * 1.2", "10 * 1.4",
                "15 * 0.8", "15 * 0.9", "15 * 1", "15 * 1.2", "15 * 1.4", "15 * 1.5",
                "20 * 0.8", "20 * 0.9", "20 * 1", "20 * 1.2", "20 * 1.4", "20 * 1.5",
                "20 * 2", "25 * 0.8", "25 * 0.9", "25 * 1", "25 * 1.2", "25 * 1.4", "25 * 1.5",
                "25 * 2", "25 * 2.5", "25 * 3", "30 * 0.8", "30 * 0.9", "30 * 1", "30 * 1.2",
                "30 * 1.3", "30 * 1.4", "30 * 1.5", "30 * 2", "30 * 2.5", "30 * 3", "30 * 3.5",
                "30 * 4", "35 * 0.8", "35 * 0.9", "35 * 1.4", "35 * 1.5", "35 * 2", "35 * 2.5", "35 * 3",
                "35 * 3.5", "35 * 4", "35 * 5", "40 * 1.4", "40 * 1.5", "40 * 2", "40 * 2.5", "40 * 3", "40 * 3.5",
                "40 * 4", "40 * 5", "40 * 6", "42 * 3", "42 * 3.5", "42 * 4", "42 * 5", "42 * 6", "45 * 2", "45 * 3",
                "45 * 3.5", "45 * 4", "45 * 5", "45 * 6", "45 * 7", "45 * 8", "50 * 2", "50 * 2.5", "50 * 3", "50 * 3.5",
                "50 * 4", "50 * 4.5", "50 * 5", "50 * 6", "50 * 7", "50 * 8", "60 * 2", "60 * 2.5", "60 * 3", "60 * 3.5",
                "60 * 4", "60 * 5", "60 * 6", "60 * 7", "60 * 8", "70 * 3", "70 * 3.5", "70 * 4", "70 * 5", "70 * 6", "70 * 7",
                "70 * 8", "80 * 3", "80 * 3.5", "80 * 4", "80 * 5", "80 * 6", "80 * 7", "80 * 8", "80 * 9", "80 * 10", "80 * 11",
                "90 * 3", "90 * 4", "90 * 5", "90 * 6", "90 * 7", "90 * 8", "100 * 3", "100 * 4", "100 * 5", "100 * 6", "100 * 7",
                "100 * 8", "100 * 9", "110 * 6", "110 * 7", "110 * 8", "110 * 9", "120 * 6", "120 * 7", "120 * 8", "120 * 9", "140 * 6",
                "140 * 7", "140 * 8", "140 * 9", "150 * 7", "150 * 8", "150 * 9", "150 * 10", "180 * 8", "180 * 9", "180 * 10", "180 * 12", "180 * 14")
        val arrayRo= arrayOf<Double>(0.222,0.246,0.269,0.312,0.352,0.348,0.388,0.426,0.501,
                0.571,0.605,0.474,0.529,0.583,0.689,0.791,0.841,1.075,0.599,0.670,0.740,
                0.878,1.01,1.07,1.39,1.68,1.95,0.725,0.811,0.897,1.07,1.15,1.23,1.31,
                1.70,2.07,2.42,2.75,3.04,0.850,0.953,1.45,1.55,2.02,2.46,2.89,3.30,3.67,
                4.37,1.67,1.78,2.33,2.85,3.36,3.85,4.30,5.16,5.92,3.55,4.07,4.56,5.47,6.30,
                2.65,3.83,4.40,4.93,5.94,6.86,7.69,8.43,2.96,3.64,4.31,4.94,5.56,6.16,6.73,
                7.80,8.79,9.69,3.59,4.43,5.25,6.04,6.82,8.30,9.69,11.00,12.20,6.19,7.14,8.07,
                9.87,11.57,13.19,14.71,7.13,8.24,9.33,11.44,13.46,15.38,17.22,18.97,20.63,22.20,
                8.07,10.59,13.00,15.34,17.58,19.73,9.02,11.84,14.58,17.22,19.78,22.25,24.62,19.11,
                21.98,24.76,27.45,20.99,24.18,27.27,30.28,24.76,28.57,32.29,35.93,30.77,34.81,38.75,42.61,42.34,47.23,52.03,61.36,70.33)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_pipe_aa"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout54(){
        val array = arrayOf("15 * 10 * 1", "15 * 10 * 1,5")
        val arrayRo= arrayOf<Double>(0.348,0.488)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_pipe_ab"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout55(){
        val array = arrayOf("40 * 40 * 2", "40 * 40 * 2,5")
        val arrayRo= arrayOf<Double>(2.31,2.82)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_pipe_aa"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout56(){
        val array = arrayOf("20 * 2", "20 * 2,5")
        val arrayRo= arrayOf<Double>(1.05,1.25)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_pipe_aa"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout57(){
        val array = arrayOf("25 * 25 * 2,6", "25 * 25 * 3,2")
        val arrayRo= arrayOf<Double>(1.69,1.98)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_pipe_aa"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout59(){
        val array = arrayOf("6 * 1.8", "6 * 2.9")
        val arrayRo= arrayOf<Double>(0.37,0.4)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_circle_2"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout61(){
        val array = arrayOf("2 * 3", "2 * 4")
        val arrayRo= arrayOf<Double>(0.89,1.15)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_corner_2"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout62(){
        val array = arrayOf("2,5/1,6 x 3", "3/2 x 3")
        val arrayRo= arrayOf<Double>(0.91,1.12)
        fun setRO(){
            try {
                ro = arrayRo[spinner1.selectedItemPosition]
            }
            catch (e: Exception)
            {

            }
        }
        fun setView(){
            val imageTitle= "ic_metals_corner_3"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout63(){
        val array = arrayOf("20 * 3", "20 * 4")
        val arrayRo= arrayOf<Double>(0.9,1.1)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_corner_2"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout65(){
        val array = arrayOf("5", "6,5")
        val arrayRo= arrayOf<Double>(4.84,5.9)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_channel_2"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout66(){
        val array = arrayOf("МСР 75", "МСР 100")
        val arrayRo= arrayOf<Double>(7.14,9.56)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_channel_2"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout68(){
        val array = arrayOf("10", "12")
        val arrayRo= arrayOf<Double>(9.46,11.5)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_beam_2"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout69(){
        val array = arrayOf("14С", "20С")
        val arrayRo= arrayOf<Double>(16.9,27.9)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_beam_2"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun layout70(){
        val array = arrayOf("10Б1", "12Б2")
        val arrayRo= arrayOf<Double>(8.1,8.7)
        fun setRO(){
            ro=arrayRo[spinner1.selectedItemPosition]
        }
        fun setView(){
            val imageTitle= "ic_metals_beam_2"
            val imageId=requireContext().resources.getIdentifier(imageTitle, "drawable", requireContext().packageName)
            img.setImageResource(imageId)
            var adapter = SpinnerAdapter(requireContext(), array)
            spinner1.adapter=adapter
            setSpinner1()
            isViewSet=true
        }
        if(!isViewSet)
            setView()
        if( input5.text.isNotEmpty()  ) {
            setRO()
            calculateResult1()
            if(input6.text.isNotEmpty())
                calculateResults2_3()
            if(input7.text.isNotEmpty())
                calculatePrice()
        }
    }
    private fun calculateResult1(){

        result1.text = if(checkBox1.isChecked){
            "${Round.round(CalculationsMetals.calculateM(input5.text.toString().toDouble(), ro))} кг"
        }
        else
        {
            "${Round.round(CalculationsMetals.calculateL(input5.text.toString().toDouble(), ro))} м"
        }

    }
    private fun calculateResults2_3()
    {
        if(checkBox1.isChecked)
        {
            result2.text="${Round.round(CalculationsMetals.round(
                CalculationsMetals.calculateM(input5.text.toString().toDouble()*
                    input6.text.toString().toDouble(),ro)))} кг"
            result3.text="${Round.round(input5.text.toString().toDouble()*input6.text.toString().toDouble())} м"
        }
        else
        {
            val l= CalculationsMetals.calculateL(input5.text.toString().toDouble(),ro)
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
                        CalculationsMetals.calculateM(input5.text.toString().toDouble(), ro))
            }
            1->{
                CalculationsMetals.calculatePrice(input7.text.toString().toDouble(),
                        CalculationsMetals.calculateM(input5.text.toString().toDouble(), ro))
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
        adapter = SpinnerAdapter(requireContext(), CalculationsMetals.metalsArray)
        adapter = SpinnerAdapter(requireContext(), arrayOf("За тонну","За кг","За штуку"))
        spinner8.adapter=adapter
    }
    private fun getInfoAboutCalculations(): String{
        return """
            ${getLine(spinner1)}
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
        try {
            input5.doAfterTextChanged {
                setLayout()
            }
            input6.doAfterTextChanged {
                setLayout()
            }
            input7.doAfterTextChanged {
                setLayout()
            }
            spinner8.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parentView: AdapterView<*>?,
                    selectedItemView: View,
                    position: Int,
                    id: Long
                ) {
                    setLayout()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }
        catch (e: Exception)
        {

        }
    }
    private fun setSpinner1(){

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