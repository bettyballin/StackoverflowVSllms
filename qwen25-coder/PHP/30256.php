<?php\n// Simple GET request to Python domain logic service\n$apiUrl = "http://example.com/api/finance/report";\n$response = file_get_contents($apiUrl);\n$data = json_decode($response, true);\n\necho $data['report'];\n?>