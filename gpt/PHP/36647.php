<?php\n// Assuming you have a PDO connection to your MySQL database\n$pdo = new PDO('mysql:host=your_host;dbname=your_db', 'your_user', 'your_password');\n\n// Convert the IDs to a comma-separated string\n$idString = implode(',', $ids);\n\n// Fetch the records from the database\n$query = $pdo->prepare("SELECT * FROM your_table WHERE id IN ($idString) ORDER BY FIELD(id, $idString)");\n$query->execute();\n$records = $query->fetchAll(PDO::FETCH_ASSOC);\n\n// Display the results\nforeach ($records as $record) {\n    echo "ID: " . $record['id'] . ", Field1: " . $record['field1'] . ", Field2: " . $record['field2'] . "\n";\n}\n?>