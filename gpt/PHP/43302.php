$ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, "https://api.example.com");\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\n    curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, true);\n    curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 2);\n    $output = curl_exec($ch);\n    curl_close($ch);