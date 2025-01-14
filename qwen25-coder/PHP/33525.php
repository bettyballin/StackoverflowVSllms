<?php\n$host = 'your_host';\n$db = 'your_database';\n$user = 'your_username';\n$pass = 'your_password';\n\n// Create PDO connection\ntry {\n    $pdo = new PDO("mysql:host=$host;dbname=$db", $user, $pass);\n    // Set the PDO error mode to exception\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n} catch (PDOException $e) {\n    die("Could not connect to the database: " . $e->getMessage());\n}\n\n$url = 'http://example.com'; // The URL you want to check for duplicates\n\n// Prepare a SELECT statement\n$stmt = $pdo->prepare("SELECT COUNT(*) FROM your_table WHERE url = :url");\n// Bind parameters to statement variables\n$stmt->bindParam(':url', $url, PDO::PARAM_STR);\n// Execute the prepared statement\n$stmt->execute();\n// Fetch the result\n$count = $stmt->fetchColumn();\n\nif ($count > 0) {\n    echo "URL already exists.";\n} else {\n    // URL does not exist, proceed to insert it if necessary\n    echo "URL is unique.";\n}\n?>