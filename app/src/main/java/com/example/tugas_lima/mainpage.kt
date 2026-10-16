package com.example.tugas_lima

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable

fun landingpage(modifier: Modifier) {
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.jono),
            contentDescription = null,
            modifier=modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
            )
        Column(modifier = Modifier
            .padding(top = 300.dp)
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(topStart = 55.dp, topEnd = 55.dp))
            .background(color = colorResource(id = R.color.white))
            ) {

        }
    }

}