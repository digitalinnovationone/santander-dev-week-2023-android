package dio.me.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dio.me.data.mock.Mocks
import dio.me.data.model.News
import dio.me.presentation.theme.SantanderDevWeekTheme
import dio.me.presentation.theme.Spacing_1
import dio.me.presentation.theme.Spacing_2

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewsPagerApp(
    modifier: Modifier = Modifier,
    news: List<News> = emptyList()
) {
    Column(modifier = modifier) {
        val pagerState = rememberPagerState(pageCount = {
            news.size
        })

        HorizontalPager(state = pagerState) { page ->
            NewsItem(news = news[page])
        }
        Indicator(
            count = news.size,
            pageState = pagerState
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Indicator(
    count: Int,
    pageState: PagerState,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = Spacing_1),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(count) { iteration ->
            val color = if (pageState.currentPage == iteration)
                MaterialTheme.colorScheme.primary
            else
                Color.LightGray

            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(Spacing_1)
            )
        }
    }

}

@Composable
fun NewsItem(news: News) {
    AppCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(Spacing_2),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.weight(0.2f),
                imageVector = Icons.Filled.AccessAlarm,
                contentDescription = ""
            )
            Text(
                modifier = Modifier.weight(0.8f),
                text = news.description,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF616161),
                    letterSpacing = 0.14.sp
                )
            )
        }
    }
}

@Preview
@Composable
fun NewsPaperAppPreview() {
    SantanderDevWeekTheme {
        NewsPagerApp(news = Mocks.newsList)
    }
}