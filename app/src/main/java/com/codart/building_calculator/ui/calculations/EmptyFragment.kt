package com.codart.building_calculator.ui.calculations

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.codart.building_calculator.R
import com.codart.building_calculator.db.CategoriesGeneration


class EmptyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_empty, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var id=requireActivity().intent.getIntExtra("id", 1)
        val navController=findNavController()
        id++


        when(id)
        {
            1 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment1)
            2 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment2)
            3 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment3)
            4 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment4)
            5 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment5)
            6 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment6)
            7 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment7)
            8 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment8)
            9 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment9)
            10 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment10)
            11 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment11)
            12 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment12)
            13 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment13)
            14 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment14)
            15 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment15)
            16 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment16)
            17 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment17)
            18 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment18)
            19 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment19)
            20 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment20)
            21 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment21)
            22 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment22)
            23 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment23)
            24 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment24)
            25 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment25)
            26 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment26)
            27 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment27)
            28 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment28)
            29 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment29)
            30 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment30)
            31 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment31)
            32 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment32)
            33 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment33)
            34 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment34)
            35 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment35)
            36 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment36)
            37 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment37)
            38 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment38)
            39 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment39)
            40 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment40)
            41 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment41)
            42 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment42)
            43 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment43)
            44 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment44)
            45 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment45)
            46 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment46)
            47 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment47)
            48 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment48)
            49 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment49)
            50 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment50)
            51 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment51)
            52 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment52)
            53 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment53)
            54 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment54)
            55 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment55)
            56 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment56)
            57 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment57)
            58 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment58)
            59 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment59)
            60 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment60)
            61 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment61)
            62 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment62)
            63 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment63)
            64 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment64)
            65 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment65)
            66 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment66)
            67 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment67)
            68 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment68)
            69 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment69)
            70 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment70)
            71 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment71)
            72 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment72)
            73 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment73)
            74 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            75 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            76 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            77 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            78 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            79 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            80 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            81 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            82 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            83 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            84 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            85 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            86 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            87 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            88 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment74)
            89 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            90 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            91 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            92 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            93 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            94 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            95 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            96 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            97 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            98 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            99 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            100 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)
            101 -> navController.navigate(R.id.action_emptyFragment_to_calculationsFragment75)





        }
        super.onViewCreated(view, savedInstanceState)
    }
}