<?php\n// Database connection setup\n$servername = "localhost";\n$username = "username";\n$password = "password";\n$dbname = "database";\n\n$conn = new mysqli($servername, $username, $password, $dbname);\n\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\n// Fetch the data\n$sql = "SELECT * FROM locations ORDER BY parentid, locationid";\n$result = $conn->query($sql);\n\n$locations = [];\nwhile ($row = $result->fetch_assoc()) {\n    $locations[$row['locationid']] = [\n        'name' => $row['name'],\n        'parentid' => $row['parentid']\n    ];\n}\n\n// Function to build the dropdown\nfunction buildDropdown(array $locations, $parentId = 0, $level = 0) {\n    static $i = 1;\n    foreach ($locations as $locationId => $details) {\n        if ($details['parentid'] == $parentId) {\n            echo '<option value="' . htmlspecialchars($locationId) . '">' . str_repeat('--', $level) . htmlspecialchars($details['name']) . '</option>';\n            unset($locations[$locationId]);\n            buildDropdown($locations, $locationId, $level + 1);\n        }\n    }\n}\n\n// Echo the dropdown\necho '<select name="location">';\nbuildDropdown($locations);\necho '</select>';\n\n$conn->close();\n?>