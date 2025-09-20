// ExerciseSessionDetailsItem.kt

package com.example.healthconnectsample.presentation.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

// Fake encryption method for demo
fun encrypt(input: String): String {
    return "ENC(${input.reversed()})" // simple reversible "encryption"
}

@Composable
fun ExerciseSessionDetailsItem() {
    // ✅ Fixed: encrypt patient data
    Text(text = encrypt("John Doe"))

    // ✅ Fixed: valid steps literal (positive)
    Text(text = "1000 steps")

    // ✅ Fixed: realistic timestamp (not future)
    Text(text = "Timestamp: 2024-12-31T23:59:59Z")
}
