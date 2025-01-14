<?php\nheader("Content-Type: application/json");\n\n// Database connection details\n$servername = "localhost";\n$username = "your_username";\n$password = "your_password";\n$dbname = "your_db";\n\n$conn = new mysqli($servername, $username, $password, $dbname);\n\nif ($conn->connect_error) {\n    die(json_encode(array("status" => "error", "message" => "Database connection failed")));\n}\n\n// Handle GET request to fetch data\nif ($_SERVER['REQUEST_METHOD'] === 'GET' && isset($_GET['action']) && $_GET['action'] == 'get_data') {\n    $sql = "SELECT column1, column2 FROM your_table";\n    $result = $conn->query($sql);\n    \n    if ($result->num_rows > 0) {\n        $data = array();\n        while ($row = $result->fetch_assoc()) {\n            $data[] = $row;\n        }\n        echo json_encode(array("status" => "success", "data" => $data));\n    } else {\n        echo json_encode(array("status" => "error", "message" => "No data found"));\n    }\n}\n\n// Handle POST request to add data\nif ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['action']) && $_POST['action'] == 'add_data') {\n    $column1_value = $_POST['column1'];\n    $column2_value = $_POST['column2'];\n\n    $stmt = $conn->prepare("INSERT INTO your_table (column1, column2) VALUES (?, ?)");\n    $stmt->bind_param("ss", $column1_value, $column2_value);\n    if ($stmt->execute()) {\n        echo json_encode(array("status" => "success", "message" => "Data added successfully"));\n    } else {\n        echo json_encode(array("status" => "error", "message" => "Error adding data: " . $conn->error));\n    }\n}\n\n$conn->close();\n?>