package com.example.lyceum_saturday10_2025.features.goodsdetails

import android.widget.Space
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.Card
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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
@Destination
//@Destination(style = DestinationStyle.Dialog::class)
fun GoodsDetails(goodsCurrent: GoodsItem) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card (
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)   // Outer padding
                .heightIn(50.dp, 600.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
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