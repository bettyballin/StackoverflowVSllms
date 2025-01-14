// Database connection\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "database";\n\n$conn = new mysqli($servername, $username, $password, $dbname);\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// SQL statement to retrieve serialized array\n$sql = "SELECT array_column FROM your_table WHERE id = 1";\n$result = $conn->query($sql);\n\nif ($result->num_rows > 0) {\n    $row = $result->fetch_assoc();\n    $serializedArray = $row['array_column'];\n    \n    // Unserialize the array\n    $array2 = unserialize($serializedArray);\n    \n    var_dump($array2); // This should output your original multidimensional array structure.\n} else {\n    echo "0 results";\n}\n$conn->close();