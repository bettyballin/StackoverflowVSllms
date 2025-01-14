try {\n    $dsn = 'mysql:host=your_host;dbname=your_dbname';\n    $username = 'your_username';\n    $password = 'your_password';\n    $options = array(\n        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,\n    );\n\n    $pdo = new PDO($dsn, $username, $password, $options);\n    echo "Connection successful!";\n} catch (PDOException $e) {\n    $errorCode = $e->getCode();\n    switch ($errorCode) {\n        case '08001':\n            echo "Unable to establish SQL connection. Please check the host.";\n            break;\n        case '28000':\n            echo "Invalid authorization. Please check the username and password.";\n            break;\n        case '42000':\n            echo "Syntax error or access violation. Please check your privileges.";\n            break;\n        case '42S02':\n            echo "Database or table not found. Please check the database name.";\n            break;\n        case 'HY000':\n            echo "General error: " . $e->getMessage();\n            break;\n        default:\n            echo "An error occurred: " . $e->getMessage();\n            break;\n    }\n}