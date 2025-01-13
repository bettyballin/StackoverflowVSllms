<?php\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    // Retrieve the input value\n    $pages = $_POST['pages'];\n\n    // Split the input string by commas\n    $pagesArray = explode(',', $pages);\n\n    // Trim whitespace from each page name\n    $pagesArray = array_map('trim', $pagesArray);\n\n    // Insert each page name into the database\n    foreach ($pagesArray as $page) {\n        // Prepare your SQL insert statement\n        // Assuming a PDO connection\n        $sql = "INSERT INTO POSTS (page_name) VALUES (:page_name)";\n        $stmt = $pdo->prepare($sql);\n        \n        // Bind the parameter and execute the statement\n        $stmt->bindParam(':page_name', $page);\n        $stmt->execute();\n    }\n\n    echo "Pages have been successfully inserted.";\n}\n?>