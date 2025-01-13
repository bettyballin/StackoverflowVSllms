function cidr_match($ip, $cidr) {\n    list($subnet, $bits) = explode('/', $cidr);\n    $subnet = ip2long($subnet);\n    $mask = -1 << (32 - $bits);\n    $ip = ip2long($ip);\n    return ($ip & $mask) == ($subnet & $mask);\n}