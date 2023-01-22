package com.example.wallpaper.presentation.alaramManeger

import android.app.AlarmManager
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime

@Composable
fun AlarmManager(context: Context) {
    val secondText = remember {
        mutableStateOf("")
    }
    val message = remember {
        mutableStateOf("")
    }

    val scheduler = AndroidAlarmScheduler(context)
    var alarmItem: AlarmItem? = null

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(value = secondText.value, onValueChange = {
            secondText.value = it
        }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(top = 5.dp))
        OutlinedTextField(value = message.value, onValueChange = {
            message.value = it
        }, modifier = Modifier.fillMaxWidth())

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                alarmItem = AlarmItem(
                    time = LocalDateTime.now().plusSeconds(secondText.value.toLong()),
                    message = message.value
                )
                alarmItem?.let(scheduler::schedule)
                secondText.value = ""
                message.value = ""
            }) {
                Text(text = "Schedule")
            }
            Button(onClick = {
                alarmItem?.let(scheduler::cancel)
            }) {
                Text(text = "Cancel")
            }
        }
    }
}