function generateActivationKey($length = 32) {\n    // Generate a cryptographically secure pseudo-random bytes\n    if (function_exists('random_bytes')) {\n        $bytes = random_bytes($length);\n    } else {\n        // Fallback for older versions of PHP without random_bytes()\n        $bytes = openssl_random_pseudo_bytes($length, $cryptoStrong);\n        if (!$cryptoStrong) {\n            throw new Exception('Could not generate secure random bytes.');\n        }\n    }\n\n    // Convert the binary data to hexadecimal representation\n    return bin2hex($bytes);\n}\n\n// Usage\n$activationKey = generateActivationKey();\necho "www.domain.com/activate.php?key=" . $activationKey;