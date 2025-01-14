function showCreateForm($errors = [], $postData = []) {\n    // Display the create form, populate with data if POST failed\n    echo '<form method="post" action="/people">';\n    echo 'Name: <input type="text" name="name" value="' . htmlspecialchars($postData['name'] ?? '') . '"><br>';\n    if (!empty($errors)) {\n        echo '<div style="color:red;">' . htmlspecialchars(implode("<br>", $errors)) . '</div>';\n    }\n    echo '<input type="submit" value="Create">';\n    echo '</form>';\n}\n\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    // Validate input\n    $name = trim($_POST['name']);\n    $errors = [];\n    if (empty($name)) {\n        $errors[] = "Name is required.";\n    }\n\n    if (count($errors) > 0) {\n        // Show form with validation errors\n        showCreateForm($errors, $_POST);\n    } else {\n        // Process valid input\n        // ...\n        // Redirect after successful POST\n        header('Location: /people?success=1');\n        exit;\n    }\n} else {\n    // Show empty form on GET\n    showCreateForm();\n}