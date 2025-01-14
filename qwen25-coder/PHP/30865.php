$descriptorspec = array(\n    0 => array("pipe", "r"),  // stdin is a pipe that the child will read from\n    1 => array("pipe", "w"),  // stdout is a pipe that the child will write to\n    2 => array("pipe", "w")   // stderr is a pipe that the child will write to\n);\n\n$env = $GLOBALS['_SERVER'];\n$env['PYTHONUNBUFFERED'] = '1';\n\n$process = proc_open('python last', $descriptorspec, $pipes, null, $env);\nif (is_resource($process)) {\n    // Close stdin\n    fclose($pipes[0]);\n\n    // Read stdout and stderr\n    $output = stream_get_contents($pipes[1]);\n    $errorOutput = stream_get_contents($pipes[2]);\n\n    // Print output\n    echo "Output:\n" . htmlspecialchars($output) . "\n";\n    if (!empty($errorOutput)) {\n        echo "Error Output:\n" . htmlspecialchars($errorOutput) . "\n";\n    }\n\n    // Close the pipes and handle to the process\n    fclose($pipes[1]);\n    fclose($pipes[2]);\n    proc_close($process);\n}