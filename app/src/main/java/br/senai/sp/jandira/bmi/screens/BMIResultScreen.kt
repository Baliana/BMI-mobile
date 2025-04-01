package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculator
import br.senai.sp.jandira.bmi.model.BmiStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.isFilled
import br.senai.sp.jandira.bmi.utils.numberFormat
import java.util.Locale

@Composable
fun BMIResultScreen(navController: NavController?) {

    val context = LocalContext.current

    val sharedUserFile = context
        .getSharedPreferences("usuario", Context.MODE_PRIVATE)
    val age = sharedUserFile.getInt("user_age", 0)
    val height = sharedUserFile.getInt("user_height", 0).toDouble()
    val weight = sharedUserFile.getInt("user_weight", 0)

    val bmiResult = bmiCalculator(weight,height)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        Color(0xFF0390E1),
                        Color(0xFF081E94)
                    )
                )
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.your_bmi_result),
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(730.dp),
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Card(
                        modifier = Modifier
                            .size(110.dp),
                        colors = CardDefaults
                            .cardColors(containerColor = Color.White),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 5.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xFF0390E1),
                                    Color(0xFF081E94)
                                )
                            )
                        )
                    ) {
                       Column (
                            modifier = Modifier
                                .fillMaxSize(),
                           horizontalAlignment = Alignment.CenterHorizontally,
                           verticalArrangement = Arrangement.Center
                       ){
                           Text(
                               text = String.format(Locale.getDefault(),"%.1f",
                                   bmiResult.bmi.second),
                               fontSize = 48.sp,
                               fontWeight = FontWeight.Bold
                           )
                       }

                    }
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text =  bmiResult.bmi.first,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                    Card(
                        modifier = Modifier
                            .width(300.dp)
                            .height(80.dp)
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Column (
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(top = 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(R.string.age),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Gray
                                )
                                Text(
                                    text = age.toString(),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )

                            }
                            VerticalDivider()
                            Column (
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(top = 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(R.string.weight),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Gray
                                )
                                Text(
                                    text = "$weight kg",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )

                            }
                            VerticalDivider()
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(top = 15.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(R.string.height),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Gray
                                )
                                Text(
                                    text = String.format(
                                        Locale.getDefault(),
                                        "%.2f",
                                        height.div(100)
                                    ),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                    //Mostrar o resultado do IMC

                    BmiLevel( markColor = colorResource(R.color.Light_blue),
                              text1 = stringResource(R.string.Under_weight_table),
                              text2 = "<${numberFormat(18.5)}",
                              isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.UNDERWEIGHT)
                    )
                    BmiLevel( markColor = colorResource(R.color.Light_green),
                              text1 = stringResource(R.string.normal_weight_table),
                              text2 = "${numberFormat(18.6)} - ${numberFormat(24.9)} ",
                              isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.NORMAL)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.yellow),
                        text1 = stringResource(R.string.over_weight_table),
                        text2 = "${numberFormat(25.0)} - ${numberFormat(29.9)} ",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OVERWEIGHT)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.light_orange),
                        text1 = stringResource(R.string.obesity1),
                        text2 = "${numberFormat(30.0)} - ${numberFormat(34.9)} ",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY1)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.dark_orange),
                        text1 = stringResource(R.string.obesity2),
                        text2 = "${numberFormat(35.0)} - ${numberFormat(39.9)} ",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY2)
                    )
                    BmiLevel( markColor = colorResource(R.color.RED),
                        text1 = stringResource(R.string.obesity3),
                        text2 = ">${numberFormat(39.0)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY3)
                    )
                    HorizontalDivider()
                    Button(
                        onClick = {navController?.navigate("user_data")},
                        modifier = Modifier
                            .padding(horizontal = 45.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4A97C4)
                        )

                    ) {
                        Text(
                            text = stringResource(R.string.New_Calc),
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}