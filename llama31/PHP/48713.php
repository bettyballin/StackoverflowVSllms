<?php\n  // Define the service command\n  $command = $_GET['command'];\n\n  // Validate the command\n  if (!in_array($command, array('start', 'stop', 'restart'))) {\n    echo "Invalid command";\n    exit(1);\n  }\n\n  // Send the command to the service\n  $output = shell_exec("sudo /usr/bin/my_service $command");\n  echo $output;\n?>