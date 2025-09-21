package com.example.healthconnectsample.presentation.component

import androidx.annotation.StringRes
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.healthconnectsample.R
import com.example.healthconnectsample.presentation.theme.HealthConnectTheme
import java.time.Instant
import java.time.temporal.ChronoUnit

fun LazyListScope.sessionDetailsItem(
    @StringRes labelId: Int,
    content: @Composable () -> Unit
) {
    item {
        Text(
            text = stringResource(id = labelId),
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.primary
        )
        content()
    }
}

@Preview
@Composable
fun SessionDetailsItemPreview_DomainViolations() {
    HealthConnectTheme {
        LazyColumn {
            //  Negative steps
            sessionDetailsItem(R.string.total_steps) {
                Text(text = "-500 steps")
            }

            //  Future timestamp
            sessionDetailsItem(R.string.total_steps) {
                val futureDate = Instant.now().plus(30, ChronoUnit.DAYS).toString()
                Text(text = "Next Checkup: $futureDate")
            }

            //  Unencrypted patient data
            sessionDetailsItem(R.string.total_steps) {
                Text(text = "PatientData: John Doe")
            }
        }
    }
}
