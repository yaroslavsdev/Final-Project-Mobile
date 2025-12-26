package com.example.lyceum_saturday10_2025.features.goods.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.lyceum_saturday10_2025.features.goods.presentation.model.GoodsItem
import com.example.lyceum_saturday10_2025.R
import com.example.lyceum_saturday10_2025.ui.theme.Lyceum_saturday10_2025Theme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GoodsCard(
    goodsItem: GoodsItem,
    onGoodClicked: (GoodsItem) -> Unit,
) {
    Card(
        onClick = {
            onGoodClicked(goodsItem)
        }
    ) {
        Column {

            // Изображение курса
            GlideImage(
                model = goodsItem.imageURL,
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(60.dp, 180.dp)
            )

            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 0..4) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = if (i < goodsItem.rating) Color.Yellow else Color.Gray
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                // Кнопка удаления товара
                IconButton(
                    onClick = { /* обработка удаления */ }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_delete),
                        contentDescription = "Delete",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }

            // Название товара
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = goodsItem.name,
                fontWeight = FontWeight.Bold
            )

            // Описание товара
            if (goodsItem.description.isNotEmpty()) {
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 16.dp),
                    text = goodsItem.description,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GoodsCardPreview() {
    Lyceum_saturday10_2025Theme {
        GoodsCard(
            goodsItem = GoodsItem(
                name = "Курс по Kotlin",
                rating = 4,
                description = "test description",
                imageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwqIDe967_WBni0OOu5rTIXDKlb7qVCt9qTw&s"
            ),
            onGoodClicked = { _ -> }
        )
    }
}

