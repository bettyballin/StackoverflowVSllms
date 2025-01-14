<?php\n// Assuming $pdo is your PDO instance and $name contains the user input\n$name = "%$name%;"; // Add wildcards to the variable\n\n$stmt = $pdo->prepare("SELECT * FROM table WHERE name LIKE ?");\n$stmt->execute([$name]);\n\n$results = $stmt->fetchAll();\n?>