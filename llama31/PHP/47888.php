function getNetworkAddress($ip, $cidr) {\n    $ipLong = ip2long($ip);\n    $mask = (0xffffffff >> (32 - $cidr)) << (32 - $cidr);\n    return long2ip($ipLong & $mask);\n}\n\n// Test the function\n$ip = "193.95.221.54";\necho "/24 of $ip is " . getNetworkAddress($ip, 24) . "\n";\necho "/16 of $ip is " . getNetworkAddress($ip, 16) . "\n";\necho "/8 of $ip is " . getNetworkAddress($ip, 8) . "\n";\necho "/22 of $ip is " . getNetworkAddress($ip, 22) . "\n";