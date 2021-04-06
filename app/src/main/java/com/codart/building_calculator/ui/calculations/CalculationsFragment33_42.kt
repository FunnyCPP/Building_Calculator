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
import com.codart.building_calculator.ui.SpinnerAdapter
import java.lang.Exception
import kotlin.math.*


class FragmentCalculations33_42 : Fragment() {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner
    private lateinit var spinner5: Spinner
    private lateinit var spinner6: Spinner
    private lateinit var spinner7: Spinner
    private lateinit var spinner8: TextView


    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var input3: EditText
    private lateinit var input4: EditText
    private lateinit var input5: EditText
    private lateinit var input6: EditText
    private lateinit var input7: EditText
    private lateinit var input8: EditText

    private lateinit var result1: TextView
    private lateinit var result2: TextView
    private lateinit var result3: TextView
    private lateinit var result4: TextView

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
    private lateinit var txt8: TextView
    private lateinit var txt9: TextView
    private lateinit var txt10: TextView
    private lateinit var txt11: TextView
    private lateinit var txt12: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculations33_42, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id=requireActivity().intent.getIntExtra("id",33)
        spinner1 =requireView().findViewById(R.id.spinner1_calculations33)
        spinner2 =requireView().findViewById(R.id.spinner2_calculations33)
        spinner3 =requireView().findViewById(R.id.spinner3_calculations33)
        spinner4 =requireView().findViewById(R.id.spinner4_calculations33)
        spinner5 =requireView().findViewById(R.id.spinner5_calculations33)
        spinner6 =requireView().findViewById(R.id.spinner6_calculations33)
        spinner7 =requireView().findViewById(R.id.spinner7_calculations33)
        spinner8 =requireView().findViewById(R.id.spinner8_calculations33)


        input1 =requireView().findViewById(R.id.calculations33_input1)
        input2 =requireView().findViewById(R.id.calculations33_input2)
        input3 =requireView().findViewById(R.id.calculations33_input3)
        input4 =requireView().findViewById(R.id.calculations33_input4)
        input5 =requireView().findViewById(R.id.calculations33_input5)
        input6 =requireView().findViewById(R.id.calculations33_input6)
        input7 =requireView().findViewById(R.id.calculations33_input7)
        input8 =requireView().findViewById(R.id.calculations33_input8)


        result1 =requireView().findViewById(R.id.calculations33_result1)
        result2 =requireView().findViewById(R.id.calculations33_result2)
        result3 =requireView().findViewById(R.id.calculations33_result3)
        result4 =requireView().findViewById(R.id.calculations33_result4)


        imgBottomSave=requireView().findViewById(R.id.imgBottomSave_calculations33)
        imgBottomHome=requireView().findViewById(R.id.imgBottomHome_calculations33)
        imgBottomCopy=requireView().findViewById(R.id.imgBottomCopy_calculations33)
        img=requireView().findViewById(R.id.img_calculations33)

        txt1=requireView().findViewById(R.id.txt1_calculations33)
        txt2=requireView().findViewById(R.id.txt2_calculations33)
        txt3=requireView().findViewById(R.id.txt3_calculations33)
        txt4=requireView().findViewById(R.id.txt4_calculations33)
        txt5=requireView().findViewById(R.id.txt5_calculations33)
        txt6=requireView().findViewById(R.id.txt6_calculations33)
        txt7=requireView().findViewById(R.id.txt7_calculations33)
        txt8=requireView().findViewById(R.id.txt8_calculations33)
        txt9=requireView().findViewById(R.id.txt9_calculations33)
        txt10=requireView().findViewById(R.id.txt10_calculations33)
        txt11=requireView().findViewById(R.id.txt11_calculations33)
        txt12=requireView().findViewById(R.id.txt12_calculations33)

        setSpinnersAdapters()
        setLayout(id)

