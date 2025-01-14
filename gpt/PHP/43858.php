try {\n    // Code that may throw an exception\n    $db = new PDO('mysql:host=localhost;dbname=test', 'username', 'password');\n    // Additional code...\n} catch (PDOException $e) {\n    // Log the error message\n    error_log($e->getMessage());\n    // Display a generic error message to the user\n    echo "An error occurred while connecting to the database. Please try again later.";\n}