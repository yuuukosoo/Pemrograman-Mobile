package com.example.lazyliztlatihan.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.lazyliztlatihan.viewmodel.ListViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: ListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    LazyColumn {

                        items(viewModel.items) { item ->

                            ItemRow(
                                item = item,
                                onSwitchChanged = { isChecked ->

                                    viewModel.updateItemChecked(item.id, isChecked)

                                    val status = if (isChecked) "hidup" else "mati"
                                    Toast.makeText(this@MainActivity, "Switch $status pada item ${item.id}", Toast.LENGTH_SHORT).show()
                                },
                                onBtnClick = {
                                    Toast.makeText(this@MainActivity, "Tombol ditekan untuk item ${item.id}", Toast.LENGTH_SHORT).show()
                                },
                                onItemClick = {
                                    Toast.makeText(this@MainActivity, "Item ditekan: ${item.id}", Toast.LENGTH_SHORT).show()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}