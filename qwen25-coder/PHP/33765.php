<?php\n// Assuming you have a database connection established\n$pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');\n$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n$searchString = "That '70s Show";\n$searchStringEscaped = "%{$searchString}%";\n\n$stmt = $pdo->prepare("SELECT * FROM your_table WHERE column_name LIKE :search");\n$stmt->execute([':search' => $searchStringEscaped]);\n\n$results = $stmt->fetchAll();\nforeach ($results as $row) {\n    // Output and encode for HTML here\n    echo htmlspecialchars($row['column_name']) . "<br>";\n}\n?>