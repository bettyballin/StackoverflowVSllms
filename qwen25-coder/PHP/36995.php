$dsn = 'mysql:host=your_host;dbname=your_dbname;charset=utf8mb4';\n$options = [\n    PDO::ATTR_EMULATE_PREPARES => true,\n    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,\n];\n\ntry {\n    $pdo = new PDO($dsn, 'username', 'password', $options);\n} catch (PDOException $e) {\n    echo 'Connection failed: ' . $e->getMessage();\n}\n\n// Example of using a prepared statement with emulated prepares\n$stmt = $pdo->prepare("SELECT foo,bar FROM baz WHERE quux = ? ORDER BY bar LIMIT 1");\n$stmt->execute([$value]);\n$result = $stmt->fetch();