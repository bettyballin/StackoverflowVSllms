$buffer = '';\nwhile (true) {\n    $chunk = socket_read($socket, 1);\n    if ($chunk === false) {\n        break; // handle error\n    }\n    $buffer .= $chunk;\n    if ($chunk === "\x00") {\n        break;\n    }\n}