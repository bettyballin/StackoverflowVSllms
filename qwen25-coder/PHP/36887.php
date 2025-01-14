<?php\n$key = 'thisismysecurekey'; // Use a secure key for encryption/decryption\n\nfunction encryptData($plainText, $encryptionKey) {\n    $ivSize = mcrypt_get_iv_size(MCRYPT_RIJNDAEL_256, MCRYPT_MODE_CBC);\n    $iv = mcrypt_create_iv($ivSize, MCRYPT_RAND);\n    $encrypted = base64_encode($iv . mcrypt_encrypt(MCRYPT_RIJNDAEL_256, hash('sha256', $encryptionKey, true), $plainText, MCRYPT_MODE_CBC, $iv));\n    return $encrypted;\n}\n\nfunction decryptData($encryptedText, $encryptionKey) {\n    $enc = base64_decode($encryptedText);\n    $ivSize = mcrypt_get_iv_size(MCRYPT_RIJNDAEL_256, MCRYPT_MODE_CBC);\n    $iv = substr($enc, 0, $ivSize);\n    $encryptedTextWithoutIv = substr($enc, $ivSize);\n    $decrypted = mcrypt_decrypt(MCRYPT_RIJNDAEL_256, hash('sha256', $encryptionKey, true), $encryptedTextWithoutIv, MCRYPT_MODE_CBC, $iv);\n    return rtrim($decrypted, "\0");\n}\n\n// Example usage\n$data = ['username' => 'bob', 'email' => 'bob@example.com'];\n$serializedData = serialize($data);\n$encryptedData = encryptData($serializedData, $key);\n\nsetcookie('user_data', $encryptedData, time() + (86400 * 30), "/"); // Cookie expires in 30 days\n\n// Retrieve and decrypt data\nif (isset($_COOKIE['user_data'])) {\n    $decryptedData = decryptData($_COOKIE['user_data'], $key);\n    $userData = unserialize($decryptedData);\n    echo "Welcome back, " . htmlspecialchars($userData['username']);\n}\n?>