<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $name = filter_var(trim($_POST['name']), FILTER_SANITIZE_STRING);\n    $email = filter_var(trim($_POST['email']), FILTER_VALIDATE_EMAIL);\n    $subject = filter_var(trim($_POST['subject']), FILTER_SANITIZE_STRING);\n    $body = filter_var(trim($_POST['body']), FILTER_SANITIZE_STRING);\n\n    if ($email) {\n        $to = 'your-email@example.com';\n        $headers = "From: $name <$email>" . "\r\n" .\n                   "Reply-To: $email" . "\r\n" .\n                   'X-Mailer: PHP/' . phpversion();\n\n        mail($to, $subject, $body, $headers);\n        echo "Email sent successfully!";\n    } else {\n        echo "Invalid email address.";\n    }\n}\n?>