<?php\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "database";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\n// Check connection\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Function to get menu item by ID\nfunction getMenuItem($id, $conn) {\n    $sql = "SELECT id, title, parent_id FROM menu_items WHERE id = $id";\n    $result = $conn->query($sql);\n    return $result->fetch_assoc();\n}\n\n// Recursive function to build URL path\nfunction buildUrlPath($id, $conn) {\n    $item = getMenuItem($id, $conn);\n    if ($item['parent_id'] != 0) {\n        return buildUrlPath($item['parent_id'], $conn) . '/' . $item['title'];\n    } else {\n        return $item['title'];\n    }\n}\n\n// Example: Building URL for a specific menu item ID\n$menuItemId = 3; // Change this to the ID you want to build the URL for\n$urlPath = buildUrlPath($menuItemId, $conn);\necho '/' . $urlPath;\n\n$conn->close();\n?>