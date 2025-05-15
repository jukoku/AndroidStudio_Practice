package com.example.thirtydays

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.thirtydays.model.Day
import com.example.thirtydays.model.ThirtyDaysRepository.thirtyDays

@Composable
fun ThirtyDaysApp() {
    Scaffold(
        topBar = {
            ThirtyDaysAppTopBar()
        }
    ) {
        LazyColumn(contentPadding = it){
            items(thirtyDays){ day ->
                ThirtyDaysItem(
                    day = day,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .clip(MaterialTheme.shapes.small)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirtyDaysAppTopBar(modifier: Modifier = Modifier){
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displaySmall
            )
        }
    )
}

@Composable
fun ThirtyDaysItem(
    day: Day,
    modifier: Modifier = Modifier
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.primaryContainer
    )
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = color)
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            ThirtyDaysTitle(
                day = day.day,
                title = day.title
            )
            ThirtyDaysImg(
                title = day.title,
                img = day.img,
                modifier = Modifier
                    .height(if (expanded) (dimensionResource(R.dimen.image_size_big)) else (dimensionResource(R.dimen.image_size)))
                    .animateContentSize()
                    .fillMaxWidth()
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) {
                        expanded = !expanded
                    }
            )
            if(expanded){
                ThirtyDaysInformation(
                    description = day.description,
                    modifier = Modifier
                        .padding(top = dimensionResource(R.dimen.padding_small), bottom = dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun ThirtyDaysTitle(
    @StringRes day: Int,
    @StringRes title: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ){
        Text(
            text = stringResource(day),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.padding_small), bottom = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = dimensionResource(R.dimen.padding_small))
        )
    }
}

@Composable
fun ThirtyDaysImg(
    @StringRes title: Int,
    @DrawableRes img: Int,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
    ) {
        Image(
        modifier = modifier
            .fillMaxWidth(),
        painter = painterResource(img),
        contentScale = ContentScale.Crop,
        contentDescription = stringResource(title),
        )
    }
}

@Composable
fun ThirtyDaysInformation(
    @StringRes description: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(description),
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
    )
}