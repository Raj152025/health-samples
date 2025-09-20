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

// Simple demo encryption function (NOT secure)
fun encrypt(input: String): String = input.reversed() + "_enc"

@Preview
@Composable
fun SessionDetailsItemPreview_Fixes() {
    HealthConnectTheme {
        LazyColumn {
            // ✅ Valid steps
            sessionDetailsItem(R.string.total_steps) {
                Text(text = "500 steps")
            }

            // ✅ Past timestamp, encrypted
            sessionDetailsItem(R.string.total_steps) {
                val safeDate = Instant.now().minus(1, ChronoUnit.DAYS).toString()
                Text(text = "Last Checkup: ${encrypt(safeDate)}")
            }

            // ✅ Encrypted patient data
            sessionDetailsItem(R.string.total_steps) {
                val encryptedName = encrypt("John Doe")
                Text(text = "PatientData: $encryptedName")
            }
        }
    }
}
