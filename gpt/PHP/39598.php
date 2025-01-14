function getApacheUser() {\n    $pid = getmypid();\n    $statusFile = "/proc/{$pid}/status";\n    \n    if (file_exists($statusFile) && is_readable($statusFile)) {\n        $status = file_get_contents($statusFile);\n        if (preg_match('/Uid:\s+(\d+)/', $status, $matches)) {\n            $uid = $matches[1];\n            $userInfo = posix_getpwuid($uid);\n            return $userInfo['name'];\n        }\n    }\n    \n    return null;\n}\n\n$apacheUser = getApacheUser();\nif ($apacheUser !== null) {\n    echo "Apache is running as user: $apacheUser";\n} else {\n    echo "Failed to determine Apache user.";\n}