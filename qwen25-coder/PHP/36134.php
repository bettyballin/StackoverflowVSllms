$uuid = uniqid();\n// If you must hash, use a stronger algorithm\n$token = hash('sha256', $uuid);