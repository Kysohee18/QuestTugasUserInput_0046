package com.example.tugas_lima

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@Composable

fun landingpage(modifier: Modifier) {
    var namadepan by remember { mutableStateOf("") }
    var namabelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggallahir by remember { mutableStateOf("") }
    val listSkill = listOf(
        "Android", "UI/UX", "web"
    )



    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.persona),
            contentDescription = null,
            modifier=modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
            )
        Column(modifier = Modifier
            .padding(top = 300.dp)
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp))
            .background(color = colorResource(id = R.color.card))
            ) {
            ElevatedCard(modifier = Modifier
                .fillMaxSize(1f)
                .fillMaxWidth()
                )

            {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Text(
                        text = stringResource(id = R.string.judul),
                        style = MaterialTheme.typography.headlineMedium,
                        color = colorResource(id = R.color.ungu_judul)
                    )
                    Text(
                        text = stringResource(id = R.string.sub),
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorResource(id = R.color.abu_subjudul)
                    )
                    Spacer(modifier = Modifier.height(25.dp))


                }
            }

        }
    }

}