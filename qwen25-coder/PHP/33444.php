<?php\n\nrequire 'vendor/autoload.php'; // Assuming Faker is installed via Composer\n\nuse Faker\Factory;\n\n$faker = Factory::create();\n\n// Connect to the database\n$conn = new mysqli('localhost', 'username', 'password', 'database_name');\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\nfunction getColumns($table, $conn) {\n    $columns = [];\n    $result = $conn->query("DESCRIBE `$table`");\n    if ($result) {\n        while ($row = $result->fetch_assoc()) {\n            $columns[$row['Field']] = $row['Type'];\n        }\n    }\n    return $columns;\n}\n\nfunction generateRandomDataForColumn($column, $faker) {\n    if (strpos($column, 'int') !== false) {\n        return rand(0, 1000);\n    } elseif (strpos($column, 'varchar') !== false) {\n        return "'" . $faker->text(rand(5, 50)) . "'";\n    } elseif ($column == 'date' || $column == 'datetime') {\n        return "'" . $faker->dateTimeBetween('-1 year', '+1 year')->format('Y-m-d H:i:s') . "'";\n    } elseif (strpos($column, 'char')) {\n        return "'" . $faker->randomLetter() . "'";\n    }\n    // Add more data types as needed\n    return null;\n}\n\n$table = 'your_table_name';\n$columns = getColumns($table, $conn);\n$dataRows = 10; // Number of rows you want to insert\n\nfor ($i = 0; $i < $dataRows; $i++) {\n    $values = [];\n    foreach ($columns as $column => $type) {\n        array_push($values, generateRandomDataForColumn($type, $faker));\n    }\n    $query = "INSERT INTO `$table` VALUES (" . implode(', ', $values) . ");";\n    if (!$conn->query($query)) {\n        echo "Error inserting data: " . $conn->error;\n    }\n}\n\n$conn->close();\n?>