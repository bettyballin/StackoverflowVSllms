<?php\n$searchTerms = 'SearchKeywords';\n$searchType = 'SearchTypes';\n$numResults = 'NumberOfResults';\n$location = 'User\'sLocation';\n$curDate = 'CurDate';\n$curTime = 'CurTime';\n\n// Database connection\n$conn = new mysqli('hostname', 'username', 'password', 'database');\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Prepare a select statement to check for duplicates\n$stmt = $conn->prepare("SELECT COUNT(*) FROM DiggerActivity_Searches WHERE SearchTerms = ? AND SearchType = ? AND Date = ? AND Time = ?");\n$stmt->bind_param("ssss", $searchTerms, $searchType, $curDate, $curTime);\n$stmt->execute();\n$stmt->bind_result($count);\n$stmt->fetch();\n$stmt->close();\n\nif ($count == 0) {\n    // Insert only if there are no duplicates\n    $stmt = $conn->prepare("INSERT INTO DiggerActivity_Searches (SearchTerms, SearchType, NumResults, Location, Date, Time) VALUES (?, ?, ?, ?, ?, ?)");\n    $stmt->bind_param("ssssss", $searchTerms, $searchType, $numResults, $location, $curDate, $curTime);\n    $stmt->execute();\n    $stmt->close();\n}\n\n$conn->close();\n?>