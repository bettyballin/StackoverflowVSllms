<?php\nif(isset($_GET['email'])) {\n    $email = htmlspecialchars($_GET['email']);\n    echo "You are unsubscribing: " . $email;\n    // Add your unsubscribe logic here\n} else {\n    echo "No email provided.";\n}\n?>