<?php\n// Attempt to set a configuration value using ini_set\n$original_value = ini_get('display_errors');\n$test_value = '1';\nini_set('display_errors', $test_value);\n\n// Check if the value was successfully set\nif (ini_get('display_errors') === $test_value) {\n    echo "ini_set() is enabled.";\n} else {\n    echo "ini_set() is disabled or the setting could not be changed.";\n}\n\n// Restore the original value\nini_set('display_errors', $original_value);\n?>