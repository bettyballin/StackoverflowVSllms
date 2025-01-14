<?php\n// Database connection\n$servername = "your_server";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_database";\n\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Get the current date\n$current_date = date('Y-m-d');\n\n// Calculate the date one week from now\n$next_week_date = date('Y-m-d', strtotime('+1 week'));\n\n// SQL query to get matches within the next week\n$sql = "SELECT * FROM fixtures WHERE DATE BETWEEN '$current_date' AND '$next_week_date' ORDER BY DATE ASC";\n$result = $conn->query($sql);\n\nif ($result->num_rows > 0) {\n    // Output data of each row\n    while($row = $result->fetch_assoc()) {\n        echo "ID: " . $row["ID"]. " - Team Number: " . $row["TEAM NUMBER"]. " - Opposition: " . $row["OPPOSITION"]. " - Venue: " . $row["VENUE"]. " - Date: " . $row["DATE"]. " - Meet Time: " . $row["MEET TIME"]. " - Match Type: " . $row["MATCH TYPE"]. "<br>";\n    }\n} else {\n    echo "No upcoming matches found.";\n}\n\n$conn->close();\n?>