<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $name = sanitize_input($_POST["name"]);\n    $address = sanitize_input($_POST["address"]);\n    $email = sanitize_input($_POST["email"]);\n    $cc = sanitize_input($_POST["cc"]);\n\n    $errors = [];\n\n    // Validate name\n    if (empty($name)) {\n        $errors[] = "Name is required";\n    }\n\n    // Validate address\n    if (empty($address)) {\n        $errors[] = "Address is required";\n    }\n\n    // Validate email\n    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {\n        $errors[] = "Invalid email format";\n    }\n\n    // Validate credit card (basic format validation)\n    if (!preg_match("/^[0-9]{13,16}$/", $cc)) {\n        $errors[] = "Invalid credit card number";\n    }\n\n    if (!empty($errors)) {\n        foreach ($errors as $error) {\n            echo "<p>$error</p>";\n        }\n    } else {\n        // Process the form data\n        echo "<p>Form submitted successfully!</p>";\n    }\n}\n\nfunction sanitize_input($data) {\n    return htmlspecialchars(stripslashes(trim($data)));\n}\n?>