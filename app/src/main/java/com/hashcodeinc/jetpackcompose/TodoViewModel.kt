package com.hashcodeinc.jetpackcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import kotlin.random.nextInt

class TodoViewModel:ViewModel() {
//    val todoDAO=MainApplication.todoDatabase.getDAO()
//    val todoList:LiveData<List<Todo>> = todoDAO.getAllToDo()
//    fun addTodo(todo: Todo){
//        todoDAO.addTodo(Todo(0,todo.toDo))
//    }
//    fun deleteTodo(id:Int){
//        todoDAO.deleteTodo(id)
//    }
    private var _todoList=MutableLiveData<List<Todo>>()
    val todoList:LiveData<List<Todo>> = _todoList
    private fun getAllTodo(){
        _todoList.value=todoManager.getAllTodo().reversed()
    }
    fun addTodo(todo: Todo){
        todoManager.addTodo(todo)
        getAllTodo()
    }
    fun deleteTodo(id:Int){
        todoManager.deleteTodo(id)
        getAllTodo()
    }

}
object todoManager{
    private var todoList= mutableListOf<Todo>()
    fun getAllTodo():List<Todo>{
        return todoList
    }
    fun addTodo(todo: Todo){
        todoList.add(Todo(Random.nextInt(0..Int.MAX_VALUE),todo.toDo))
    }
    fun deleteTodo(id:Int){
        todoList.removeIf{
            it.id==id

        }
    }
}