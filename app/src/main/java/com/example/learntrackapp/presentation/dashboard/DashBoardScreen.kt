package com.example.learntrackapp.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.learntrackapp.R
import com.example.learntrackapp.domain.model.Subject
import com.example.learntrackapp.presentation.components.CountCard
import com.example.learntrackapp.presentation.components.SubjectCard

@Composable
fun DashBoardScreen() {

    val subjectList = listOf(
        Subject(
            name = "Tamil",
            goalHours = "20",
            colors = Subject.subjectCardColor[0]
        ),
        Subject(
            name = "English",
            goalHours = "20",
            colors = Subject.subjectCardColor[1]
        ),
        Subject(
            name = "Maths",
            goalHours = "12",
            colors = Subject.subjectCardColor[2]
        ),
        Subject(
            name = "Science",
            goalHours = "10",
            colors = Subject.subjectCardColor[3]
        ),
        Subject(
            name = "Social",
            goalHours = "8",
            colors = Subject.subjectCardColor[4]
        ),
    )


    Scaffold(
        topBar = { DashBoardTopBar() }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                CardViewSection(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                    subjectCount = "20", studiedHours = "14", goalStudiedHours = "18")
            }
            item {
                SubjectCardSection(
                    modifier = Modifier.fillMaxWidth(),
                    subject = subjectList
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashBoardTopBar() {

    CenterAlignedTopAppBar(title = {
        Text(
            text = "LearnTrack",
            style = MaterialTheme.typography.headlineMedium
            )
    })

}


@Composable
private fun CardViewSection(
    modifier: Modifier = Modifier,
    subjectCount : String,
    studiedHours : String,
    goalStudiedHours : String
) {
    
    Row (
        modifier = modifier
    ){
        CountCard(modifier = Modifier.weight(1f),
            headerString = "Subject count", countString = subjectCount)
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(modifier = Modifier.weight(1f),
            headerString = "Studied Hours", countString =  studiedHours)
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(modifier = Modifier.weight(1f),
            headerString = "Goal Study Hours", countString = goalStudiedHours)
    }

}


@Composable
private fun SubjectCardSection(
    modifier: Modifier = Modifier,
    subject : List<Subject>,
    emptyListMessage : String = "You don't have any subjects. \n Click + button to add new subject"
) {

    Column ( modifier = modifier ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = "SUBJECTS",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 10.dp))

            IconButton(onClick = {

            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "SUBJECT" )
            }
        }

        if(subject.isEmpty()){
            Image(modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
                , painter = painterResource(id = R.drawable.st5), contentDescription = "")
            Text(text = emptyListMessage, style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = Color.LightGray,
                modifier = Modifier.fillMaxWidth()
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ) {
            items(subject){ sub->
                SubjectCard(subjectName = sub.name, gradient = sub.colors,
                    onClick = {

                    })
            }
        }
    }
}