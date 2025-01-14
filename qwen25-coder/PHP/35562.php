$stmt = $pdo->prepare("INSERT INTO employees (name, hire_date) VALUES (:name, :hireDate)");\n$name = "John Doe";\n$hireDate = date('Y-m-d'); // Current date\n\n$stmt->bindParam(':name', $name, PDO::PARAM_STR);\n$stmt->bindParam(':hireDate', $hireDate, PDO::PARAM_STR);\n\n$stmt->execute();