function loginHash(string $username, string $password): string {\n    // Combine username with password if needed (not usually necessary)\n    $combined = $username . $password;\n    \n    // Hash the combined string using the default bcrypt algorithm\n    return password_hash($combined, PASSWORD_DEFAULT);\n}\n\nfunction verifyLogin(string $username, string $password, string $storedHash): bool {\n    $combined = $username . $password;\n    \n    // Verify the hash\n    return password_verify($combined, $storedHash);\n}