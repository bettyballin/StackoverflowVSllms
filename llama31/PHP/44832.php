if (curl_errno($ch)) {\n    echo 'cURL error: ' . curl_error($ch);\n    exit;\n}