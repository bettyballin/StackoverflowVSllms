// Generate CSRF token\n   $csrfToken = bin2hex(random_bytes(32));\n   $_SESSION['csrf_token'] = $csrfToken;