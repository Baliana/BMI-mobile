package br.senai.sp.jandira.bmi.calcs

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.model.Bmi
import br.senai.sp.jandira.bmi.model.BmiStatus
import kotlin.math.pow

@Composable
fun bmiCalculator(weight: Int, height: Double): Bmi{
    //calcula o imc
    val bmi = weight / height.pow(2)

     when{
         bmi < 18.5 ->
             return  Bmi(
                 bmi = Pair("", bmi),
                 bmiStatus = BmiStatus.UNDERWEIGHT,
                 color = colorResource(R.color.Light_blue)
             )
         else ->
             return Bmi(
                 bmi = Pair("", bmi),
                 bmiStatus = BmiStatus.OBESITY3,
                 color = colorResource(R.color.RED)
             )
     }
}