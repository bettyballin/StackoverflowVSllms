function GetInt4d($data, $pos) {\n    if (strlen($data) < $pos + 4) {\n        // Handle error or return a default value\n        return 0;\n    }\n    return ord($data[$pos]) | (ord($data[$pos + 1]) << 8) | (ord($data[$pos + 2]) << 16) | (ord($data[$pos + 3]) << 24);\n}