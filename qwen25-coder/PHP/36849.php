<?php\n// Start ex3270 with the host and script\n$descriptorspec = array(\n   0 => array("pipe", "r"),  // stdin is a pipe that the child will read from\n   1 => array("pipe", "w"),  // stdout is a pipe that the child will write to\n   2 => array("file", "/dev/null", "a") // stderr is a file to write to\n);\n\n$cwd = '/usr/bin'; // Set this to the path of ex3270 if it's not in the default search path\n\n$process = proc_open("ex3270 -script script.3270 mainframe.example.com", $descriptorspec, $pipes, $cwd, array());\n\nif (is_resource($process)) {\n    // Write a command to stdin\n    fwrite($pipes[0], "string 'your input'\n"); \n    fclose($pipes[0]);\n\n    // Read output from stdout\n    $output = stream_get_contents($pipes[1]);\n    fclose($pipes[1]);\n\n    // Close process\n    proc_close($process);\n\n    echo "Output: ", $output;\n}\n?>