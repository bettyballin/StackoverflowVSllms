<?php\n\nfunction getEnvironment() {\n    // Detect environment based on the hostname\n    $host = $_SERVER['HTTP_HOST'];\n    return strpos($host, 'localhost') === 0 ? 'development' : 'production';\n}\n\nfunction assetPath($path) {\n    $environment = getEnvironment();\n    if ($environment === 'production') {\n        // Adjust paths for production with subdomains\n        if (strpos($path, '/css/') !== false || strpos($path, '/js/') !== false || strpos($path, '/images/') !== false) {\n            $subdomain = strpos($path, '/images/') !== false ? 'images.' : 'static.';\n            return "http://{$subdomain}mysitename.com/" . basename($path);\n        }\n    }\n    // Use local paths for development\n    return "http://localhost/mysitename/{$path}";\n}\n\n// Usage example\necho '<link rel="stylesheet" type="text/css" href="' . assetPath('assets/css/style.css') . '"/>';\necho '<img src="' . assetPath('assets/images/img1.gif') . '" alt="Image">';\n?>