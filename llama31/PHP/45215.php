$memory_usage = memory_get_usage();\n// your code here\n$memory_usage_after = memory_get_usage();\necho "Memory usage: " . ($memory_usage_after - $memory_usage) . " bytes";