function detectProxy() {\n    $proxyHeaders = array(\n        'HTTP_VIA',\n        'HTTP_X_FORWARDED_FOR',\n        'HTTP_FORWARDED_FOR',\n        'HTTP_X_FORWARDED',\n        'HTTP_FORWARDED',\n        'HTTP_CLIENT_IP',\n        'HTTP_FORWARDED_FOR_IP',\n        'VIA',\n        'X_FORWARDED_FOR'\n    );\n\n    foreach($proxyHeaders as $header) {\n        if (isset($_SERVER[$header])) {\n            return true; // Proxy detected\n        }\n    }\n\n    return false; // No proxy found\n}\n\nif (detectProxy()) {\n    echo "Proxy detected!";\n} else {\n    echo "No proxy detected.";\n}