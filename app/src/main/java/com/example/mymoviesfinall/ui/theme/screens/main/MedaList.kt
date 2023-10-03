package com.example.mymoviesfinall.ui.theme.screens.main

import android.icu.text.CaseMap.Title
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SliderDefaults.Thumb
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.mymoviesfinall.R
import com.example.mymoviesfinall.model.MediaItem
import com.example.mymoviesfinall.model.getMedia
import com.example.mymoviesfinall.ui.theme.MyMoviesApp

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalCoilApi::class)
@Composable
fun MediaList(navController: NavHostController, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_wedith)),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        modifier = modifier
    ) {
        items(getMedia()) {
            MediaListItem(
                mediaItem = it,
                navController,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalCoilApi
@Composable
fun MediaListItem(
    mediaItem: MediaItem,
    navController: NavHostController,
    modifier: Modifier = Modifier
)   {
    Column(
        modifier = modifier
            .clickable { navController.navigate("detail") }
    ) {
        Thumb(mediaItem)
        Title(mediaItem)
    }

}

@Composable
private fun Thumb(mediaItem: MediaItem){
    Box(modifier = Modifier
        .height(dimensionResource(R.dimen.cell_min_wedith))
        .fillMaxWidth()
    ){
        Image(painter = rememberImagePainter(
            data = mediaItem.thumb
        ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        if (mediaItem.type == MediaItem.Type.VIDEO){
            Icon(
                Icons.Default.PlayCircleOutline,
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.cell_play_icon_size))
                    .align(Alignment.Center),
                tint = Color.White
            )
        }
    }
}
@Composable
private fun Title(mediaItem: MediaItem){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(dimensionResource(R.dimen.padding_medium))
    ){
        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}


@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun MediaListPreview() {
    MyMoviesApp {
        val mediaItem = MediaItem(1, "Item 1", "", MediaItem.Type.VIDEO)
                //  MediaListItem(mediaItem = mediaItem, navController = navCotroller)
    }

}