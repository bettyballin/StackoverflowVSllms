// Example of input validation in PHP\n  $name = filter_input(INPUT_POST, 'name', FILTER_SANITIZE_STRING);\n  $email = filter_input(INPUT_POST, 'email', FILTER_VALIDATE_EMAIL);\n\n  if (!$email) {\n      echo "Invalid email address.";\n  }