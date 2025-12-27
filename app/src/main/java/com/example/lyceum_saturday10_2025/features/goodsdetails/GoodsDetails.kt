package com.example.lyceum_saturday10_2025.features.goodsdetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.lyceum_saturday10_2025.features.goods.presentation.model.GoodsItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
@Destination
fun GoodsDetails(navigator: DestinationsNavigator, goodsCurrent: GoodsItem) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .heightIn(50.dp, 600.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                // Кнопка назад
                IconButton(
                    onClick = { navigator.navigateUp() },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Назад"
                    )
                }

                Spacer(modifier = Modifier.padding(top = 10.dp))

                GlideImage(
                    model = goodsCurrent.imageURL,
                    contentScale = ContentScale.FillWidth,
                    contentDescription = null
                )

                Spacer(modifier = Modifier.padding(top = 10.dp))

                Text("Название: ${goodsCurrent.name}", fontWeight = FontWeight.ExtraBold)

                Text("Рейтинг: ${goodsCurrent.rating} / 5", fontStyle = FontStyle.Italic)

                Text("Описание: ${goodsCurrent.description}", fontStyle = FontStyle.Italic)
            }
        }
    }
}