<?php\nif(isset($_POST['query'])){\n    $query = $_POST['query'];\n    // Database connection and search logic here\n    $servername = "localhost";\n    $username = "user";\n    $password = "pass";\n    $dbname = "myDB";\n\n    $conn = new mysqli($servername, $username, $password, $dbname);\n\n    if ($conn->connect_error) {\n        die("Connection failed: " . $conn->connect_error);\n    }\n\n    // Prepare and bind\n    $stmt = $conn->prepare("SELECT name FROM myTable WHERE name LIKE ?");\n    $searchTerm = "%".$query."%";\n    $stmt->bind_param("s", $searchTerm);\n\n    $stmt->execute();\n    $result = $stmt->get_result();\n\n    if ($result->num_rows > 0) {\n        while($row = $result->fetch_assoc()) {\n            echo $row["name"] . "<br>";\n        }\n    } else {\n        echo "No results";\n    }\n\n    $stmt->close();\n    $conn->close();\n}\n?>