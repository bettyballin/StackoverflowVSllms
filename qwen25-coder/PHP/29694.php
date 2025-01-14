<?php\nheader("Content-Type: text/plain");\n$xmlDoc = new DOMDocument();\nif (!$xmlDoc->load("testrtap11.xml")) {\n    die("Error: Could not load XML file.");\n}\n\n// Establishing a secure connection (MySQLi)\n$mysqli = new mysqli("localhost", "username", "password", "zeeshan_database1");\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$x = $xmlDoc->getElementsByTagName('RECORD');\n\nforeach ($x as $record) {\n    // Extracting values\n    $z = $record->getElementsByTagName('TITLE')->item(0)->nodeValue;\n    $w = $record->getElementsByTagName('PRIMARY_AUTHOR')->item(0)->nodeValue;\n    $y = $record->getElementsByTagName('JOURNAL_CONFERENCE')->item(0)->nodeValue;\n\n    // Preparing SQL statement to prevent SQL injection\n    $stmt = $mysqli->prepare("INSERT INTO Persons (FirstName, LastName, Age) VALUES (?, ?, ?)");\n    if ($stmt === false) {\n        echo "Prepare failed: (" . $mysqli->errno . ") " . $mysqli->error;\n        break;\n    }\n\n    // Binding parameters for markers\n    $stmt->bind_param("sss", $z, $w, $y);\n\n    // Executing the statement\n    if (!$stmt->execute()) {\n        echo "Execute failed: (" . $stmt->errno . ") " . $stmt->error;\n    } else {\n        echo "1 record added\n";\n    }\n\n    // Closing statement\n    $stmt->close();\n}\n\n// Closing connection\n$mysqli->close();\n?>