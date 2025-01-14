<?php\n// Assume $dbConnection is your PDO/MySQLi connection object\nfunction verifySecurityQuestion($userId, $userInput) {\n    // Fetch the hashed security answer from the database\n    $stmt = $dbConnection->prepare("SELECT `security_answer_hash` FROM `users` WHERE `id` = ?");\n    $stmt->execute([$userId]);\n    $row = $stmt->fetch(PDO::FETCH_ASSOC);\n    \n    if (!$row) {\n        return false;\n    }\n    \n    // Use bcrypt or a similar method to verify the hash\n    return password_verify($userInput, $row['security_answer_hash']);\n}\n\nfunction createPasswordResetToken($userId) {\n    $token = bin2hex(random_bytes(32));  // Generate a secure random token\n    $expirationTime = time() + 1800;     // Token expires in 30 minutes\n    \n    $stmt = $dbConnection->prepare("INSERT INTO `password_reset_tokens` (`user_id`, `token`, `expires_at`) VALUES (?, ?, ?)");\n    $stmt->execute([$userId, $token, date('Y-m-d H:i:s', $expirationTime)]);\n    \n    return $token;\n}\n\n// Example usage\n$userId = 123; // replace with actual user id\n$userInput = '987654321'; // replace with actual user input\n\nif (verifySecurityQuestion($userId, $userInput)) {\n    $resetToken = createPasswordResetToken($userId);\n    // Send the token to the user via a secure alternative communication channel\n} else {\n    echo "Invalid security information provided.";\n}\n?>