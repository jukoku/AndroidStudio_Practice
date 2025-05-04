package com.example.bookshelf.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.example.bookshelf.model.BookCover
import java.text.Normalizer
import java.util.regex.Matcher
import java.util.regex.Pattern


@Composable
fun HomeScreen (
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier : Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when(booksUiState){
        is BooksUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is BooksUiState.Success -> BooksGridScreen(
            covers = booksUiState.covers,
            contentPadding = contentPadding,
            modifier = modifier.fillMaxWidth()
        )
        is BooksUiState.Error -> ErrorScreen(retryAction = retryAction, modifier = modifier.fillMaxSize())
    }
}


@Composable
fun BooksGridScreen(
    covers: List<BookCover>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(1000.dp),
        modifier = modifier,
        contentPadding = contentPadding
    ) {
        items(items = covers, key = {cover -> cover.id}) { cover ->
            BookShelfCard(
                cover,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )
        }
    }
}

// HTML 태그 삭제
fun removeTag(string: String?): String? {
    var str = string
    str = Normalizer.normalize(str, Normalizer.Form.NFKC)
    var mat: Matcher

    // script 처리
    val script = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.DOTALL)
    mat = script.matcher(str.toString())
    str = mat.replaceAll("")

    // style 처리
    val style = Pattern.compile("<style[^>]*>.*</style>", Pattern.DOTALL)
    mat = style.matcher(str.toString())
    str = mat.replaceAll("")

    // tag 처리
    val tag = Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>")
    mat = tag.matcher(str.toString())
    str = mat.replaceAll("")

    // end tag 처리
    val endTag = Pattern.compile("<\\w+\\s+[^<]*\\s*>")
    mat = endTag.matcher(str.toString())
    str = mat.replaceAll("")

    // entity ref 처리
    val entity = Pattern.compile("&[^;]+;")
    mat = entity.matcher(str.toString())
    str = mat.replaceAll("")

    // white space 처리
    val whiteSpace = Pattern.compile("\\s\\s+")
    mat = whiteSpace.matcher(str.toString())
    str = mat.replaceAll("")
    return str
}

@Composable
fun BookShelfCard(cover: BookCover, modifier: Modifier = Modifier){
    var authors = ""
    var authorTag = ""
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ){
        Column(
            modifier = modifier
                .padding(vertical = 10.dp)
                .fillMaxWidth()
        ){
            if (cover.volumeInfo.authors!!.isNotEmpty()) {
                if (cover.volumeInfo.authors[0] != ""){
                    cover.volumeInfo.authors.forEach { author -> authors += "$author, " }
                    authorTag = " \n( By. $authors )"
                }
            }
            Text(
                text = if (cover.volumeInfo.title != ""){
                    cover.volumeInfo.title + authorTag
                } else {
                    ""
                },
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current).data(cover.volumeInfo.imageLinks.imgSrc.toString().replace("http", "https"))
                    .crossfade(true).build(),
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = cover.volumeInfo.description,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            removeTag(cover.volumeInfo.description)?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}


