// Pseudocode for application startup logic\n   bool shouldStart = false;\n\n   if (registryKeyExists(HKLM, "YourAppName")) {\n       shouldStart = true;\n   }\n\n   if (registryKeyExists(HKCU, "YourAppName") && registryKeyValue(HKCU, "YourAppName") == "disabled") {\n       shouldStart = false;\n   }\n\n   if (shouldStart) {\n       // Run application logic\n   }