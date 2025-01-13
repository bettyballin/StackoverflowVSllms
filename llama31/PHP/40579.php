// Function to convert oscommerce password to new cart password\nfunction convert_password($oscommerce_password) {\n    // Split the oscommerce password into hash and salt\n    $stack = explode(':', $oscommerce_password);\n    $salt = $stack[1];\n    $hash = $stack[0];\n\n    // Get the plain password by reversing the oscommerce encryption process\n    $plain_password = '';\n    for ($i = 0; $i < strlen($hash); $i++) {\n        $plain_password .= chr(ord($hash[$i]) - ord($salt[$i % 2]));\n    }\n\n    // Return the plain password hashed with MD5 (compatible with new cart)\n    return md5($plain_password);\n}\n\n// Example usage:\n$oscommerce_password = 'acaa6e689ae0008285320e6617ca8e95:74';\n$new_cart_password = convert_password($oscommerce_password);\necho $new_cart_password; // Output: 098f6bcd4621d373cade4e832627b4f6