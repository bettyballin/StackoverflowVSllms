// Using fopen($url)\n$url = 'https://api.example.com/data';\n$fileHandle = @fopen($url, "r");\nif ($fileHandle) {\n    $response = stream_get_contents($fileHandle);\n    fclose($fileHandle);\n    echo $response;\n} else {\n    echo "Failed to open stream.";\n}\n\n// Using cURL\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, "https://api.example.com/data");\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n$response = curl_exec($ch);\n\nif (curl_errno($ch)) {\n    echo 'Error:' . curl_error($ch);\n}\ncurl_close($ch);\necho $response;