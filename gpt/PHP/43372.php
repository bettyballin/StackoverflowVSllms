function getClientIP() {\n    $ipAddress = '';\n\n    if (!empty($_SERVER['HTTP_CLIENT_IP'])) {\n        // Check for IP from shared internet\n        $ipAddress = $_SERVER['HTTP_CLIENT_IP'];\n    } elseif (!empty($_SERVER['HTTP_X_FORWARDED_FOR'])) {\n        // Check for IP passed from proxies\n        $ipAddress = $_SERVER['HTTP_X_FORWARDED_FOR'];\n        $ipList = explode(',', $ipAddress);\n        $ipAddress = trim($ipList[0]); // Take the first IP address in the list\n    } elseif (!empty($_SERVER['HTTP_X_FORWARDED'])) {\n        $ipAddress = $_SERVER['HTTP_X_FORWARDED'];\n    } elseif (!empty($_SERVER['HTTP_X_CLUSTER_CLIENT_IP'])) {\n        $ipAddress = $_SERVER['HTTP_X_CLUSTER_CLIENT_IP'];\n    } elseif (!empty($_SERVER['HTTP_FORWARDED_FOR'])) {\n        $ipAddress = $_SERVER['HTTP_FORWARDED_FOR'];\n    } elseif (!empty($_SERVER['HTTP_FORWARDED'])) {\n        $ipAddress = $_SERVER['HTTP_FORWARDED'];\n    } else {\n        // Fallback to REMOTE_ADDR if no forwarded headers are present\n        $ipAddress = $_SERVER['REMOTE_ADDR'];\n    }\n\n    return $ipAddress;\n}\n\n// Example usage\n$clientIP = getClientIP();\necho "Client IP address is: " . $clientIP;