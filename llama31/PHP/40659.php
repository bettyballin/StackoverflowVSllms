function decrypt($encryptedBase64, $key) {\n    $encryptedBytes = base64_decode($encryptedBase64);\n    $ivBytes = str_repeat("\0", 16);\n    $decryptedBytes = mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, $encryptedBytes, MCRYPT_MODE_CBC, $ivBytes);\n    return trim($decryptedBytes);\n}