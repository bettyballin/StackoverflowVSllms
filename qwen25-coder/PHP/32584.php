// Original XML time string\n$xmlTimeString = '2023-10-05T15:30:00';\n\n// Create a timestamp from the XML time string\n$timestamp = strtotime($xmlTimeString);\n\n// Subtract 5 hours by subtracting 18000 seconds\n$adjustedTimestamp = $timestamp - 18000;\n\n// Alternatively, use a relative format string with strtotime\n$correctedTimestamp = strtotime('-5 hours', $timestamp);\n\n// Output the adjusted times\necho date('Y-m-d H:i:s', $adjustedTimestamp) . "\n";\necho date('Y-m-d H:i:s', $correctedTimestamp) . "\n";