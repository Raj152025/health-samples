@Preview
@Composable
fun SessionDetailsItemPreview() {
    HealthConnectTheme {
        LazyColumn {
            sessionDetailsItem(R.string.total_steps) {
                Text(text = "12345")
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
