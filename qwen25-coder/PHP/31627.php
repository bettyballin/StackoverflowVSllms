<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $userEmail = htmlspecialchars($_POST['email']);\n    $userMessage = htmlspecialchars($_POST['message']);\n\n    $to = "your-email@gmail.com"; // Replace with your email\n    $subject = "New Contact Form Submission";\n    $body = "User Email: $userEmail\n\nMessage:\n$userMessage";\n    $headers = "From: web@example.com"; // Replace with a valid domain address\n\n    if(mail($to, $subject, $body, $headers)) {\n        echo "Thank you for contacting us, we'll get back to you soon!";\n    } else {\n        echo "We encountered an error and could not send your message.";\n    }\n}\n?>