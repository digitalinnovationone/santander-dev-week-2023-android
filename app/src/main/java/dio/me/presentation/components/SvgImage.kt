package dio.me.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun SvgImage(url: String, modifier: Modifier = Modifier) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .size(Size.ORIGINAL)
            .decoderFactory(SvgDecoder.Factory())
            .build(),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.primary)
    )
}
