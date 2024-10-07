package com.example.todo_json.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDo_jsonTheme {
                TodoScreen()
            }
        }
    }
}

@Composable
fun TodoList(todos: List<String>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(todos) { todo ->
            Text(
                text = todo,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel()) {
    TodoList(todoViewModel.todos)
}