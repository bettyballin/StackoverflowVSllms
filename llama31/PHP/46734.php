$formattedDateString = date('Y-m-d H:i:s', sqlToUnix('2023-03-01 00:00:00'));\n$query = "SELECT id FROM entries WHERE entries.date >= '$formattedDateString'";