<?php\n\n// Function to get a database connection using mysqli\nfunction get_db_conn() {\n    $conn = new mysqli($GLOBALS['db_ip'], $GLOBALS['db_user'], $GLOBALS['db_pass'], $GLOBALS['db_name']);\n    \n    if ($conn->connect_error) {\n        die("Connection failed: " . $conn->connect_error);\n    }\n    \n    return $conn;\n}\n\n// Example usage\n$conn = get_db_conn();\n$query = "INSERT INTO users (uid, twname, privacy) VALUES (15400743, 'gdhdh', 'accepted')";\n\nif (!$conn->query($query)) {\n    die("A MySQL error has occurred.<br />Your Query: " . $query . "<br /> Error: (" . $conn->errno . ") " . $conn->error);\n}\n\necho "You have been entered into our Database!";\n\n// Close the connection\n$conn->close();\n?>