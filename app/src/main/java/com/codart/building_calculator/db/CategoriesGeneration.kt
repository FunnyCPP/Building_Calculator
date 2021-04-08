package com.codart.building_calculator.db

class CategoriesGeneration {
    companion object{
        //fun for getting different data for any recycler by id
        fun getData(id: Int): MutableList<Category>{
            val data: MutableList<Category> = mutableListOf(Category("NOT FOUND",1,"","NOT FOUND"))
           when(id){
               1 -> return getMainCategories()
               2 -> return getMetalCategories()
               3 -> return getSquaresCategories()
               4 -> return getConvertersCategories()
               5 -> return getMainBetonFormulas()
               6 -> return getMainWallsFormulas()
               7 -> return getMainMaterialsFormulas()
               8 -> return getMainLumbersFormulas()
               9 -> return getMainRoofsFormulas()
               10 -> return getMainVolumesFormulas()
               11 -> return getMainGroundWorksFormulas()
               12 -> return getMainTriangleFormulas()
               13 -> return getMainDifferentFormulas()
               14 -> return getMetalFittingFormulas()
               15 -> return getMetalPipesFormulas()
               16 -> return getMetalPipesCircleFormulas()
               17 -> return getMetalCornerFormulas()
               18 -> return getMetalChannelFormulas()
               19 -> return getMetalBeamFormulas()
               20 -> return getMetalOtherFormulas()
               else -> return data
           }
        }
        fun getTitle(id: Int): String{
            return when (id) {
                1 ->  "Основное"
                2 ->  "Металы"
                3 ->  "Площади"
                4 ->  "Конверторы"
                5 ->  "Фундаменты и бетон"
                6 ->  "Стены"
                7 ->  "Отделка и материалы"
                8 ->  "Пило материалы"
                9 ->  "Кровля"
                10 ->  "Объемы фигур"
                11 ->  "Земляные работы"
                12 ->  "Треугольник"
                13 ->  "Различно"
                14 ->  "Арматура"
                15 ->  "Труба профильная"
                16 ->  "Труба"
                17 ->  "Уголок"
                18 ->  "Швеллер"
                19 ->  "Балка"
                20 ->  "Остальное"
                else ->  "Строительный калькулятор"
            }
        }
        //Array of all calculations
        val calculations: Array<String> = arrayOf("Расчет фундаментной плиты","Расчет ленточного фундамента",
            "Расчет ленточного фундамента с двумя секциями ","Расчет ленточного фундамента с 3-мя секциями","Расчет ленточного фундамента с 4-мя секциями",
            "расчет состава бетона","Количество материала для бетонных колец","Расчет кирпичный стен","Расчет стен из блоков",
            "Расчет стен из блоков по своим размерам","Объем блоков/кирпича в м3","Объем блоков/кирпича в ярде3","Параметры стеновых блоков",
                "Количество утеплителя для стен и фундаментов","Расчет настила из досок/перекрытий","Расчет количества плитки","Расчет напольного покрытия","Расчет количества вагонки на поверхность",
                "Расход грунтовки","Расход краски","Расход штукатурки",
                "Расход шпаклевки","Расход стяжки","Расход ровнителя/наливных полов","Расход плиточного клея","Расход обоев","Плинтус","Объем пиломатералов по количеству","Количество полиматериалов по объему",
                "Кровля",
                "Кровля","Объем","Объем","Объем","Объем","Объем","Объем","Объем","Объем","Объем",
                "Объем","Объем","Расчет подушки из сыпучих материалов","Объем земляных робот( вертикльные стены)","Объем земляных робот( уклон)","Треугольник","Треугольник","Давление на поверхность",
                "Вес арматуры по количеству",
                "Количество арматуры по весу","Арматура ГОСТ 5781-82","Труба профильная","Труба профильная ГОСТ 8639-82","Труба профильная ГОСТ 8645-68"
                ,"Труба профильная ГОСТ 30245-2003","Труба профильная EN 10219","Труба профильная IS 4923","Труба","Труба ГОСТ 3262-75","Уголок","Уголок ГОСТ 8509-93",
                "Уголок ГОСТ 8510-86","Уголок IS 808-1989","Швеллер","Швеллер ГОСТ 8240-89", "Швеллер IS808: 1989","Балка","Балка ГОСТ 8239-89",
                "Балка ГОСТ 19425-74","Балка ГОСТ 26020-83","Квадрат","Круг/Провалка","Лист","Площадь","Площадь",
                "Площадь", "Площадь", "Площадь", "Площадь", "Площадь","Площадь","Площадь", "Площадь", "Площадь", "Площадь", "Площадь", "Площадь","Площадь","Цельсий - Фарингейт","Сантиметр - Дюйм",
                "Метр - Фут", "Метр - Ярд", "Килограмм - Фунт",
                "Грамм - Фунт", "Грамм - Унция",
                "Джоуль - Килокалорич",
                "Джоуль - Квт/Час", "Литр - Пинта", "Литр - Галлон", "МПа - кГс/см2", "МПф - фунт/дюйм2")
        //----------------------------
        //-------Calculations ID------
        //----------------------------
        //  values for adding to ids for getting number of calculations
        private val id1=7
        private val id2=13
        private var id3=28

        //----------------------------
        //---------'Основное'---------
        //----------------------------
        //List of titles for Category 'Основное'
        private val titlesMainCategories: Array<String> = arrayOf("Фундаменты и Бетон","Стены",
                "Отделка и материалы","Пило материалы","Кровля","Объемы фигур",
                "Земляные работы","Треугольник","Различно")
        //List of texts under titles for Category 'Основное'
        private val descriptionsMainCategories: List<String> = arrayListOf("Фундаменты и Бетон","Стены",
                "Отделка и материалы","Пило материалы","Кровля","Объемы фигур",
                "Земляные работы","Треугольник","Различно")

        //--------------------------------------
        //----Titles for category 'Основное'----
        //--------------------------------------
        //List of titles for Category 'фундаменты и бетон'
        private val  titlesMainBeton: List<String> = arrayListOf("Расчет фундаментной плиты","Расчет ленточного фундамента",
                "Расчет ленточного фундамента с двумя секциями ","Расчет ленточного фундамента с 3-мя секциями","Расчет ленточного фундамента с 4-мя секциями",
                "расчет состава бетона","Количество материала для бетонных колец")

        //List of titles for Category 'Стены'
        private val titlesMainWalls: List<String> = arrayListOf("Расчет кирпичных стен","Расчет стен из блоков",
                "Расчет стен из блоков по своим размерам","Объем блоков/кирпича в м3","Объем блоков/кирпича в ярде3","Параметры стеновых блоков")

        //List of titles for Category 'Отделка и материалы'
        private val titlesMainMaterials: List<String> = arrayListOf("Количество утеплителя для стен и фундамента","Расчет настила из досок/перекрытия",
                "Расчет количества плитки","Расчет напольного покрытия",
                "Расчет количества вагонки",
                "Расход грунтовки", "Расход краски","Расход штукатурки",
                "Расход шпаклевки","Расход стяжки",
                "Расход ровнителя/наливных полов","Расход плиточного клея",
                "Расход обоев","Плинтус")

        //List of titles for Category 'Пило материалы'
        private val titlesMainLumbers: List<String> = arrayListOf("Объем пиломатериалов по количеству","Количество полиматериалов в объеме")
        //List of titles for Category 'Кровля'
        private val titlesMainRoofs: List<String> = arrayListOf("Кровля","Кровля")
        //List of titles for Category 'Объемы фигур'
        private val titlesMainVolumes: List<String> = arrayListOf("Объем","Объем","Объем","Объем","Объем","Объем","Объем","Объем","Объем","Объем")
        //List of titles for Category 'Земляные работы'
        private val titlesMainGroundWorks: List<String> = arrayListOf("Расчет подушки","Вертикальные стены",
                "Уклон")
        //List of titles for Category 'треугольник'
        private val titlesMainTriangle: List<String> = arrayListOf("Треугольник","Треугольник")
        //List of titles for Category 'Различно'
        private val titlesMainDifferent: List<String> = arrayListOf("Давление на поверхность")

        //----------------------------
        //---------'Метал'---------
        //----------------------------

        //List of titles for Category 'Метал'
        private val titlesMetalCategories: Array<String> = arrayOf("Арматура","Труба профильная", "Труба", "Уголок", "Швеллер", "Балка", "Остальное")
        //List of texts under titles for Category 'Метал'
        private val descriptionsMetalCategories: List<String> = arrayListOf("Вес арматуры по количеству...","Труба профильная...","Труба ГОСТ 3262-75...",
            "Уголок ГОСТ 8509-93...","Швеллер ГОСТ 8240-89...", "Балка ГОСТ 8239-89...","Квадрат, Лист...")

        //--------------------------------------
        //----Titles for category 'Метал'----
        //--------------------------------------
        //List of titles for Category 'Арматура'









        //-----------------------------
        //------------FUNS-------------
        //-----------------------------

        //fun for getting list  of data for Category 'Основное'
        private fun getMainCategories(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesMainCategories.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMainCategories[i]), i+5, "ic_main_$j", descriptionsMainCategories[i]))
                i++
            }
            return  categoriesMain
        }
        //fun for getting list  of data for Category 'Метал'
        private fun getMetalCategories(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesMetalCategories.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMetalCategories[i]), i+14, "ic_metals_$j", descriptionsMetalCategories[i]))
                i++
            }
            return  categoriesMain
        }
        //fun for getting list  of data for Category 'Площади'
        private fun getSquaresCategories(): MutableList<Category>{
            val titlesSquaresCategories: Array<String> = arrayOf("Площадь","Площадь", "Площадь", "Площадь", "Площадь", "Площадь", "Площадь","Площадь","Площадь", "Площадь", "Площадь", "Площадь", "Площадь", "Площадь")
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesSquaresCategories.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesSquaresCategories[i]), i+74, "ic_squares_$j", ""))
                i++
            }
            return  categoriesMain
        }
        //fun for getting list  of data for Category 'Конверторы'
        private fun getConvertersCategories(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            val titlesConveretersCategories: Array<String> = arrayOf("Цельсий - Фарингейт","Сантиметр - Дюйм", "Метр - Фут", "Метр - Ярд", "Килограмм - Фунт",
                "Грамм - Фунт", "Грамм - Унция",
                "Джоуль - Килокалорич",
                "Джоуль - Квт/Час", "Литр - Пинта", "Литр - Галлон", "МПа - кГс/см2", "МПф - фунт/дюйм2")
            var  i=0
            var j: Int
            while(i< titlesConveretersCategories.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesConveretersCategories[i]), i+88, "ic_bottom_converters", ""))
                i++
            }
            return  categoriesMain
        }
        //------------------
        //-----Основное-----
        //------------------
        //fun for getting list of data for category 'Основное' section 'Фундаменты и бетон'
       private fun getMainBetonFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesMainBeton.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMainBeton[i]), i, "ic_beton_$j", ""))
                i++
            }
            return  categoriesMain
        }
        //fun for getting list of data for category 'Основное' section 'Стены'
        private fun getMainWallsFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesMainWalls.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMainWalls[i]), i+id1, "ic_walls_${i+1}", ""))
                i++
            }
            return  categoriesMain
        }
        //fun for getting list of data for category 'Основное' section 'Отделка и материалы'
        private fun getMainMaterialsFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesMainMaterials.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMainMaterials[i]), i+id2, "ic_materials_$j", ""))
                i++
            }
            return  categoriesMain
        }
        //fun for getting list of data for category 'Основное' section 'Полиматериалы'
        private fun getMainLumbersFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesMainLumbers.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMainLumbers[i]), i+id3-1, "ic_main_4", ""))
                i++
            }
            return  categoriesMain
        }

        //fun for getting list of data for category 'Основное' section 'Кровля'
        private fun getMainRoofsFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesMainRoofs.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMainRoofs[i]), i+id3+ titlesMainLumbers.size-1, "ic_roofs_$j", ""))
                i++
            }
            return  categoriesMain
        }
        //fun for getting list of data for category 'Основное' section 'Объемы фигур'
        private fun getMainVolumesFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesMainVolumes.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMainVolumes[i]), i+id3+ titlesMainLumbers.size+ titlesMainRoofs.size, "ic_volumes_$j", ""))
                i++
            }
            return  categoriesMain
        }
        //fun for getting list of data for category 'Основное' section 'Земляные работы'
        private fun getMainGroundWorksFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesMainGroundWorks.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMainGroundWorks[i]), i+id3+ titlesMainLumbers.size+ titlesMainRoofs.size+ titlesMainVolumes.size, "ic_groundworks_$j", ""))
                i++
            }
            return  categoriesMain
        }
        //fun for getting list of data for category 'Основное' section 'треугольник'
        private fun getMainTriangleFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesMainTriangle.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMainTriangle[i]), i+id3+ titlesMainLumbers.size+ titlesMainRoofs.size+ titlesMainVolumes.size+ titlesMainGroundWorks.size,
                    "ic_triangles_$j", ""))
                i++
            }
            return  categoriesMain
        }
        //fun for getting list of data for category 'Основное' section 'Различно'
       private fun getMainDifferentFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            var  i=0
            var j: Int
            while(i< titlesMainDifferent.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMainDifferent[i]),
                    i+id3+ titlesMainLumbers.size+ titlesMainRoofs.size+ titlesMainVolumes.size+ titlesMainGroundWorks.size+ titlesMainTriangle.size
                    , "ic_different_$j", ""))
                i++
            }
            return  categoriesMain
        }
        var id4=id3+ titlesMainLumbers.size+ titlesMainRoofs.size+ titlesMainVolumes.size+ titlesMainGroundWorks.size+ titlesMainTriangle.size+ titlesMainDifferent.size
        //--------------
        //-----МЕТАЛ-----
        //--------------
        //fun for getting list of data for category 'Основное' section 'Арматура'
        private val  titlesMetalFittings: List<String> = arrayListOf("Вес арматуры по количеству",
            "Количество аратуры по весу",
            "Арматура ГОСТ")
        private val titlesMetalPipesProfile: List<String> = arrayListOf("Труба профильная","Труба профильная ГОСТ 8639-82",
            "Труба профильная ГОСТ 8645-68","Труба профильная ГОСТ 30245-2003","Труба профильная EN 10219","Труба профильная IS 4923")
        private val titlesMetalCorner: List<String> = arrayListOf("Уголок","Уголок ГОСТ 8509-93",
            "Уголок ГОСТ 8510-86","Уголок IS 808-1989")
        private val titlesMetalChannel: List<String> = arrayListOf("Швеллер","Швеллер ГОСТ 8240-89", "Швеллер IS808: 1989")
        private val titlesMetalPBeam: List<String> = arrayListOf("Балка","Балка ГОСТ 8239-89",
            "Балка ГОСТ 19425-74","Балка ГОСТ 26020-83")
        private val titlesMetalOther= arrayListOf("Квадрат","Круг/Провалка", "Лист")
        val titlesMetalPipesCircle: List<String> = arrayListOf("Труба","Труба ГОСТ 3262-75")
        private fun getMetalFittingFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()

            var  i=0
            var j: Int
            while(i< titlesMetalFittings.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMetalFittings[i]), i+id4, "ic_metals_1", ""))
                i++
            }

            return  categoriesMain
        }
        //fun for getting list of data for category 'Основное' section 'Труба профильная'
        private fun getMetalPipesFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            //List of titles for Category 'Труба Профильная'

            var  i=0
            var j: Int
            while(i< titlesMetalPipesProfile.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMetalPipesProfile[i]), i+id4+titlesMetalFittings.size, "ic_metals_2", ""))
                i++
            }

            return  categoriesMain
        }
        private fun getMetalPipesCircleFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            //List of titles for Category 'Труба'

            var  i=0
            var j: Int
            while(i< titlesMetalPipesCircle.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMetalPipesCircle[i]), i+id4+titlesMetalFittings.size+ titlesMetalPipesProfile.size, "ic_metals_3", ""))
                i++
            }
            return  categoriesMain
        }
        private fun getMetalCornerFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            //List of titles for Category 'Труба Профильная'

            var  i=0
            var j: Int
            while(i< titlesMetalCorner.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMetalCorner[i]), i+id4+titlesMetalFittings.size+ titlesMetalPipesProfile.size+ titlesMetalPipesCircle.size, "ic_metals_4", ""))
                i++
            }

            return  categoriesMain
        }
        private fun getMetalChannelFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()

            var  i=0
            var j: Int
            while(i< titlesMetalChannel.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMetalChannel[i]),
                    i+id4+titlesMetalFittings.size+ titlesMetalPipesProfile.size+ titlesMetalPipesCircle.size+ titlesMetalCorner.size,
                    "ic_metals_5", ""))
                i++
            }
            return  categoriesMain
        }
        private fun getMetalBeamFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            //List of titles for Category 'Труба Профильная'

            var  i=0
            var j: Int
            while(i< titlesMetalPBeam.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMetalPBeam[i]),
                    i+id4+titlesMetalFittings.size+ titlesMetalPipesProfile.size+ titlesMetalPipesCircle.size+ titlesMetalCorner.size+ titlesMetalChannel.size
                    , "ic_metals_6", ""))
                i++
            }
            return  categoriesMain
        }
        private fun getMetalOtherFormulas(): MutableList<Category>{
            val categoriesMain: MutableList<Category> = mutableListOf()
            //List of titles for Category 'Труба Профильная'

            var  i=0
            var j: Int
            while(i< titlesMetalOther.size)
            {
                j=i+1
                categoriesMain.add(Category((titlesMetalOther[i]),
                    i+id4+titlesMetalFittings.size+ titlesMetalPipesProfile.size+ titlesMetalPipesCircle.size+ titlesMetalCorner.size+ titlesMetalChannel.size + titlesMetalPBeam.size
                    , "ic_metals_${i+7}", ""))
                i++
            }
            return  categoriesMain
        }
    }
}