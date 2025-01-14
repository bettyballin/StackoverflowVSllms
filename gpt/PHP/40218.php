<?php\n// Generate a secure random activation key\nfunction generateActivationKey($length = 32) {\n    return bin2hex(random_bytes($length / 2));\n}\n\n// Example usage\n$email = 'user@example.com';\n$activationKey = generateActivationKey();\n\n// Store the activation key in the database\n// Assuming you have a PDO connection $pdo\n$sql = "INSERT INTO users (email, activation_key) VALUES (:email, :activation_key)";\n$stmt = $pdo->prepare($sql);\n$stmt->bindParam(':email', $email);\n$stmt->bindParam(':activation_key', $activationKey);\n$stmt->execute();\n\n// Send the activation email\n$activationLink = "https://www.domain.com/activate.php?key=$activationKey";\n$subject = "Email Confirmation";\n$message = "Please click the following link to activate your account: $activationLink";\n$headers = "From: no-reply@domain.com";\n\nmail($email, $subject, $message, $headers);\n?>