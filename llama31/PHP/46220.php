$ipAddress = '192.168.1.100';\n$trimmedIpAddress = preg_replace('/\.[0-9]+$/', '', $ipAddress);\n\necho $trimmedIpAddress; // Output: 192.168.1