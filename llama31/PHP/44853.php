$pid = pcntl_fork();\nif ($pid == -1) {\n    die("Could not fork");\n} elseif ($pid) {\n    // Parent process\n    echo "Parent process\n";\n} else {\n    // Child process\n    echo "Child process\n";\n    // Execute your cron job here\n    exit(0);\n}