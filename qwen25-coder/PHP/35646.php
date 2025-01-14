<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $user_email = filter_var($_POST['user_email'], FILTER_SANITIZE_EMAIL);\n    $user_message = htmlspecialchars(trim($_POST['user_message']));\n\n    // Validate email\n    if (!filter_var($user_email, FILTER_VALIDATE_EMAIL)) {\n        die("Invalid email format");\n    }\n\n    // Set recipient and subject\n    $to = "your-email@example.com"; // Replace with your email\n    $subject = "New Contact Form Submission";\n\n    // Compose message\n    $message = "From: " . $user_email . "\n";\n    $message .= "Message:\n" . $user_message;\n\n    // Send the email\n    if (mail($to, $subject, $message)) {\n        echo "Thank you for your message!";\n    } else {\n        echo "Failed to send email.";\n    }\n} else {\n    die("Access denied");\n}\n?>