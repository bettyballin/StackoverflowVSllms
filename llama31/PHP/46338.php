$json = file_get_contents('data.json');\n$data = json_decode($json, true);\nprint_r($data);