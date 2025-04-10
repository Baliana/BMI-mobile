package br.senai.sp.jandira.bmi.calcs
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.model.Bmi
import br.senai.sp.jandira.bmi.model.BmiStatus
import kotlin.math.pow

@Composable
fun bmiCalculator(weight: Int, height: Double): Bmi{
    //calcular o imc
    val bmi = weight / height.div(100).pow(2)

     when{
         bmi < 18.5 ->
             return  Bmi(
                 bmi = Pair( stringResource(R.string.under_weight), bmi),
                 bmiStatus = BmiStatus.UNDERWEIGHT,
                 color = colorResource(R.color.Light_blue)
             )
         bmi >= 18.5 && bmi < 25.0 ->
             return  Bmi(
                 bmi = Pair( stringResource(R.string.normal_weight), bmi),
                 bmiStatus = BmiStatus.NORMAL,
                 color = colorResource(R.color.Light_green)
             )
         bmi >= 25.0 && bmi < 30.0 ->
             return  Bmi(
                 bmi = Pair( stringResource(R.string.over_weight), bmi),
                 bmiStatus = BmiStatus. OVERWEIGHT,
                 color = colorResource(R.color.yellow)
             )
         bmi >= 30.0 && bmi < 35.0 ->
             return  Bmi(
                 bmi = Pair( stringResource(R.string.class1_weight), bmi),
                 bmiStatus = BmiStatus. OBESITY1,
                 color = colorResource(R.color.light_orange)
             )
         bmi >= 35.0 && bmi < 40.0 ->
             return  Bmi(
                 bmi = Pair( stringResource(R.string.class2_weight), bmi),
                 bmiStatus = BmiStatus. OBESITY2,
                 color = colorResource(R.color.dark_orange)
             )
         else ->
             return Bmi(
                 bmi = Pair("", bmi),
                 bmiStatus = BmiStatus.OBESITY3,
                 color = colorResource(R.color.RED)
             )
     }
}