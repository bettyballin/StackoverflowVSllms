$currentTimestamp = time();\n$oneWeekAgoUnix = $currentTimestamp - (7 * 24 * 60 * 60);\n\n// Assuming sqlToUnix($date) converts a MySQL datetime string to Unix timestamp\n$formattedDateString = date('Y-m-d H:i:s', $oneWeekAgoUnix);\n\n$query = "SELECT id FROM entries WHERE UNIX_TIMESTAMP(entries.date) >= UNIX_TIMESTAMP('$formattedDateString')";