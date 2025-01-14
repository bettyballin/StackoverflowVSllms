<?php\nfunction isValidExampleComUrl($url) {\n    // Regular Expression to match URLs specific to example.com and its subdomains\n    return preg_match('/^(?:http:\/\/)?(?:[a-zA-Z0-9-]+\.)?example\.com\/[^\s]*$/', $url);\n}\n\n// Test examples\n$goodUrls = [\n    "http://example.com/so/this/is/good",\n    "http://example.com/so/this/is/good/index.html",\n    "http://www.example.com/so/this/is/good/mice.html#anchortag",\n    "http://anysubdomain.example.com/so/this/is/good/wow.php",\n    "http://anysubdomain.example.com/so/this/is/good/wow.php?search=doozy"\n];\n\n$badUrls = [\n    "http://obviousexample.com",\n    "http://localhost/example.com/whatever/you/get/the/idea"\n];\n\nforeach ($goodUrls as $url) {\n    if (isValidExampleComUrl($url)) {\n        echo "$url is a valid example.com URL.\n";\n    } else {\n        echo "$url is NOT a valid example.com URL.\n";\n    }\n}\n\nforeach ($badUrls as $url) {\n    if (isValidExampleComUrl($url)) {\n        echo "$url is a valid example.com URL.\n";\n    } else {\n        echo "$url is NOT a valid example.com URL.\n";\n    }\n}\n?>