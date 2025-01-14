<?php\nini_set('memory_limit', '256M'); // Adjust memory limit if necessary\nset_time_limit(0); // Prevent script timeout\n\n$mysqli = new mysqli("host", "user", "password", "database");\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$file_handle = fopen('file.csv', 'r');\nif (!$file_handle) {\n    die("Error opening the file.");\n}\n\n$batch = [];\n$max_batch_size = 1000; // Number of rows per batch\n$mysqli->autocommit(FALSE); // Start transaction\n\nwhile (($data = fgetcsv($file_handle, 0, ",")) !== FALSE) {\n    $escaped_data = array_map([$mysqli, 'real_escape_string'], $data);\n    $batch[] = "('" . implode("','", $escaped_data) . "')";\n\n    if (count($batch) >= $max_batch_size) {\n        executeBatchInsert($mysqli, $batch);\n        $batch = []; // Clear batch\n    }\n}\n\nif (!empty($batch)) {\n    executeBatchInsert($mysqli, $batch); // Execute any left over rows\n}\n\n$mysqli->commit(); // Commit transaction\nfclose($file_handle);\n\nfunction executeBatchInsert($mysqli, &$batch) {\n    $query = 'INSERT INTO your_table (column1, column2, column3) VALUES ' . implode(', ', $batch);\n    if (!$mysqli->query($query)) {\n        echo('Error: ' . $mysqli->error);\n    }\n}\n\n$mysqli->close();\n?>