package com.d2b.dev.lovememory.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d2b.dev.lovememory.R
import com.d2b.dev.lovememory.ui.theme.*

@Composable
fun EditScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryBackground)
            .background(
                Brush.verticalGradient(
                    listOf(Color.Transparent, White)
                )
            )
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.wrapContentSize()
        ) {
            Text(
                text = stringResource(id = R.string.days_in_love_title),
                color = White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(vertical = 40.dp)
            )

            DaysInfoSection()
            LoverSection()
        }
    }
}

@Composable
fun DaysInfoSection() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(250.dp)
            .aspectRatio(1f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.heart), contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "13/05/2022",
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(top = 30.dp)
            )
            Text(
                text = "12",
                color = White,
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(vertical = 10.dp)
            )
            Text(
                text = "ngày",
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
        }
    }
}

@Composable
fun LoverSection() {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 20.dp,
                horizontal = 20.dp
            )
    ) {
        LoverInfo("You")
        Image(
            painter = painterResource(id = R.drawable.heart_icon), contentDescription = null,
            modifier = Modifier
                .padding(top = 10.dp)
                .size(50.dp)
        )
        LoverInfo("Her", false)
    }
}


@Composable
fun LoverInfo(name: String = "", isMan: Boolean = true) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.boy), contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
        Text(
            text = name,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .clip(CircleShape)
                .background(if (isMan) Primary else LightBlue)
                .padding(vertical = 3.dp, horizontal = 10.dp)

        ) {
            Image(
                painter = painterResource(id = if (isMan) R.drawable.male else R.drawable.female),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview
@Composable
private fun Review() {
    EditScreen()
}

