$allUsernames = [];\nwhile ($row = fgetcsv($fp)) {\n    $username = $row[0];\n    // Check if the username is already in the associative array\n    if (isset($allUsernames[$username])) continue;\n    // Add the username to the associative array\n    $allUsernames[$username] = true;\n    // process this row\n}