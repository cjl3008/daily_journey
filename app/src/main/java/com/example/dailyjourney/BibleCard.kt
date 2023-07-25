package com.example.dailyjourney

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailyjourney.model.BibleInfo
import com.example.dailyjourney.ui.theme.DailyJourneyTheme

/**
 * Composable that displays a list item containing daily Bible verses
 *
 * @param bibleInfo contains the data that populated the list item
*/
@Composable
fun BibleCard(bibleInfo: BibleInfo, modifier: Modifier = Modifier){
    var expanded by remember { mutableStateOf(false) }
    val animateColor by animateColorAsState(
        targetValue = if(!expanded) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.onSecondary,
        animationSpec = tween(1000)
    )

    Card(modifier = modifier) {
        Column(modifier = Modifier
            .animateContentSize(animationSpec = spring(stiffness = Spring.StiffnessHigh))
            .background(color = animateColor)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = dimensionResource(R.dimen.pad_medium)),
                verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = LocalContext.current.getString(bibleInfo.day),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.label_large))
                        .alignByBaseline(),
                    style = MaterialTheme.typography.displayLarge
                )
                AnimatedVisibility(visible = expanded) {
                    Text(
                        text = LocalContext.current.getString(bibleInfo.verse),
                        modifier = Modifier.alignByBaseline(),
                        style = MaterialTheme.typography.displayMedium
                    )
                }
                Spacer(modifier.weight(1f))
                CardExpander(
                    expanded = expanded,
                    onCLick = { expanded = !expanded }
                )
            }
            if(expanded){
                Column(modifier = Modifier.padding(
                    start = dimensionResource(R.dimen.pad_medium),
                    top = dimensionResource(R.dimen.pad_micro),
                    end = dimensionResource(R.dimen.pad_medium),
                    bottom = dimensionResource(R.dimen.pad_small)
                )){
                    Image(
                        painter = painterResource(bibleInfo.image),
                        contentDescription = null
                    )
                    Text(
                        text = LocalContext.current.getString(bibleInfo.text),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

/**
 * Button to expand/hide part of the Bible card
 *
 * @param expanded Boolean value to change the button display
 * @param onCLick called when this button is clicked
 */
@Composable
private fun CardExpander(expanded: Boolean, onCLick: () -> Unit){
    IconButton(onClick = onCLick) {
        Icon(
            imageVector = if(!expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = LocalContext.current.getString(R.string.expand_more_less),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
private fun BibleCardPreview(){
    DailyJourneyTheme {
        Surface {
            BibleCard(BibleInfo(R.string.day1, R.string.verse1, R.drawable.im_1, R.string.text1))
        }
    }
}