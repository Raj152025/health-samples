// ExerciseSessionDetailsItem.kt

package com.example.healthconnectsample.presentation.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ExerciseSessionDetailsItem() {
    // ❌ Domain violation 1: unencrypted patient data reference
    Text(text = "PatientData: John Doe")

    // ❌ Domain violation 2: negative steps literal
    Text(text = "-10 steps")

    // ❌ Domain violation 3: future timestamp literal
    Text(text = "Timestamp: 2099-12-31T23:59:59Z")
}
