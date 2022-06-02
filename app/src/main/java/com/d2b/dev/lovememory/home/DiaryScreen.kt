package com.d2b.dev.lovememory.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d2b.dev.lovememory.R
import com.d2b.dev.lovememory.ui.theme.IconBoxBackground
import com.d2b.dev.lovememory.ui.theme.SearchBar
import com.d2b.dev.lovememory.ui.theme.SearchBarBackground
import com.d2b.dev.lovememory.ui.theme.White

@Composable
fun DiaryScreen() {
    Image(
        painter = painterResource(id = R.drawable.diary_background), contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(id = R.string.diary),
                fontSize = 26.sp,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.surface
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(30.dp),
                tint = MaterialTheme.colors.surface
            )
            Icon(
                Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                tint = MaterialTheme.colors.surface
            )
        }

        SearchBar(
            hint = "How was your day...",
            modifier = Modifier.padding(top = 30.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .wrapContentSize()
                    .clip(RoundedCornerShape(10.dp))
                    .background(IconBoxBackground)
                    .padding(vertical = 8.dp, horizontal = 12.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_camera), contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = White
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .wrapContentSize()
                    .clip(RoundedCornerShape(10.dp))
                    .background(IconBoxBackground)
                    .padding(vertical = 8.dp, horizontal = 12.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_image), contentDescription = null,
                    modifier = Modifier.size(18.dp)
                        .padding(bottom = 16.dp),
                    tint = White
                )
            }
        }
        DiaryItem()
        DiaryItem()
    }
}

@Composable
fun DiaryItem(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.surface)
            .padding(16.dp)
    ) {
        Row(modifier = modifier.padding(vertical = 16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.boy), contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Fit
            )
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Text("Ban cam thay :D Vui ver =))")
                Text(
                    "21/05/2022",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
        }

        Text(text = "Nhat ky hang ngay", modifier = Modifier.padding(10.dp))
        Text(text = "chill", modifier = Modifier.padding(10.dp))
        Image(
            painter = painterResource(id = R.drawable.diary_background), contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(10.dp))
        )

    }
}
