<?php\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    $name = htmlspecialchars($_POST['name']);\n    $age = (int) $_POST['age'];\n\n    // Process the data\n    $response = "Name: $name, Age: $age";\n\n    // Return the response\n    echo $response;\n}\n?>