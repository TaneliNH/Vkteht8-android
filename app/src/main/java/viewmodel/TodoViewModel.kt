package viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import model.TodosApi


class TodoViewModel : ViewModel() {
    val todos = mutableStateListOf<String>()

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi.getInstance()
                val fetchedTodos = todosApi.getTodos()
                Log.d("TODOVIEWMODEL", "Fetched todos: $fetchedTodos")
                todos.clear()
                todos.addAll(todosApi.getTodos().map { it.title })
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL", e.message.toString())
            }
        }
    }
}