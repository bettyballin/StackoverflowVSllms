// Retrieving the stored hashed password from the database\n$storedHashedPassword = /* fetch from database */;\n\nif (password_verify($password, $storedHashedPassword)) {\n    // Password is correct\n} else {\n    // Password is incorrect\n}