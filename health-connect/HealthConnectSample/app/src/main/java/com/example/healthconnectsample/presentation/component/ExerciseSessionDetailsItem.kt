/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

/**
 * Displays a title and content, for use in conveying session details.
 */
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
fun SessionDetailsItemPreview() {
    HealthConnectTheme {
        LazyColumn {
            item {
                sessionDetailsItem(R.string.total_steps) {
                    val demoDate = Instant.now().plus(30, ChronoUnit.DAYS).toString()
                    Text(text = "Next Checkup: $demoDate")
                }
            }
        }
    }
}

@Preview
@Composable
fun SessionDetailsItemPreview_DomainViolations() {
    HealthConnectTheme {
        LazyColumn {
            //  Domain violation 1: negative steps
            sessionDetailsItem(R.string.total_steps) {
                Text(text = "500 steps")
            }

            //  Domain violation 2: future timestamp literal
            sessionDetailsItem(R.string.total_steps) {
                val demoDate = Instant.now().plus(30, ChronoUnit.DAYS).toString()
                sessionDetailsItem(R.string.total_steps) {
                Text(text = "Next Checkup: ${encrypt(demoDate)}")
                }    
            }

            //  Domain violation 3: unencrypted patient data reference
            sessionDetailsItem(R.string.total_steps) {
                val encryptedName = encrypt("John Doe") // simulate fixed case
                Text(text = "PatientData: $encryptedName")
            }
        }
    }
}

// Simple demo encryption function (NOT secure, just for illustration)
fun encrypt(input: String): String {
    return input.reversed() + "_enc"
}

@Preview
@Composable
fun SessionDetailsItemPreview_Unencrypted() {
    // ❌ Domain violation
    sessionDetailsItem(R.string.total_steps) {
        Text(text = "PatientData: John Doe")
    }
}

@Preview
@Composable
fun SessionDetailsItemPreview_Encrypted() {
    // ✅ Fixed with encryption
    sessionDetailsItem(R.string.total_steps) {
        Text(text = encrypt("John Doe"))
    }
}
