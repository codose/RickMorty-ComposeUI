package com.example.ricknmorty_compose.ui.main.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.ogie.printfultest.model.RickMorty
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage


@ExperimentalMaterialApi
@Composable
fun RickList(
    rickMortys: List<RickMorty>,
    onItemClick: (RickMorty) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(rickMortys) { rickMorty ->
            RickListItem(rickMorty = rickMorty, onItemClick = { onItemClick(rickMorty) })
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun RickListItem(
    rickMorty: RickMorty,
    onItemClick: () -> Unit
) {
    Card(
        modifier = Modifier.height(150.dp),
        shape = RoundedCornerShape(16.dp),
        backgroundColor = MaterialTheme.colors.background,
        onClick = { onItemClick() }
    ) {
        Row {
            CoilImage(
                imageModel = rickMorty.image,
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .weight(0.4f),
                shimmerParams = ShimmerParams(
                    baseColor = MaterialTheme.colors.background,
                    highlightColor = MaterialTheme.colors.onBackground,
                    durationMillis = 350,
                    dropOff = 0.65f,
                    tilt = 20f
                ),
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(0.6f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = rickMorty.name, style = MaterialTheme.typography.h2)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = rickMorty.status, style = MaterialTheme.typography.body2)
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Last Location", style = MaterialTheme.typography.caption)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = rickMorty.location.name, style = MaterialTheme.typography.body2)
            }
        }
    }
}