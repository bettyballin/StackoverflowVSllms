<?php\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    $url = $_POST['url'];\n\n    // Logic to count the click, e.g., updating a database table\n\n    echo "Click counted for: " . htmlspecialchars($url);\n}\n?>