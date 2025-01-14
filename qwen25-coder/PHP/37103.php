// Create (connect to) SQLite database in file named base.sql:\n$pdo = new PDO('mysql:host=127.0.0.1;dbname=name_of_database', 'username', 'password');\n// Set error mode to exception\n$pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n$stmt = $pdo->prepare("SELECT column1, column2 FROM your_table WHERE condition = :condition");\n$stmt->execute([':condition' => 'someValue']);\n\n$data = $stmt->fetchAll(PDO::FETCH_ASSOC);\n\nforeach ($data as $row) {\n    echo $row['column1'] . ' - ' . $row['column2'];\n}