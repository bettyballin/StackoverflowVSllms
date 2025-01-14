<?php\n$host = "127.0.0.1";\n$portListen = 1234;\n$portSend = 1240;\n\n// Initialize sender socket\n$sSender = socket_create(AF_INET, SOCK_STREAM, 0);\nif ($sSender === false) {\n    die("socket_create() failed: reason: " . socket_strerror(socket_last_error()) . "\n");\n}\n\n// Connect to the server on $portListen and send data\nif (!socket_connect($sSender, $host, $portListen)) {\n    die("socket_connect() failed.\nReason: ($result) " . socket_strerror(socket_last_error($sSender)) . "\n");\n}\nsocket_write($sSender, "test", strlen("test"));\n\n// Initialize listener socket\n$sListen = socket_create(AF_INET, SOCK_STREAM, 0);\nif ($sListen === false) {\n    die("socket_create() failed: reason: " . socket_strerror(socket_last_error()) . "\n");\n}\n\n// Allow port re-use and bind to it\nsocket_set_option($sListen, SOL_SOCKET, SO_REUSEADDR, 1);\nif (!socket_bind($sListen, $host, $portSend)) {\n    die("socket_bind() failed.\nReason: ($result) " . socket_strerror(socket_last_error($sListen)) . "\n");\n}\n\n// Listen for incoming connections\nif (!socket_listen($sListen, 1)) {\n    die("socket_listen() failed.\nReason: ($result) " . socket_strerror(socket_last_error($sListen)) . "\n");\n}\n\n// Accept a connection and read data\n$dataSock = socket_accept($sListen);\nif ($dataSock === false) {\n    die("socket_accept() failed: reason: " . socket_strerror(socket_last_error($sListen)) . "\n");\n}\necho socket_read($dataSock, 3, PHP_NORMAL_READ);\n\n// Close the accepted connection\nsocket_close($dataSock);\n\n// Now you can safely close the sender and listener sockets\nsocket_shutdown($sSender, 2); // shutdown read/write\nsocket_close($sSender);\nsocket_close($sListen);\n\n?>