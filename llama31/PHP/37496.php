$ip = $_SERVER['REMOTE_ADDR'];\n$api_key = 'YOUR_API_KEY';\n$url = "https://api.ip2proxy.com/v1/$ip?key=$api_key";\n$response = json_decode(file_get_contents($url), true);\nif ($response['proxy_type'] != 'NO') {\n    // Proxy detected\n}