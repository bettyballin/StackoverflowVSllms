<?php\n// Command to execute the shell script asynchronously\n$command = '/path/to/your/shellscript.sh > /dev/null 2>&1 &';\n\n// Use proc_open to execute the command\nproc_open($command, [], $pipes);\n\n// The PHP script can now exit without waiting for the shell script to finish\n?>