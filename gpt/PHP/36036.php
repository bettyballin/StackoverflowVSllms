<?php\n\n$host = "127.0.0.1";\n$portListen = 1234;\n$portSend = 1240;\n\n// Create socket for sending\n$sSender = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);\nif ($sSender === false) {\n    die("socket_create() failed: " . socket_strerror(socket_last_error()) . "\n");\n}\n\nif (socket_connect($sSender, $host, $portListen) === false) {\n    die("socket_connect() failed: " . socket_strerror(socket_last_error($sSender)) . "\n");\n}\n\nsocket_write($sSender, "test", strlen("test"));\n\n// Create socket for listening\n$sListen = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);\nif ($sListen === false) {\n    die("socket_create() failed: " . socket_strerror(socket_last_error()) . "\n");\n}\n\nsocket_set_option($sListen, SOL_SOCKET, SO_REUSEADDR, 1);\n\nif (socket_bind($sListen, $host, $portSend) === false) {\n    die("socket_bind() failed: " . socket_strerror(socket_last_error($sListen)) . "\n");\n}\n\nif (socket_listen($sListen, 1) === false) {\n    die("socket_listen() failed: " . socket_strerror(socket_last_error($sListen)) . "\n");\n}\n\n$dataSock = socket_accept($sListen);\nif ($dataSock === false) {\n    die("socket_accept() failed: " . socket_strerror(socket_last_error($sListen)) . "\n");\n}\n\necho socket_read($dataSock, 3, PHP_NORMAL_READ);\n\n// Shutdown and close sockets\nsocket_shutdown($dataSock, 2);\nsocket_close($dataSock);\n\nsocket_shutdown($sListen, 2);\nsocket_close($sListen);\n\nsocket_shutdown($sSender, 2);\nsocket_close($sSender);\n\n?>