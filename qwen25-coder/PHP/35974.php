<?php\n\nfunction get_website_content($url) {\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, $url);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\n    // To include headers in the output set to true otherwise false.\n    curl_setopt($ch, CURLOPT_HEADER, false);\n\n    $output = curl_exec($ch);\n    if(curl_errno($ch)) {\n        echo 'error:' . curl_error($ch);\n    }\n    curl_close($ch);\n\n    return $output;\n}\n\n$url = "http://example.com"; // Replace with the URL you want to access\n$content = get_website_content($url);\necho htmlspecialchars($content); // Always sanitize outputs\n\n?>