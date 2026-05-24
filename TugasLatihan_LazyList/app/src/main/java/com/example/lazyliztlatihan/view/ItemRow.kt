package com.example.lazyliztlatihan.view

import com.example.lazyliztlatihan.R
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazyliztlatihan.model.ItemModel

@Composable
fun ItemRow(
    item: ItemModel,
    onSwitchChanged: (Boolean) -> Unit,
    onBtnClick: () -> Unit,
    onItemClick: () -> Unit
) {

    val cardColor = if (item.id % 2 != 0) {
        Color.White
    } else {
        Color(0xFFDFFFD6)
    }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onItemClick() },
        shape = RoundedCornerShape(12.dp),

        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(75.dp)
                    .background(Color.LightGray, RoundedCornerShape(12  .dp))

            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = item.title, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.desc)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Switch(
                    checked = item.isChecked,
                    onCheckedChange = onSwitchChanged
                )
                Button(
                    onClick = onBtnClick,
                    shape = RoundedCornerShape(20.dp),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Text(
                        text = stringResource(R.string.btn_aksi),
                        fontSize = 11.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemRowPreview() {
    ItemRow(
        item = ItemModel(1, "Sample Title", "Sample Description", false),
        onSwitchChanged = {},
        onBtnClick = {},
        onItemClick = {}
    )
}