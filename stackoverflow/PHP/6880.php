$pid = pcntl_fork();\nif ($pid == -1) {\n die('could not fork');\n} else if ($pid) {\n // we are the parent\n pcntl_waitpid($pid, $status, WUNTRACED); //Protect against Zombie children\n if (pcntl_wifexited($status)) {\n   echo "Child exited normally";\n } else if (pcntl_wifstopped($status)) {\n   echo "Signal: ", pcntl_wstopsig($status), " caused this child to stop.";\n } else if (pcntl_wifsignaled($status)) {\n   echo "Signal: ",pcntl_wtermsig($status)," caused this child to exit with return code: ", pcntl_wexitstatus($status);\n }\n} else {\n pcntl_exec("/path/to/php/script");\n echo "Could not Execute...";\n}