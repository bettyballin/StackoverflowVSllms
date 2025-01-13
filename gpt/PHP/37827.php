function performCurlRequest($url, $data) {\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, $url);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n    curl_setopt($ch, CURLOPT_POST, true);\n    curl_setopt($ch, CURLOPT_POSTFIELDS, $data);\n    curl_setopt($ch, CURLOPT_HTTPHEADER, array(\n        'Connection: keep-alive',\n        'Keep-Alive: timeout=5, max=1000'\n    ));\n    curl_setopt($ch, CURLOPT_HTTP_VERSION, CURL_HTTP_VERSION_1_1);\n\n    $response = curl_exec($ch);\n\n    if (curl_errno($ch)) {\n        echo 'Curl error: ' . curl_error($ch);\n        // Implement retry logic here if needed\n    }\n\n    curl_close($ch);\n\n    return $response;\n}\n\n// Example usage\n$url = "http://your-solr-server/solr/update";\n$data = json_encode(array(/* your data here */));\n\n$response = performCurlRequest($url, $data);