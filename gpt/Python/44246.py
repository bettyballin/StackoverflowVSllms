# settings.py\n\n# Use HTTPS for secure communication\nSECURE_SSL_REDIRECT = True\nSESSION_COOKIE_SECURE = True\nCSRF_COOKIE_SECURE = True\n\n# Use strong security settings for cookies\nSESSION_COOKIE_HTTPONLY = True\nCSRF_COOKIE_HTTPONLY = True\n\n# Enable HSTS (HTTP Strict Transport Security)\nSECURE_HSTS_SECONDS = 3600\nSECURE_HSTS_INCLUDE_SUBDOMAINS = True\nSECURE_HSTS_PRELOAD = True\n\n# X-Content-Type-Options header\nSECURE_CONTENT_TYPE_NOSNIFF = True\n\n# X-Frame-Options header\nX_FRAME_OPTIONS = 'DENY'\n\n# Content Security Policy (CSP)\nCSP_DEFAULT_SRC = ("'self'",)\nCSP_STYLE_SRC = ("'self'", 'https://fonts.googleapis.com')\nCSP_SCRIPT_SRC = ("'self'", 'https://ajax.googleapis.com')