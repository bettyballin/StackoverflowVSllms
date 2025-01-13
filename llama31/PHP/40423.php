// create a new process\n$pid = pcntl_fork();\n\nif ($pid == -1) {\n    // error forking\n    exit(1);\n} elseif ($pid) {\n    // parent process, continue with request\n    // ...\n} else {\n    // child process, run in background\n    // your script code here\n    exec('/usr/bin/php /path/to/your/script.php');\n    exit(0);\n}