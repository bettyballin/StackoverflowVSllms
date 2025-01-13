function trimLastOctet($ip) {\n    $parts = explode('.', $ip);\n    if (count($parts) === 4) {\n        array_pop($parts);\n        return implode('.', $parts);\n    }\n    return null; // Return null or handle the error if the input is not a valid IPv4 address\n}\n\n// Example usage\n$ip = "192.168.1.100";\n$trimmedIp = trimLastOctet($ip);\necho $trimmedIp; // Outputs: 192.168.1