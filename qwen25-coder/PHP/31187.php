<?php\nfunction writeConfig($filePath, $settings) {\n    file_put_contents($filePath, json_encode($settings, JSON_PRETTY_PRINT));\n}\n\nfunction readConfig($filePath) {\n    return json_decode(file_get_contents($filePath), true);\n}\n\nfunction getConfig($filePath, ...$keys) {\n    $config = readConfig($filePath);\n    foreach ($keys as $key) {\n        if (isset($config[$key])) {\n            $config = $config[$key];\n        } else {\n            return null;\n        }\n    }\n    return $config;\n}\n\nfunction updateConfig($filePath, $newValues, ...$parentKeys) {\n    $config = readConfig($filePath);\n    $ref = &$config;\n    foreach ($parentKeys as $k) {\n        if (!isset($ref[$k])) {\n            $ref[$k] = [];\n        }\n        $ref = &$ref[$k];\n    }\n    foreach ($newValues as $key => $value) {\n        $ref[$key] = $value;\n    }\n    writeConfig($filePath, $config);\n}\n\n// Example usage:\n$configFilePath = 'settings.json';\n\n// Initial settings\n$initialSettings = [\n    "Database" => [\n        "AccessSettings" => [\n            "Username" => "myDBUsername",\n            "Password" => "myDBPassword"\n        ]\n    ],\n    // Add more settings as needed\n];\n\n// Writing initial config\nwriteConfig($configFilePath, $initialSettings);\n\n// Reading a specific value\n$username = getConfig($configFilePath, 'Database', 'AccessSettings', 'Username');\necho $username; // Outputs: myDBUsername\n\n// Updating a specific value\nupdateConfig($configFilePath, ['Password' => 'newSecurePassword'], 'Database', 'AccessSettings');\n\n// Verify update\n$newPassword = getConfig($configFilePath, 'Database', 'AccessSettings', 'Password');\necho $newPassword; // Outputs: newSecurePassword\n?>