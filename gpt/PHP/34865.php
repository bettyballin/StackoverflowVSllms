<?php\n$dsn = 'mysql:host=localhost;dbname=database_name';\n$username = 'abc';\n$password = 'xyz';\n$options = [\n    PDO::ATTR_PERSISTENT => true,\n    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION\n];\n\ntry {\n    $pdo = new PDO($dsn, $username, $password, $options);\n} catch (PDOException $e) {\n    die('Connection failed: ' . $e->getMessage());\n}\n\n// Your database operations go here\n\n// Close the connection when done (optional with persistent connections)\n$pdo = null;\n?>