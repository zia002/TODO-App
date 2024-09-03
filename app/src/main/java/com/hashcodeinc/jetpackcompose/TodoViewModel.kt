package com.hashcodeinc.jetpackcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.nextInt

class TodoViewModel:ViewModel() {
    private val todoDAO=MainApplication.todoDatabase.getDAO()
    val todoList:LiveData<List<Todo>> = todoDAO.getAllToDo()
    fun addTodo(todo: Todo){
        CoroutineScope(Dispatchers.IO).launch {
            todoDAO.addTodo(Todo(0,todo.toDo))
        }
    }
    fun deleteTodo(id:Int){
        CoroutineScope(Dispatchers.IO).launch {
        todoDAO.deleteTodo(id)
        }
    }
}