// Example of Unicode-aware string operations in .NET\nstring originalString = "Hello, 🌎!";\nstring normalizedString = originalString.Normalize(NormalizationForm.FormD);\nConsole.WriteLine(normalizedString);