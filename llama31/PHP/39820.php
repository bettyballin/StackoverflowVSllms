$sock = socket_create(AF_INET, SOCK_DGRAM, SOL_UDP);\nif ($sock === false) {\n    $errorcode = socket_last_error();\n    $errormsg = socket_strerror($errorcode);\n    die("Couldn't create socket: [$errorcode] $errormsg");\n}\n\nif (!socket_bind($sock, '0.0.0.0', 21000)) {\n    $errorcode = socket_last_error();\n    $errormsg = socket_strerror($errorcode);\n    die("Could not bind socket : [$errorcode] $errormsg");\n}\n\n$message = "Your message";\n$destination = "remote_equipment_ip";\n$port =  remote_equipment_port;\n\nif (!socket_sendto($sock, $message, strlen($message), 0, $destination, $port)) {\n    $errorcode = socket_last_error();\n    $errormsg = socket_strerror($errorcode);\n    die("Could not send data: [$errorcode] $errormsg");\n}\n\nsocket_close($sock);