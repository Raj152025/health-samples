Here’s the **Markdown heatmap template** you should paste into:

```markdown
# Healthcare Compliance Heatmap — health-samples

| Standard | Category       | Requirement / Control               | Status    | Score | Risk  | Owner       | Remediation Action                                      | Target Date | Evidence |
|----------|----------------|-------------------------------------|-----------|-------|-------|-------------|----------------------------------------------------------|-------------|----------|
| HIPAA    | Data Privacy   | Access logging for PHI              | Partial   | 3     | High  | Platform SRE | Enable forensic logging for all EHR endpoints; forward logs to SIEM | 2025-10-31 | docs/runbooks/logging.md |
| GDPR     | Data Privacy   | Patient consent before data sharing | Compliant | 5     | Low   | PM Team      | Annual consent review with legal                          | 2025-12-15 | docs/policies/privacy.md |
| ISO27001 | Security       | InfoSec controls in place           | Partial   | 3     | Medium| Security     | Gap analysis and remediation                              | 2025-11-30 | audits/iso27001-gap.md |
| JCI      | Patient Safety | Medication error reporting          | Non-compliant | 1  | High  | Clinical Ops | Implement incident reporting workflow                     | 2025-12-31 | docs/process/safety.md |
| CMS CoP  | Billing        | Correct ICD-10 coding               | Compliant | 5     | Low   | Finance      | Continuous audit                                         | Ongoing     | audits/billing-icd10.md |
| FDA      | Devices/Trials | Medical device cybersecurity        | Partial   | 2     | High  | Eng Team     | Apply FDA premarket cybersecurity guidance               | 2026-01-31 | docs/device/security.md |
```

👉 Save this file as `docs/compliance/healthcare-compliance-heatmap-health-samples-20250917.md` inside your repo branch.

