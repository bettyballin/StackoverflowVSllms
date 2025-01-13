use Symfony\Component\Process\Process;\n\n// Create a new process\n$process = new Process(['php', '-r', 'echo getenv("VARIABLE_NAME");']);\n\n// Set an environment variable\n$process->setEnv(['VARIABLE_NAME' => 'variable_value']);\n\n// Run the process\n$process->run();\n\n// Get the output\n$output = $process->getOutput();\n\n// Print the output\nprint_r($output);