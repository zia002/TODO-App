package com.hashcodeinc.jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.ai.client.generativeai.type.content
@Composable
fun ToDoListPage(viewModel: TodoViewModel){
    val toDoDataList by viewModel.todoList.observeAsState()
    var input by remember{ mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(value = input, modifier = Modifier.weight(1f),onValueChange = {
                input=it
            })
            IconButton(onClick = {
                viewModel.addTodo(Todo(0,input))
                input=""
                                 }, modifier = Modifier.border(1.dp,Color.Black)) {
                Icon(painter = painterResource(id = R.drawable.add), contentDescription ="Add todo", tint = Color.Green )
            }

        }
        toDoDataList?.let {
            LazyColumn(modifier = Modifier.fillMaxSize()
                ,
                content = {
                    itemsIndexed(it){ _: Int, item: Todo ->
                        ShowToDo(item, onDelete = {
                            viewModel.deleteTodo(item.id)
                        })
                    }
                })
        }?: Text(text = "Empty Todo", modifier = Modifier.fillMaxSize())
    }
}
@Composable
fun ShowToDo(item:Todo,onDelete:()->Unit){
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()
        .border(
            1.dp, Color.Black, RoundedCornerShape(5.dp)
        )
    ) {
        Text(text = item.id.toString(), modifier = Modifier.padding(4.dp,0.dp,0.dp,0.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp, 0.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
            ) {
            Text(text = item.toDo, modifier = Modifier.weight(1f),
                fontSize = 17.sp, fontWeight = FontWeight.ExtraBold
            )
            IconButton(onClick = onDelete) {
                Icon(painter = painterResource(id = R.drawable.cross), contentDescription = "Del Btn", tint = Color.Red)
            }
        }
    }
}
