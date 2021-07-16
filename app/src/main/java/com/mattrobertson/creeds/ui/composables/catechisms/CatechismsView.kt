package com.mattrobertson.creeds.ui.composables.catechisms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mattrobertson.creeds.data.catechisms.wsc
import com.mattrobertson.creeds.model.catechism.Catechism
import com.mattrobertson.creeds.model.catechism.QuestionAndAnswer
import com.mattrobertson.creeds.ui.DisplaySettings
import com.mattrobertson.creeds.ui.composables.confessions.SliderSpacer
import com.mattrobertson.creeds.ui.theme.AppTheme
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Preview
@Composable
fun CatechismViewPreview() {
    AppTheme {
        CatechismView(catechism = wsc)
    }
}

@Composable
fun CatechismView(
    catechism: Catechism,
    displaySettings: DisplaySettings = DisplaySettings.Default
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(start = 16.dp, end = 16.dp, bottom = 20.dp)
    ) {
        LazyColumn(state = listState) {
            item {
                CatechismTitleSpacer()

                CatechismTitle(
                    text = catechism.title,
                    textStyle = displaySettings.titleStyle
                )

                CatechismTitleSpacer()
            }

            itemsIndexed(catechism.questions) { index, qa ->
                QuestionAndAnswer(index + 1, qa, displaySettings)
                QuestionAndAnswerSpacer()
            }
        }

        SliderSpacer()

        QuestionPickerSlider(
            currentQuestion = listState.firstVisibleItemIndex,
            totalQuestions = catechism.numQuestions,
            onQuestionChange = { question ->
                coroutineScope.launch {
                    listState.scrollToItem(question)
                }
            }
        )
    }
}

@Composable
fun QuestionPickerSlider(
    currentQuestion: Int,
    totalQuestions: Int,
    onQuestionChange: (question: Int) -> Unit
) {
    Slider(
        value = currentQuestion.toFloat(),
        onValueChange = {
            val question = it.roundToInt()
            onQuestionChange(question)
        },
        valueRange = 0f..(totalQuestions.toFloat()),
        steps = totalQuestions + 1
    )
}

@Composable
fun CatechismTitle(
    text: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        color = MaterialTheme.colors.onSurface,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = textStyle
    )
}

@Composable
fun QuestionAndAnswer(
    questionNum: Int,
    questionAndAnswer: QuestionAndAnswer,
    displaySettings: DisplaySettings,
    modifier: Modifier = Modifier
) {
    Question(
        questionNum = questionNum,
        questionText = questionAndAnswer.question,
        textStyle = displaySettings.catechismQuestionStyle
    )

    QuestionSpacer()

    Answer(
        answerText = questionAndAnswer.answer,
        textStyle = displaySettings.bodyStyle
    )
}

@Composable
fun Question(
    questionNum: Int,
    questionText: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Q${questionNum}. $questionText",
        color = MaterialTheme.colors.onSurface,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Left,
        style = textStyle
    )
}

@Composable
fun Answer(
    answerText: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    Text(
        text = answerText,
        color = MaterialTheme.colors.onSurface,
        style = textStyle
    )
}

@Composable
fun CatechismTitleSpacer() {
    Spacer(modifier = Modifier.height(32.dp))
}

@Composable
fun QuestionAndAnswerSpacer() {
    Spacer(modifier = Modifier.height(32.dp))
}

@Composable
fun QuestionSpacer() {
    Spacer(modifier = Modifier.height(4.dp))
}
