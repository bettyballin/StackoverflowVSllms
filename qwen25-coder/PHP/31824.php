<?php\n$directoryPath = '/path/to/new/directory';\n\n// Create directory with write permission for owner (user1) and read/execute for group and others\nif (!file_exists($directoryPath)) {\n    $res = mkdir($directoryPath, 0755);\n    if ($res === true) {\n        // Try to change the ownership of the directory to the current user or a specific user\n        // This step might fail due to Safe Mode restrictions\n        $targetUser = 'user1'; // Ensure this is set correctly and securely\n        chown($directoryPath, $targetUser);\n    } else {\n        echo "Failed to create directory.";\n    }\n} else {\n    echo "Directory already exists.";\n}\n?>