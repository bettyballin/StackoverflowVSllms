<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    // Sanitize and validate form inputs\n    $name = filter_var(trim($_POST['name']), FILTER_SANITIZE_STRING);\n    $email = filter_var(trim($_POST['email']), FILTER_VALIDATE_EMAIL);\n    $message = trim($_POST['message']);\n\n    if (!$name || !$email || !$message) {\n        die("All fields are required.");\n    }\n\n    // Prevent mail header injection\n    if (preg_match("/[\r\n]/", $name) || preg_match("/[\r\n]/", $email)) {\n        die("Invalid input characters detected.");\n    }\n\n    // Send email\n    $to = "your-email@example.com";\n    $subject = "New Message from Contact Form";\n    $headers = "From: noreply@yourdomain.com\r\n" .\n               "Reply-To: $email\r\n" .\n               "X-Mailer: PHP/" . phpversion();\n    \n    if(mail($to, $subject, $message, $headers)) {\n        echo "Thank you for contacting us!";\n    } else {\n        echo "Failed to send email. Please try again later.";\n    }\n}\n?>