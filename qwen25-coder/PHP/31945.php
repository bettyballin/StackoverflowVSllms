$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, "https://api.example.com/data");\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n$response = curl_exec($ch);\ncurl_close($ch);\n\n$data = json_decode($response, true);\nprint_r($data);