        super.onViewCreated(view, savedInstanceState)
    }
    private fun setLayout(id:Int){
        when(id+1)
        {
            33->layout33()
            34->layout34()
            35->layout35()
            36->layout36()
            37->layout37()
            38->layout38()
            39->layout39()
            40->layout40()
            41->layout41()
            42->layout42()
        }
    }
    private fun layout33(){
        fun calculateResults(){
            val d=getFieldInM(input1,spinner1)
            val h=getFieldInM(input2,spinner2)
            val l=getFieldInM(input3,spinner3)
            val ro=input8.text.toString().toDouble()

            val res1=h*Values.pi*d*d/4
            val res2=l*Values.pi*d*d/4
            val res3=res1-res2
            val res4=res2*ro

            result1.text = "${Round.round(res1)} м3"
            result2.text = "${Round.round(res2)} м3"
            result3.text = "${Round.round(res3)} м3"
            result4.text = "${Round.round(res4)} кг"

        }
        fun checkMetricFields(){
            if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input8.text.isNotEmpty()  ) {
               calculateResults()
            }
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_volumes_detail_1)
            setVisibilityGone(txt4,input4,spinner4)
            setVisibilityGone(txt5,input5,spinner5)
            setVisibilityGone(txt6,input6,spinner6)
            setVisibilityGone(txt7,input7,spinner7)
            setText(txt1,requireContext().resources.getString(R.string.calculation33_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation33_text2))
            setText(txt3,requireContext().resources.getString(R.string.calculation33_text3))
            setText(txt8,requireContext().resources.getString(R.string.calculation33_text4))
        }
         fun getInfoAboutCalculations(): String{
                return """
            ${getLine(txt1, input1, spinner1)}
            ${getLine(txt2, input2, spinner1)}
            ${getLine(txt3, input3, spinner1)}
            ${getLine(txt8, input8, spinner8.toString())}
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getInfoResultAboutCalculations(): String{
            return """"
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
         fun getTitleFromDialog(): String {
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
                    val id = requireActivity().intent.getIntExtra("id",33)+1
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
        fun setSaveButton(){
            imgBottomSave.setOnClickListener {
                getTitleFromDialog()

            }
        }
        fun setCopyButton(){
            val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            imgBottomCopy.setOnClickListener {
                val textToCopy = getInfoResultAboutCalculations()
                val clip = ClipData.newPlainText("RANDOM UUID", textToCopy)
                clipboard.setPrimaryClip(clip)
            }

        }
        fun setHomeButton(){
            imgBottomHome.setOnClickListener {
                requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
        fun setBottomButtons(){
            setCopyButton()
            setHomeButton()
            setSaveButton()
        }
        fun checkFields(){
            input1.doAfterTextChanged {
                checkMetricFields()
            }
            input2.doAfterTextChanged {
                checkMetricFields()
            }
            input3.doAfterTextChanged {
                checkMetricFields()
            }
            input8.doAfterTextChanged {
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
        setView()
        checkFields()
        setBottomButtons()
    }

    //--------------------------------------
    //---------------34---------------------
    //--------------------------------------
    private fun layout34(){
        fun calculateResults(){
            val d=getFieldInM(input1,spinner1)
            val l=getFieldInM(input2,spinner2)
            val ll=getFieldInM(input3,spinner3)
            val ro=input8.text.toString().toDouble()

            var res1=l*Values.pi*d*d/4
            val r=d/2
            var res2=try {
                    (((r*r* acos((r-ll)/r))-((r-ll)* sqrt(2*r*ll-ll*ll)))/(Values.pi*r*r))*res1
            }
            catch (e: Exception)
            {
                0.0
            }
            var res3=res1-res2
            var res4=res2*ro

            result1.text = "${Round.round(res1)} м3"
            result2.text = "${Round.round(res2)} м3"
            result3.text = "${Round.round(res3)} м3"
            result4.text = "${Round.round(res4)} кг"

        }
        fun checkMetricFields(){
            if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input8.text.isNotEmpty()  ) {
                calculateResults()
            }
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_volumes_detail_2)
            setVisibilityGone(txt4,input4,spinner4)
            setVisibilityGone(txt5,input5,spinner5)
            setVisibilityGone(txt6,input6,spinner6)
            setVisibilityGone(txt7,input7,spinner7)
            setText(txt1,requireContext().resources.getString(R.string.calculation34_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation34_text2))
            setText(txt3,requireContext().resources.getString(R.string.calculation34_text3))
            setText(txt8,requireContext().resources.getString(R.string.calculation34_text4))
        }
        fun getInfoAboutCalculations(): String{
            return """
            ${getLine(txt1, input1, spinner1)}
            ${getLine(txt2, input2, spinner1)}
            ${getLine(txt3, input3, spinner1)}
            ${getLine(txt8, input8, spinner8.toString())}
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getInfoResultAboutCalculations(): String{
            return """"
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getTitleFromDialog(): String {
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
                    val id = requireActivity().intent.getIntExtra("id",33)+1
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
        fun setSaveButton(){
            imgBottomSave.setOnClickListener {
                getTitleFromDialog()

            }
        }
        fun setCopyButton(){
            val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            imgBottomCopy.setOnClickListener {
                val textToCopy = getInfoResultAboutCalculations()
                val clip = ClipData.newPlainText("RANDOM UUID", textToCopy)
                clipboard.setPrimaryClip(clip)
            }

        }
        fun setHomeButton(){
            imgBottomHome.setOnClickListener {
                requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
        fun setBottomButtons(){
            setCopyButton()
            setHomeButton()
            setSaveButton()
        }
        fun checkFields(){
            input1.doAfterTextChanged {
                checkMetricFields()
            }
            input2.doAfterTextChanged {
                checkMetricFields()
            }
            input3.doAfterTextChanged {
                checkMetricFields()
            }
            input8.doAfterTextChanged {
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
        setView()
        checkFields()
        setBottomButtons()
    }

    //--------------------------------------
    //---------------35---------------------
    //--------------------------------------
    private fun layout35(){
        fun calculateResults(){
            var b=getFieldInM(input1,spinner1)/2
            var a=getFieldInM(input2,spinner2)/2
            val l=getFieldInM(input3,spinner3)
            val ll=getFieldInM(input4,spinner4)
            val ro=input8.text.toString().toDouble()
            val x=2*a*ll/b
            val res1=l*Values.pi*a*b
            val res2=try {
                (b*a* asin((ll/a)-1)+b* sqrt(-(ll)*ll+2*a*ll)*(ll/a-1)-b*a* asin(-1.0))*l
            }
            catch (e: Exception )
            {
                0.0
            }
            val res3=res1-res2
            val res4=res2*ro

            result1.text = "${Round.round(res1)} м3"
            result2.text = "${Round.round(res2)} м3"
            result3.text = "${Round.round(res3)} м3"
            result4.text = "${Round.round(res4)} кг"


        }
        fun checkMetricFields(){
            if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() && input8.text.isNotEmpty()  ) {
                calculateResults()
            }
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_volumes_detail_3)
            setVisibilityGone(txt5,input5,spinner5)
            setVisibilityGone(txt6,input6,spinner6)
            setVisibilityGone(txt7,input7,spinner7)
            setText(txt1,requireContext().resources.getString(R.string.calculation35_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation35_text2))
            setText(txt3,requireContext().resources.getString(R.string.calculation35_text3))
            setText(txt4,requireContext().resources.getString(R.string.calculation35_text4))
            setText(txt8,requireContext().resources.getString(R.string.calculation35_text5))
        }
        fun getInfoAboutCalculations(): String{
            return """
            ${getLine(txt1, input1, spinner1)}
            ${getLine(txt2, input2, spinner2)}
            ${getLine(txt3, input3, spinner3)}
            ${getLine(txt4, input4, spinner4)}
            ${getLine(txt8, input8, spinner8.toString())}
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getInfoResultAboutCalculations(): String{
            return """"
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getTitleFromDialog(): String {
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
                    val id = requireActivity().intent.getIntExtra("id",33)+1
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
        fun setSaveButton(){
            imgBottomSave.setOnClickListener {
                getTitleFromDialog()

            }
        }
        fun setCopyButton(){
            val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            imgBottomCopy.setOnClickListener {
                val textToCopy = getInfoResultAboutCalculations()
                val clip = ClipData.newPlainText("RANDOM UUID", textToCopy)
                clipboard.setPrimaryClip(clip)
            }

        }
        fun setHomeButton(){
            imgBottomHome.setOnClickListener {
                requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
        fun setBottomButtons(){
            setCopyButton()
            setHomeButton()
            setSaveButton()
        }
        fun checkFields(){
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
            input8.doAfterTextChanged {
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
            spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
            spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }
        setView()
        checkFields()
        setBottomButtons()
    }
    //--------------------------------------
    //---------------36---------------------
    //--------------------------------------
    private fun layout36(){
        fun calculateResults(){
            val b=getFieldInM(input1,spinner1)
            val a=getFieldInM(input2,spinner2)
            val c=getFieldInM(input3,spinner3)
            val ll=getFieldInM(input4,spinner4)
            val ro=input8.text.toString().toDouble()

            val res1=a*b*c
            val res2=b*c*ll
            val res3=res1-res2
            val res4=res2*ro

            result1.text = "${Round.round(res1)} м3"
            result2.text = "${Round.round(res2)} м3"
            result3.text = "${Round.round(res3)} м3"
            result4.text = "${Round.round(res4)} кг"

        }
        fun checkMetricFields(){
            if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() && input8.text.isNotEmpty()  ) {
                calculateResults()
            }
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_volumes_detail_4)
            setVisibilityGone(txt5,input5,spinner5)
            setVisibilityGone(txt6,input6,spinner6)
            setVisibilityGone(txt7,input7,spinner7)
            setText(txt1,requireContext().resources.getString(R.string.calculation36_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation36_text2))
            setText(txt3,requireContext().resources.getString(R.string.calculation36_text3))
            setText(txt4,requireContext().resources.getString(R.string.calculation36_text4))
            setText(txt8,requireContext().resources.getString(R.string.calculation36_text5))
        }
        fun getInfoAboutCalculations(): String{
            return """
            ${getLine(txt1, input1, spinner1)}
            ${getLine(txt2, input2, spinner2)}
            ${getLine(txt3, input3, spinner3)}
            ${getLine(txt4, input4, spinner4)}
            ${getLine(txt8, input8, spinner8.toString())}
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getInfoResultAboutCalculations(): String{
            return """"
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getTitleFromDialog(): String {
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
                    val id = requireActivity().intent.getIntExtra("id",33)+1
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
        fun setSaveButton(){
            imgBottomSave.setOnClickListener {
                getTitleFromDialog()

            }
        }
        fun setCopyButton(){
            val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            imgBottomCopy.setOnClickListener {
                val textToCopy = getInfoResultAboutCalculations()
                val clip = ClipData.newPlainText("RANDOM UUID", textToCopy)
                clipboard.setPrimaryClip(clip)
            }

        }
        fun setHomeButton(){
            imgBottomHome.setOnClickListener {
                requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
        fun setBottomButtons(){
            setCopyButton()
            setHomeButton()
            setSaveButton()
        }
        fun checkFields(){
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
            input8.doAfterTextChanged {
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
            spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
            spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }
        setView()
        checkFields()
        setBottomButtons()
    }
    //--------------------------------------
    //---------------37---------------------
    //--------------------------------------
    private fun layout37(){
        fun calculateResults(){
            val d=getFieldInM(input1,spinner1)
            val h=getFieldInM(input2,spinner2)
            val ll=getFieldInM(input3,spinner3)
            val ro=input8.text.toString().toDouble()
            val d3=d*ll/h
            val res1=Values.pi*h*d*d/12
            val res2=Values.pi*ll*d3*d3/12
            val res3=res1-res2
            val res4=res2*ro

            result1.text = "${Round.round(res1)} м3"
            result2.text = "${Round.round(res2)} м3"
            result3.text = "${Round.round(res3)} м3"
            result4.text = "${Round.round(res4)} кг"


        }
        fun checkMetricFields(){
            if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input8.text.isNotEmpty()  ) {
                calculateResults()
            }
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_volumes_detail_5)
            setVisibilityGone(txt4,input4,spinner4)
            setVisibilityGone(txt5,input5,spinner5)
            setVisibilityGone(txt6,input6,spinner6)
            setVisibilityGone(txt7,input7,spinner7)
            setText(txt1,requireContext().resources.getString(R.string.calculation37_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation37_text2))
            setText(txt3,requireContext().resources.getString(R.string.calculation37_text3))
            setText(txt8,requireContext().resources.getString(R.string.calculation37_text4))
        }
        fun getInfoAboutCalculations(): String{
            return """
            ${getLine(txt1, input1, spinner1)}
            ${getLine(txt2, input2, spinner2)}
            ${getLine(txt3, input3, spinner3)}          
            ${getLine(txt8, input8, spinner8.toString())}
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getInfoResultAboutCalculations(): String{
            return """"
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getTitleFromDialog(): String {
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
                    val id = requireActivity().intent.getIntExtra("id",33)+1
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
        fun setSaveButton(){
            imgBottomSave.setOnClickListener {
                getTitleFromDialog()

            }
        }
        fun setCopyButton(){
            val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            imgBottomCopy.setOnClickListener {
                val textToCopy = getInfoResultAboutCalculations()
                val clip = ClipData.newPlainText("RANDOM UUID", textToCopy)
                clipboard.setPrimaryClip(clip)
            }

        }
        fun setHomeButton(){
            imgBottomHome.setOnClickListener {
                requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
        fun setBottomButtons(){
            setCopyButton()
            setHomeButton()
            setSaveButton()
        }
        fun checkFields(){
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
            input8.doAfterTextChanged {
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
            spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
            spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }
        setView()
        checkFields()
        setBottomButtons()
    }
    //--------------------------------------
    //---------------38---------------------
    //--------------------------------------
    private fun layout38(){
        fun calculateResults(){
            val d=getFieldInM(input1,spinner1)
            val h1=getFieldInM(input2,spinner2)
            val h2=getFieldInM(input3,spinner3)
            val ll=getFieldInM(input4,spinner4)
            val ro=input8.text.toString().toDouble()
            val d3=d*ll/h1
            val res1=PI*h1*d*d/12+PI*d*d*h2/4
            val res2=if(ll<h1)
                PI*ll*d3*d3/12
            else
                PI*h1*d*d/12+PI*d*d*(ll-h1)/4
            val res3=res1-res2
            val res4=res2*ro

            result1.text = "${Round.round(res1)} м3"
            result2.text = "${Round.round(res2)} м3"
            result3.text = "${Round.round(res3)} м3"
            result4.text = "${Round.round(res4)} кг"

        }
        fun checkMetricFields(){
            if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() && input8.text.isNotEmpty()  ) {
                calculateResults()
            }
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_volumes_detail_6)
            setVisibilityGone(txt5,input5,spinner5)
            setVisibilityGone(txt6,input6,spinner6)
            setVisibilityGone(txt7,input7,spinner7)
            setText(txt1,requireContext().resources.getString(R.string.calculation38_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation38_text2))
            setText(txt3,requireContext().resources.getString(R.string.calculation38_text3))
            setText(txt4,requireContext().resources.getString(R.string.calculation38_text4))
            setText(txt8,requireContext().resources.getString(R.string.calculation38_text5))
        }
        fun getInfoAboutCalculations(): String{
            return """
            ${getLine(txt1, input1, spinner1)}
            ${getLine(txt2, input2, spinner2)}
            ${getLine(txt3, input3, spinner3)}
            ${getLine(txt4, input4, spinner4)}
            ${getLine(txt8, input8, spinner8.toString())}
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getInfoResultAboutCalculations(): String{
            return """"
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getTitleFromDialog(): String {
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
                    val id = requireActivity().intent.getIntExtra("id",33)+1
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
        fun setSaveButton(){
            imgBottomSave.setOnClickListener {
                getTitleFromDialog()

            }
        }
        fun setCopyButton(){
            val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            imgBottomCopy.setOnClickListener {
                val textToCopy = getInfoResultAboutCalculations()
                val clip = ClipData.newPlainText("RANDOM UUID", textToCopy)
                clipboard.setPrimaryClip(clip)
            }

        }
        fun setHomeButton(){
            imgBottomHome.setOnClickListener {
                requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
        fun setBottomButtons(){
            setCopyButton()
            setHomeButton()
            setSaveButton()
        }
        fun checkFields(){
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
            input8.doAfterTextChanged {
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
            spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
            spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }
        setView()
        checkFields()
        setBottomButtons()
    }
    //--------------------------------------
    //---------------39---------------------
    //--------------------------------------
    private fun layout39(){
        fun calculateResults(){
            var d1=getFieldInM(input1,spinner1)
            var d2=getFieldInM(input2,spinner2)
            val h=getFieldInM(input3,spinner3)
            val ll=getFieldInM(input4,spinner4)
            val ro=input8.text.toString().toDouble()
            d1/=2
            d2/=2
            val d3=d2*ll/h
            val res1=PI*h*(d1*d1+d1*d2+d2*d2)/3
            val res2=PI*h*(d1*d1+d1*d3+d3*d3)/3
            val res3=res1-res2
            val res4=res2*ro

            result1.text = "${Round.round(res1)} м3"
            result2.text = "${Round.round(res2)} м3"
            result3.text = "${Round.round(res3)} м3"
            result4.text = "${Round.round(res4)} кг"
        }
        fun checkMetricFields(){
            if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() && input8.text.isNotEmpty()  ) {
                calculateResults()
            }
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_volumes_detail_7)
            setVisibilityGone(txt5,input5,spinner5)
            setVisibilityGone(txt6,input6,spinner6)
            setVisibilityGone(txt7,input7,spinner7)
            setText(txt1,requireContext().resources.getString(R.string.calculation39_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation39_text2))
            setText(txt3,requireContext().resources.getString(R.string.calculation39_text3))
            setText(txt4,requireContext().resources.getString(R.string.calculation39_text4))
            setText(txt8,requireContext().resources.getString(R.string.calculation39_text5))
        }
        fun getInfoAboutCalculations(): String{
            return """
            ${getLine(txt1, input1, spinner1)}
            ${getLine(txt2, input2, spinner2)}
            ${getLine(txt3, input3, spinner3)}
            ${getLine(txt4, input4, spinner4)}
            ${getLine(txt8, input8, spinner8.toString())}
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getInfoResultAboutCalculations(): String{
            return """"
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getTitleFromDialog(): String {
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
                    val id = requireActivity().intent.getIntExtra("id",33)+1
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
        fun setSaveButton(){
            imgBottomSave.setOnClickListener {
                getTitleFromDialog()

            }
        }
        fun setCopyButton(){
            val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            imgBottomCopy.setOnClickListener {
                val textToCopy = getInfoResultAboutCalculations()
                val clip = ClipData.newPlainText("RANDOM UUID", textToCopy)
                clipboard.setPrimaryClip(clip)
            }

        }
        fun setHomeButton(){
            imgBottomHome.setOnClickListener {
                requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
        fun setBottomButtons(){
            setCopyButton()
            setHomeButton()
            setSaveButton()
        }
        fun checkFields(){
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
            input8.doAfterTextChanged {
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
            spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
            spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }
        setView()
        checkFields()
        setBottomButtons()
    }
    //--------------------------------------
    //---------------40---------------------
    //--------------------------------------
    private fun layout40(){
        fun calculateResults(){
            var d1=getFieldInM(input1,spinner1)
            var d2=getFieldInM(input2,spinner2)
            val h1=getFieldInM(input3,spinner3)
            val h2=getFieldInM(input4,spinner4)
            val ll=getFieldInM(input5,spinner5)
            val ro=input8.text.toString().toDouble()
            d1/=2
            d2/=2
            val d3=d2*ll/h1
            val res1=PI*h1*(d1*d1+d1*d2+d2*d2)/3+PI*d2*d2*h2
            val res2=if(ll<h1)
                    PI*h1*(d1*d1+d1*d3+d3*d3)/3
            else
                PI*h1*(d1*d1+d1*d2+d2*d2)/3+PI*d2*d2*ll
            val res3=res1-res2
            val res4=res2*ro

            result1.text = "${Round.round(res1)} м3"
            result2.text = "${Round.round(res2)} м3"
            result3.text = "${Round.round(res3)} м3"
            result4.text = "${Round.round(res4)} кг"

        }
        fun checkMetricFields(){
            if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() && input5.text.isNotEmpty() && input8.text.isNotEmpty()  ) {
                calculateResults()
            }
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_volumes_detail_8)
            setVisibilityGone(txt6,input6,spinner6)
            setVisibilityGone(txt7,input7,spinner7)
            setText(txt1,requireContext().resources.getString(R.string.calculation40_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation40_text2))
            setText(txt3,requireContext().resources.getString(R.string.calculation40_text3))
            setText(txt4,requireContext().resources.getString(R.string.calculation40_text4))
            setText(txt5,requireContext().resources.getString(R.string.calculation40_text5))
            setText(txt8,requireContext().resources.getString(R.string.calculation40_text6))
        }
        fun getInfoAboutCalculations(): String{
            return """
            ${getLine(txt1, input1, spinner1)}
            ${getLine(txt2, input2, spinner2)}
            ${getLine(txt3, input3, spinner3)}
            ${getLine(txt4, input4, spinner4)}
            ${getLine(txt5, input5, spinner5)}
            ${getLine(txt8, input8, spinner8.toString())}
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getInfoResultAboutCalculations(): String{
            return """"
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getTitleFromDialog(): String {
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
                    val id = requireActivity().intent.getIntExtra("id",33)+1
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
        fun setSaveButton(){
            imgBottomSave.setOnClickListener {
                getTitleFromDialog()

            }
        }
        fun setCopyButton(){
            val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            imgBottomCopy.setOnClickListener {
                val textToCopy = getInfoResultAboutCalculations()
                val clip = ClipData.newPlainText("RANDOM UUID", textToCopy)
                clipboard.setPrimaryClip(clip)
            }

        }
        fun setHomeButton(){
            imgBottomHome.setOnClickListener {
                requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
        fun setBottomButtons(){
            setCopyButton()
            setHomeButton()
            setSaveButton()
        }
        fun checkFields(){
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
            input8.doAfterTextChanged {
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
            spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
            spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }
        setView()
        checkFields()
        setBottomButtons()
    }
    //--------------------------------------
    //---------------41---------------------
    //--------------------------------------
    private fun layout41(){
        fun calculateResults(){
            var a=getFieldInM(input1,spinner1)
            var b=getFieldInM(input2,spinner2)
            val c=getFieldInM(input3,spinner3)
            val d=getFieldInM(input4,spinner4)
            val h=getFieldInM(input5,spinner5)
            val ll=getFieldInM(input6,spinner6)
            val ro=input8.text.toString().toDouble()
            val s2=c*d
            val z=sqrt((c-a)*(c-a)+(d-b)*(d-b)+h*h)
            val x=z*ll/h

            val y= z-x
            val r=a*z/(c-a)
            val k=(r+x)/(r+x+y)
            val s3=k*k*s2
            val res1=(h/3)*(d*c+ sqrt(d*c*a*b)+a*b)
            val res2=(ll/3)*(s3+ sqrt(s3*a*b)+a*b)
            val res3=res1-res2
            val res4=res2*ro

            result1.text = "${Round.round(res1)} м3"
            result2.text = "${Round.round(res2)} м3"
            result3.text = "${Round.round(res3)} м3"
            result4.text = "${Round.round(res4)} кг"
        }
        fun checkMetricFields(){
            if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty()
                    && input4.text.isNotEmpty() && input5.text.isNotEmpty() && input6.text.isNotEmpty() && input8.text.isNotEmpty()  ) {
                calculateResults()
            }
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_volumes_detail_9)
            setVisibilityGone(txt7,input7,spinner7)
            setText(txt1,requireContext().resources.getString(R.string.calculation41_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation41_text2))
            setText(txt3,requireContext().resources.getString(R.string.calculation41_text3))
            setText(txt4,requireContext().resources.getString(R.string.calculation41_text4))
            setText(txt5,requireContext().resources.getString(R.string.calculation41_text5))
            setText(txt6,requireContext().resources.getString(R.string.calculation41_text6))
            setText(txt8,requireContext().resources.getString(R.string.calculation41_text7))
        }
        fun getInfoAboutCalculations(): String{
            return """
            ${getLine(txt1, input1, spinner1)}
            ${getLine(txt2, input2, spinner2)}
            ${getLine(txt3, input3, spinner3)}
            ${getLine(txt4, input4, spinner4)}
            ${getLine(txt5, input5, spinner5)}
            ${getLine(txt6, input6, spinner6)}
            ${getLine(txt8, input8, spinner8.toString())}
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getInfoResultAboutCalculations(): String{
            return """"
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getTitleFromDialog(): String {
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
                    val id = requireActivity().intent.getIntExtra("id",33)+1
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
        fun setSaveButton(){
            imgBottomSave.setOnClickListener {
                getTitleFromDialog()

            }
        }
        fun setCopyButton(){
            val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            imgBottomCopy.setOnClickListener {
                val textToCopy = getInfoResultAboutCalculations()
                val clip = ClipData.newPlainText("RANDOM UUID", textToCopy)
                clipboard.setPrimaryClip(clip)
            }

        }
        fun setHomeButton(){
            imgBottomHome.setOnClickListener {
                requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
        fun setBottomButtons(){
            setCopyButton()
            setHomeButton()
            setSaveButton()
        }
        fun checkFields(){
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
            input8.doAfterTextChanged {
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
            spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
            spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }
        setView()
        checkFields()
        setBottomButtons()
    }

    //--------------------------------------
    //---------------42---------------------
    //--------------------------------------
    private fun layout42(){
        fun calculateResults(){
            var a=getFieldInM(input1,spinner1)
            var b=getFieldInM(input2,spinner2)
            val c=getFieldInM(input3,spinner3)
            val d=getFieldInM(input4,spinner4)
            val h1=getFieldInM(input5,spinner5)
            val h2=getFieldInM(input6,spinner6)
            val ll=getFieldInM(input7,spinner7)
            val ro=input8.text.toString().toDouble()
            val s2=c*d
            val z=sqrt((c-a)*(c-a)+(d-b)*(d-b)+h1*h1)
            val x=z*ll/h1

            val y= z-x
            val r=a*z/(c-a)
            val k=(r+x)/(r+x+y)
            val s3=k*k*s2
            val res1=(h1/3)*(d*c+ sqrt(d*c*a*b)+a*b)+c*d*h2
            val res2=if(ll<h1)
                    (ll/3)*(s3+ sqrt(s3*a*b)+a*b)
            else
                (ll/3)*(s3+ sqrt(s3*a*b)+a*b)+c*d*(ll-h1)
            val res3=res1-res2
            val res4=res2*ro

            result1.text = "${Round.round(res1)} м3"
            result2.text = "${Round.round(res2)} м3"
            result3.text = "${Round.round(res3)} м3"
            result4.text = "${Round.round(res4)} кг"

        }
        fun checkMetricFields(){
            if(input1.text.isNotEmpty() && input2.text.isNotEmpty() && input3.text.isNotEmpty() && input4.text.isNotEmpty() && input5.text.isNotEmpty()
                    && input6.text.isNotEmpty()  && input7.text.isNotEmpty()&& input8.text.isNotEmpty()  ) {
                calculateResults()
            }
        }
        fun setView(){
            img.setImageResource(R.drawable.ic_volumes_detail_10)
            setText(txt1,requireContext().resources.getString(R.string.calculation42_text1))
            setText(txt2,requireContext().resources.getString(R.string.calculation42_text2))
            setText(txt3,requireContext().resources.getString(R.string.calculation42_text3))
            setText(txt4,requireContext().resources.getString(R.string.calculation42_text4))
            setText(txt5,requireContext().resources.getString(R.string.calculation42_text5))
            setText(txt6,requireContext().resources.getString(R.string.calculation42_text6))
            setText(txt7,requireContext().resources.getString(R.string.calculation42_text7))
            setText(txt8,requireContext().resources.getString(R.string.calculation42_text8))
        }
        fun getInfoAboutCalculations(): String{
            return """
            ${getLine(txt1, input1, spinner1)}
            ${getLine(txt2, input2, spinner2)}
            ${getLine(txt3, input3, spinner3)}
            ${getLine(txt4, input4, spinner4)}
            ${getLine(txt5, input5, spinner5)}
            ${getLine(txt6, input6, spinner6)}
            ${getLine(txt7, input7, spinner7)}
            ${getLine(txt8, input8, spinner8.toString())}
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getInfoResultAboutCalculations(): String{
            return """"
            ${getLine(txt9, result1)}
            ${getLine(txt10, result2)}
            ${getLine(txt11, result3)}
            ${getLine(txt12, result4)}
        """.trimIndent()
        }
        fun getTitleFromDialog(): String {
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
                    val id = requireActivity().intent.getIntExtra("id",33)+1
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
        fun setSaveButton(){
            imgBottomSave.setOnClickListener {
                getTitleFromDialog()

            }
        }
        fun setCopyButton(){
            val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            imgBottomCopy.setOnClickListener {
                val textToCopy = getInfoResultAboutCalculations()
                val clip = ClipData.newPlainText("RANDOM UUID", textToCopy)
                clipboard.setPrimaryClip(clip)
            }

        }
        fun setHomeButton(){
            imgBottomHome.setOnClickListener {
                requireContext().startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
        fun setBottomButtons(){
            setCopyButton()
            setHomeButton()
            setSaveButton()
        }
        fun checkFields(){
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
            input8.doAfterTextChanged {
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
            spinner6.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
            spinner7.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View, position: Int, id: Long) {
                    checkMetricFields()
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // your code here
                }
            }
        }
        setView()
        checkFields()
        setBottomButtons()
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
        return txt.text.toString()+" "+input.text+" "+getSpinnerItem(spinner)
    }
    private fun getLine(txt: TextView, input: EditText, s: String): String
    {
        return txt.text.toString()+" "+input.text+" "+s
    }
    private fun getLine(txt: TextView, result: TextView): String
    {
        return txt.text.toString()+" "+result.text
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

        val adapter = SpinnerAdapter(requireContext(), requireContext().resources.getStringArray(R.array.array_values))
        spinner1.adapter=adapter
        spinner2.adapter=adapter
        spinner3.adapter=adapter
        spinner4.adapter=adapter
        spinner5.adapter=adapter
        spinner6.adapter=adapter
        spinner7.adapter=adapter
    }

}