<?php\n$host = '127.0.0.1';\n$db   = 'your_database_name';\n$user = 'your_username';\n$pass = 'your_password';\n$charset = 'utf8mb4';\n\n$dsn = "mysql:host=$host;dbname=$db;charset=$charset";\n$options = [\n    PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,\n    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,\n    PDO::ATTR_EMULATE_PREPARES   => false,\n];\ntry {\n     $pdo = new PDO($dsn, $user, $pass, $options);\n} catch (\PDOException $e) {\n     throw new \PDOException($e->getMessage(), (int)$e->getCode());\n}\n?>