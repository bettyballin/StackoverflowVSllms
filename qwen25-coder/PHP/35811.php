function readUntilZero($socket) {\n    $data = '';\n    do {\n        // Read up to 150 bytes at a time (adjust as needed)\n        $buffer = @socket_read($socket, 150, PHP_BINARY_READ);\n        if ($buffer === false) {\n            break; // Handle error\n        }\n        $data .= $buffer;\n    } while (!strpos($data, "\x00"));\n    \n    // Trim the data up to and including the null terminator\n    $nullPos = strpos($data, "\x00");\n    if ($nullPos !== false) {\n        return substr($data, 0, $nullPos);\n    }\n    \n    return false; // Or handle the case where no terminator is found\n}\n\n// Usage example\n$socket = socket_create(AF_INET, SOCK_DGRAM, SOL_UDP);\nif ($socket === false) {\n    echo "Failed to create socket: " . socket_strerror(socket_last_error()) . "\n";\n} else {\n    while (true) {\n        $packet = readUntilZero($socket);\n        if ($packet !== false) {\n            // Process your packet here\n            echo "Received packet: $packet\n";\n        }\n    }\n}