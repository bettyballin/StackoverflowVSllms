function getFileContent($url) {\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, $url);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true); // Return the transfer as a string\n    curl_setopt($ch, CURLOPT_HEADER, false);        // Do not include header in output\n\n    $content = curl_exec($ch);\n\n    if (curl_errno($ch)) {\n        echo 'Error:' . curl_error($ch);\n    }\n\n    curl_close($ch);\n    return $content;\n}\n\n$url = "http://example.com";\necho getFileContent($url);