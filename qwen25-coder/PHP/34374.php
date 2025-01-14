// Path to Kohana core classes (adjust as needed)\nrequire_once 'path/to/your/kohana/classes/database.php';\n\nuse Database\Database;\n\ntry {\n    // Initialize database configuration\n    $config = require 'path/to/your/config/database.php';\n    \n    // Create database instance\n    Database::instance('default', $config['default']);\n    \n    // Now you can use ORM as per Kohana documentation\n} catch (Exception $e) {\n    echo "Error initializing database: ",  $e->getMessage();\n}