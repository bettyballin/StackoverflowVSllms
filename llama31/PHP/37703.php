$leases = array();\npreg_match_all($pattern, $dhcpOutput, $matches, PREG_SET_ORDER);\nforeach ($matches as $match) {\n    $ipAddress = $match[1];\n    $data = $match[2];\n    if (!isset($leases[$ipAddress])) {\n        $leases[$ipAddress] = array();\n    }\n    $leases[$ipAddress][] = $data;\n}