$output = '';\n$descriptorspec = array(\n   0 => array("pipe", "r"),  // stdin is a pipe that the child will read from\n   1 => array("pipe", "w"),  // stdout is a pipe that the child will write to\n   2 => array("pipe", "w")   // stderr is a pipe that the child will write to\n);\n\n$process = proc_open('your_command_here', $descriptorspec, $pipes);\n\nif (is_resource($process)) {\n    // Close any file descriptors you don't want the child to inherit\n    fclose(STDIN);\n    fclose(STDOUT);\n    fclose(STDERR);\n\n    // Communicate with process via pipes here if necessary\n\n    proc_close($process);\n}