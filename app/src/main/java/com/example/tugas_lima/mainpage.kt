package com.example.tugas_lima

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun landingpage(modifier: Modifier = Modifier) {
    // Variabel input nama & email
    var namadepan by remember { mutableStateOf("") }
    var namabelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    // Variabel datepicker
    var tglLahir by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    // Variabel experience
    var experience by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val listExperience = listOf(
        stringResource(id = R.string.exp_1),
        stringResource(id = R.string.exp_2),
        stringResource(id = R.string.exp_3),
        stringResource(id = R.string.exp_4)
    )

    // Variabel skill checkbox
    val selectedSkill = remember { mutableStateListOf<String>() }
    val listSkill = listOf(
        stringResource(id = R.string.skill_uiux),
        stringResource(id = R.string.skill_programming),
        stringResource(id = R.string.skill_database)
    )

    // String Resources untuk Label Biodata
    val lblNamaDepan = stringResource(id = R.string.label_nama_depan)
    val lblNamaBelakang = stringResource(id = R.string.label_nama_belakang)
    val lblEmail = stringResource(id = R.string.label_email)
    val lblTglLahir = stringResource(id = R.string.label_tanggal_lahir)
    val lblExperience = stringResource(id = R.string.label_experience)
    val lblSkill = stringResource(id = R.string.label_pilih_skill)
    val btnOkText = stringResource(id = R.string.btn_ok)

    // Snackbar & CoroutineScope
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black))
    ) {
        Image(
            painter = painterResource(id = R.drawable.persona),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(top = 200.dp)
                .fillMaxWidth()
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 8.dp
                ),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = colorResource(id = R.color.white)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
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
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = namadepan,
                            onValueChange = { namadepan = it },
                            label = { Text(text = stringResource(id = R.string.label_nama_depan)) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(15.dp)
                        )

                        OutlinedTextField(
                            value = namabelakang,
                            onValueChange = { namabelakang = it },
                            label = { Text(text = stringResource(id = R.string.label_nama_belakang)) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(15.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(text = stringResource(id = R.string.label_email)) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // DatePicker
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedTextField(
                                value = tglLahir,
                                onValueChange = { },
                                readOnly = true,
                                label = { Text(text = stringResource(id = R.string.label_tanggal_lahir)) },
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(15.dp)
                            )
                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = null
                                    ) { showDatePicker = true }
                            )
                        }
                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = { expanded = !expanded },
                            modifier = Modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = experience,
                                onValueChange = { },
                                readOnly = true,
                                label = { Text(text = stringResource(id = R.string.label_experience)) },
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                                },
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(15.dp)
                            )
                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                listExperience.forEach { pilihan ->
                                    DropdownMenuItem(
                                        text = { Text(text = pilihan) },
                                        onClick = {
                                            experience = pilihan
                                            expanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    // Checkbox Skill
                    Text(
                        text = stringResource(id = R.string.label_pilih_skill),
                        fontSize = 15.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        listSkill.forEach { skill ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Checkbox(
                                    checked = selectedSkill.contains(skill),
                                    onCheckedChange = { isChecked ->
                                        if (isChecked) {
                                            selectedSkill.add(skill)
                                        } else {
                                            selectedSkill.remove(skill)
                                        }
                                    }
                                )
                                Text(text = skill, fontSize = 14.sp)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))

                    // Tombol Submit
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        enabled = email.isNotEmpty() &&
                                tglLahir.isNotEmpty() &&
                                namadepan.isNotEmpty() &&
                                namabelakang.isNotEmpty() &&
                                experience.isNotEmpty() &&
                                selectedSkill.isNotEmpty(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.ungu_judul),
                            contentColor = colorResource(id = R.color.putih_bersih)
                        ),
                        shape = RoundedCornerShape(80.dp),
                        onClick = {
                            scope.launch {
                                val skillListText = selectedSkill.joinToString(", ")

                                val infoBiodata = """
                                    $lblNamaDepan: $namadepan
                                    $lblNamaBelakang: $namabelakang
                                    $lblEmail: $email
                                    $lblTglLahir: $tglLahir
                                    $lblExperience: $experience
                                    $lblSkill: $skillListText
                                """.trimIndent()

                                snackbarHostState.showSnackbar(
                                    message = infoBiodata,
                                    actionLabel = btnOkText,
                                    withDismissAction = true
                                )
                            }
                        }
                    ) {
                        Text(stringResource(id = R.string.button_submit))
                    }
                }
            }
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) { data ->
            Snackbar(
                snackbarData = data,
                shape = RoundedCornerShape(24.dp),
                containerColor = colorResource(id = R.color.snackbar_bg),
                contentColor = colorResource(id = R.color.putih_bersih),
                actionColor = colorResource(id = R.color.snackbar_action)
            )
        }
    }

    // Dialog DatePicker
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->
                            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).apply {
                                timeZone = TimeZone.getTimeZone("UTC")
                            }
                            tglLahir = formatter.format(Date(millis))
                        }
                        showDatePicker = false
                    }
                ) {
                    Text(stringResource(id = R.string.btn_ok))
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text(stringResource(id = R.string.btn_batal))
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}
