<?php\ndefine('READ_PERMISSION', 1);    // 0001\ndefine('WRITE_PERMISSION', 2);   // 0010\ndefine('EXECUTE_PERMISSION', 4); // 0100\n\n$userPermissions = READ_PERMISSION | WRITE_PERMISSION; // 0011\n\n// Check for specific permissions\nif ($userPermissions & READ_PERMISSION) {\n    echo "User has read permission.\n";\n}\n\nif ($userPermissions & WRITE_PERMISSION) {\n    echo "User has write permission.\n";\n}\n\nif ($userPermissions & EXECUTE_PERMISSION) {\n    echo "User has execute permission.\n";\n} else {\n    echo "User does not have execute permission.\n";\n}\n?>