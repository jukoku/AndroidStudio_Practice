package com.example.superhero

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroesRepository.heroes

@Composable
fun SuperHeroApp() {
    Scaffold(
        topBar = { SuperHeroTopAppBar() }
    ) {
        LazyColumn(contentPadding = it) {
            items(heroes){hero ->
                SuperHeroItem(
                    hero = hero,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_medium))
                        .height(dimensionResource(R.dimen.height_size))
                        .clip(MaterialTheme.shapes.medium)
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroTopAppBar(
    modifier: Modifier = Modifier
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier
    )
}

@Composable
fun SuperHeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            SuperHeroInformation(
                hero.nameRes,
                hero.descriptionRes,
                Modifier
                    .padding(end = dimensionResource(R.dimen.padding_medium))
                    .width(dimensionResource(R.dimen.information_width_size))
            )
            SuperHeroIcon(hero.imageRes, hero.descriptionRes)
        }
    }
}

@Composable
fun SuperHeroIcon(
    @DrawableRes superHeroIcon: Int,
    @StringRes superHeroDescription: Int,
    modifier: Modifier = Modifier
    ) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(superHeroIcon),
        contentDescription = stringResource(superHeroDescription)
    )
}

@Composable
fun SuperHeroInformation(
    @StringRes superHeroName: Int,
    @StringRes superHeroDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(superHeroName),
            style = MaterialTheme.typography.displaySmall,
        )
        Text(
            text = stringResource(superHeroDescription),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}