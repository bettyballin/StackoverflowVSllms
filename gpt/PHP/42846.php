<?php\n// Try accessing using localhost\n$response = file_get_contents('http://localhost/python/json/');\nif ($response === FALSE) {\n    echo "Failed to fetch from localhost\n";\n} else {\n    echo "Response from localhost: $response\n";\n}\n\n// Try accessing using server's IP address\n$server_ip = 'YOUR_SERVER_IP'; // Replace with your server's IP address\n$response = file_get_contents("http://$server_ip/python/json/");\nif ($response === FALSE) {\n    echo "Failed to fetch from server IP\n";\n} else {\n    echo "Response from server IP: $response\n";\n}\n?>