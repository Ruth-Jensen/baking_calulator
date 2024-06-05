package com.example.bakingcalulator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun App(
){
    Scaffold(
    ){
        paddingValues ->
        Surface(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                //title
                Text (
                    text = stringResource(id = R.string.app_name),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Magenta
                )
                Text(text = "From:")
                FromDropDown()
                Text(text = "To:")
                ToDropDown()
            }
        }
    }
}

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable{ onClick() }
            .then(modifier)
    ){
        Text(
            text = symbol,
            fontSize = 36.sp,
            color = Color.White
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FromDropDown (){
    val list = listOf("Cups", "Tablespoons", "Teaspoons", "Ounces", "Fluid ounces", "Quarts", "Pints", "Gallons", "Pounds", "Milliliters", "Liters", "Grams", "Kilograms")
    var selectedText by remember{ mutableStateOf(list[0]) }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }
        ){
            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedText, 
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)}
            )
            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                list.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            selectedText = list[index]
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDropDown (){
    val list = listOf("Cups", "Tablespoons", "Teaspoons", "Ounces", "Fluid ounces", "Quarts", "Pints", "Gallons", "Pounds", "Milliliters", "Liters", "Grams", "Kilograms")
    var selectedText by remember{ mutableStateOf(list[0]) }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }
        ){
            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)}
            )
            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                list.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text) },
                        onClick = {
                            selectedText = list[index]
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}

//1 fluid ounce = 2 tablespoons
//1 cup = 8 fluid ounces
//1 pint = 2 cups or 16 fluid ounces
//1 quart = 2 pints or 32 fluid ounces
//1 gallon = 4 quarts or 128 fluid ounces
//1 tablespoon = 3 teaspoons
//1/4 cup = 4 tablespoons
//1/3 cup = 5 tablespoons + 1 teaspoon
//1/2 cup = 8 tablespoons
//1 cup = 16 tablespoons

//Imperial System
//
//Teaspoon = t or tsp
//Tablespoon = T, TB, or tbsp
//Cup = C or c
//Pint = pt
//Quart = qt
//Gallon = gal
//Ounce = oz
//Fluid ounce = fl oz
//Pound = lb
//
//Metric System
//
//Milliliter = mL
//Liter = L or l
//Gram = g
//Kilogram = kg