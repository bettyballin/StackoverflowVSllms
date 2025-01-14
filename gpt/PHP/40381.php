// Set the timezone for the MySQL connection\n$pdo = new PDO('mysql:host=localhost;dbname=testdb', 'username', 'password');\n$pdo->exec("SET time_zone = '+00:00'"); // Setting to UTC\n\n// Insert a TIMESTAMP value\n$stmt = $pdo->prepare("INSERT INTO events (event_time) VALUES (:event_time)");\n$stmt->execute([':event_time' => date('Y-m-d H:i:s')]);\n\n// Retrieve and display the TIMESTAMP value\n$stmt = $pdo->query("SELECT event_time FROM events");\nwhile ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n    $eventTime = new DateTime($row['event_time'], new DateTimeZone('UTC'));\n    $eventTime->setTimezone(new DateTimeZone('America/New_York')); // Convert to user's timezone\n    echo $eventTime->format('Y-m-d H:i:s');\n}