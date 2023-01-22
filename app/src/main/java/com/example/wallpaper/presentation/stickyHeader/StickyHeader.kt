package com.example.wallpaper.presentation.stickyHeader

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeader() {

    val list = getListUser().groupBy(User::age)

    LazyColumn {
        list.forEach { (age, list) ->
            stickyHeader {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colors.primary)
                ) {
                    Text(
                        text = "modifier $age",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
            items(list) { item ->
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "modifier ${item.age}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                }
            }

        }
    }


}

data class User(val name: String, val age: Int)

fun getListUser(): List<User> {
    return listOf(
        User(name = "name1", age = 11),
        User(name = "name2", age = 12),
        User(name = "name3", age = 13),
        User(name = "name4", age = 14),
        User(name = "name5", age = 15),
        User(name = "name6", age = 11),
        User(name = "name7", age = 12),
        User(name = "name8", age = 13),
        User(name = "name9", age = 14),
        User(name = "name10", age = 15),
        User(name = "name11", age = 11),
        User(name = "name12", age = 12),
        User(name = "name13", age = 13),
        User(name = "name14", age = 14),
        User(name = "name15", age = 15),
        User(name = "name10", age = 15),
        User(name = "name11", age = 11),
        User(name = "name12", age = 12),
        User(name = "name13", age = 13),
        User(name = "name14", age = 14),
        User(name = "name15", age = 15),
        User(name = "name10", age = 15),
        User(name = "name11", age = 11),
        User(name = "name12", age = 12),
        User(name = "name13", age = 13),
        User(name = "name14", age = 14),
        User(name = "name15", age = 15),
    )
}