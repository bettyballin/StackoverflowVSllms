$regName = $_GET['regName'];\n$host = "127.0.0.1";\n$port = 13000;\n\n$socket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);\nif ($socket === false) {\n    die("Failed to create socket: " . socket_strerror(socket_last_error()));\n}\n\n$result = socket_connect($socket, $host, $port);\nif ($result === false) {\n    die("Failed to connect: " . socket_strerror(socket_last_error($socket)));\n}\n\nsocket_write($socket, $regName, strlen($regName));\n\n$response = '';\nwhile ($out = socket_read($socket, 2048)) {\n    $response .= $out;\n}\n\nsocket_close($socket);\n\necho $response;