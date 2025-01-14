<?php\n\nfunction generateEncryptedToken($secretData, $key) {\n    // Generate a random nonce for use in the encryption process.\n    $nonce = random_bytes(SODIUM_CRYPTO_AEAD_AES256GCM_NPUBBYTES);\n\n    // Encrypt the data, using an associated data string of "token" and the generated nonce with your key\n    $encData = sodium_crypto_aead_aes256gcm_encrypt($secretData, 'token', $nonce, $key);\n\n    // Encode the encrypted data and nonce together to a URL-safe base64 format\n    $safeToken = base64_urlencode($nonce . $encData);\n    return $safeToken;\n}\n\nfunction verifyEncryptedToken($safeToken, $key) {\n    try {\n        // Decode the URL-safe base64 encoded token and split it into nonce and encrypted data\n        $decodedData = base64_urldecode($safeToken);\n        if (mb_strlen($decodedData, '8bit') < SODIUM_CRYPTO_AEAD_AES256GCM_NPUBBYTES) {\n            return null;\n        }\n\n        $nonce = mb_substr($decodedData, 0, SODIUM_CRYPTO_AEAD_AES256GCM_NPUBBYTES, '8bit');\n        $encData = mb_substr($decodedData, SODIUM_CRYPTO_AEAD_AES256GCM_NPUBBYTES, null, '8bit');\n\n        // Decrypt the data using the nonce and key\n        $decryptedData = sodium_crypto_aead_aes256gcm_decrypt($encData, 'token', $nonce, $key);\n        return $decryptedData;\n    } catch (SodiumException $e) {\n        return null;\n    }\n}\n\nfunction base64_urlencode($data) { \n  return str_replace(['+', '/'], ['-', '_'], base64_encode($data)).'==='; \n} \n\nfunction base64_urldecode($str) {\n    return base64_decode(str_replace(['-', '_'], ['+', '/'], substr($str,0,-3)));\n}\n\n// Example Usage\n$key = random_bytes(SODIUM_CRYPTO_AEAD_AES256GCM_KEYBYTES); // Generate a secure key\n$tokenData = 'user-id:123'; // Data to encrypt\n\n$encryptedToken = generateEncryptedToken($tokenData, $key);\necho "Your URL could include this token: ?auth=" . $encryptedToken;\n\n// On the server receiving the token...\n$decryptedData = verifyEncryptedToken($_GET['auth'], $key); // Ensure you sanitize input\nif ($decryptedData) {\n    echo "Decrypted data: " . $decryptedData;\n} else {\n    echo "Invalid or tampered token, access denied.";\n}