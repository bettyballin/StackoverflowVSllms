// Force www.domain.com to redirect to domain.com\n$preferredDomain = 'https://domain.com';\n\nif (strpos($_SERVER['HTTP_HOST'], 'www.') !== 0) {\n    header('Location: ' . $preferredDomain);\n    exit();\n}