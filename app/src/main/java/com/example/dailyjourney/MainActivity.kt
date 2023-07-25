package com.example.dailyjourney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dailyjourney.model.BibleRepo
import com.example.dailyjourney.ui.theme.DailyJourneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyJourneyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DailyJourney()
                }
            }
        }
    }
}

/**
 * Composable that displays a list of Bible verses for 30 days
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DailyJourney(){
    Scaffold(topBar = { TopBar() }) { paddingValues ->
        LazyColumn(contentPadding = paddingValues) {
            items(BibleRepo.list) {item ->
                BibleCard(
                    bibleInfo = item,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.pad_micro),
                        bottom = dimensionResource(R.dimen.pad_small),
                        end = dimensionResource(R.dimen.pad_micro)
                    )
                )
            }
        }
    }
}

/**
 * Top app bar display the app name and logo
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.Bottom) {
                Image(
                    painter = painterResource(R.drawable.leaves_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = dimensionResource(R.dimen.pad_medium))
                        .size(dimensionResource(R.dimen.logo))
                )
                Text(
                    text = LocalContext.current.getString(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier.padding(bottom = dimensionResource(R.dimen.pad_micro))
    )
}

@Preview(showBackground = true)
@Composable
fun DailyJourneyPreview() {
    DailyJourneyTheme {
        Surface {
            DailyJourney()
        }
    }
}