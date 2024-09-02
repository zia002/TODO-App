package com.hashcodeinc.jetpackcompose

import android.os.FileObserver.DELETE
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Index
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

//=== first we need to create the entities of the DB ====//
//@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var toDo:String
)
/*
   *create the DAO , it contain the data access methods
   * each DAM have a query to get or set data
   *
*/
//@Dao
//interface TodoDAO{
//    @Query("SELECT * FROM TODO")
//    fun getAllToDo():LiveData<List<Todo>>
//    @Insert
//    fun addTodo(todo: Todo)
//    @Query("DELETE FROM TODO where id=:id")
//    fun deleteTodo(id:Int)
//}

/*
   *Crete now the DataBase
   *we need to give a name to the DB
   *need to get the DAO
*/
//@Database(entities = [Todo::class], version = 1)
//abstract class TodoDatabase: RoomDatabase() {
//    companion object{
//        const val NAME="TODO"
//    }
//    abstract fun getDAO():TodoDAO
//
//}

