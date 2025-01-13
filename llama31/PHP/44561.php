$postedDate = '2023-03-01'; // Example date\n\n// Convert the date string to a timestamp\n$timestamp = strtotime($postedDate);\n\n// Calculate future dates\n$after7Days = strtotime('+7 days', $timestamp);\n$after15Days = strtotime('+15 days', $timestamp);\n$after1Month = strtotime('+1 month', $timestamp);\n$after2Months = strtotime('+2 months', $timestamp);\n\n// Format the future dates in US format (m/d/Y)\n$formatted7Days = date('m/d/Y', $after7Days);\n$formatted15Days = date('m/d/Y', $after15Days);\n$formatted1Month = date('m/d/Y', $after1Month);\n$formatted2Months = date('m/d/Y', $after2Months);\n\necho "After 7 Days: $formatted7Days\n";\necho "After 15 Days: $formatted15Days\n";\necho "After 1 Month: $formatted1Month\n";\necho "After 2 Months: $formatted2Months\n";