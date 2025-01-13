use Symfony\Component\Process\Process;\n\n// Assume this is your long-running function\nfunction longRunningFunction($data) {\n    // Simulate a long-running task\n    sleep(10);\n    // Do something with the data\n}\n\n// Create a new process\n$process = new Process('php longRunningFunction.php ' . escapeshellarg(json_encode($data)));\n\n// Start the process\n$process->start();\n\n// Return a response to the client\nreturn 'Success!';