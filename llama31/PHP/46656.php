if (!headers_sent()) {\n    header('Content-Security-Policy: default-src \'self\';');\n    header('X-Frame-Options: DENY');\n    header('X-Content-Type-Options: nosniff');\n}