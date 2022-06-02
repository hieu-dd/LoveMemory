package com.d2b.dev.lovememory.ui.theme

import  androidx.compose.material.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.d2b.dev.lovememory.R

@Composable
fun TopSection(title: String, hasArrowBack: Boolean = false, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (hasArrowBack) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colors.onSurface
            )
        } else {
            Spacer(modifier = Modifier.size(24.dp))
        }
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun TextInput(
    hint: String,
    showError: Boolean = false,
    textError: String = "",
    onTextChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    var isHintDisplay by remember { mutableStateOf(hint.isNotEmpty()) }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            BasicTextField(
                value = text,
                onValueChange = {
                    text = it
                    onTextChange(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(CircleShape)
                    .background(if (!showError) LightBlue else Color.Red)
                    .padding(1.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.surface)
                    .padding(horizontal = 20.dp, vertical = 12.dp)
                    .onFocusChanged {
                        isHintDisplay = !it.isFocused && text.isEmpty()
                    })
            if (isHintDisplay) {
                Text(
                    text = hint,
                    color = DarkGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 12.dp)
                )
            }
        }

        if (showError) {
            Text(
                text = textError.orEmpty(),
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .align(Alignment.Start)
            )
        }
    }
}

@Composable
fun SearchBar(hint: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        BasicTextField(
            value = "",
            onValueChange = {
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colors.surface)
                .padding(1.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(SearchBarBackground)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
//                    isHintDisplay = !it.isFocused && text.isEmpty()
                })
        Text(
            text = hint,
            color = DarkGray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp)
        )
    }
}

@Composable
fun CustomButton(
    text: String = "",
    startIcon: Int? = null,
    endIcon: Int? = null,
    textColor: Color = Color.White,
    modifier: Modifier = Modifier,
    backgroundColor: Color? = null,
    spaceBetween: Boolean = false,
    iconPadding: Dp = 5.dp,
    clickable: () -> Unit
) {

    val _modifier = if (backgroundColor != null) {
        modifier
            .fillMaxWidth()
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable {
                clickable()
            }
            .padding(horizontal = 10.dp, vertical = 14.dp)
    } else {
        modifier
            .fillMaxWidth()
            .clip(CircleShape)
            .background(DarkGray)
            .padding(1.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.surface)
            .clickable { clickable() }
            .padding(horizontal = 10.dp, vertical = 14.dp)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = _modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (spaceBetween) Arrangement.SpaceBetween else Arrangement.SpaceEvenly
        ) {
            if (startIcon != null) {
                Icon(
                    painter = painterResource(id = startIcon), contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = iconPadding)
                        .size(16.dp), tint = MaterialTheme.colors.onSurface
                )
            } else {
                Spacer(modifier = Modifier.size(16.dp))
            }
            Text(
                text = text, color = textColor,
                fontSize = 16.sp,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.Bold,
            )
            if (endIcon != null) {
                Icon(
                    painter = painterResource(id = endIcon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = iconPadding)
                        .size(16.dp),
                    tint = MaterialTheme.colors.onSurface
                )
            } else {
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }
}