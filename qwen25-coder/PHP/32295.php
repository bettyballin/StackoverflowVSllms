// Hashing a password\n$passwordHash = password_hash($userPassword, PASSWORD_BCRYPT);\n\n// Verifying a password\n$isPasswordValid = password_verify($userInputPassword, $passwordHash);