// PHP with MySQL Example: Fetching records from a table\n<?php\nfunction getUsers() {\n    $pdo = new PDO('mysql:host=localhost;dbname=testdb', 'username', 'password');\n    $sql = "SELECT * FROM Users";\n    $stmt = $pdo->query($sql);\n    $users = [];\n\n    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n        $users[] = [\n            'id' => $row['id'],\n            'name' => $row['name']\n        ];\n    }\n\n    return $users;\n}