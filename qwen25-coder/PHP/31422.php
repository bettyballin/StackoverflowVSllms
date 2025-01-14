<?php\n\n// Define your server and user details\n$ssh_user = 'your_ssh_username';\n$ssh_host = 'your_ssh_server_ip';\n$mysql_host = 'localhost'; // This is the local forwarding host after SSH tunnel\n$mysql_port = 3307;        // forwarded MySQL port on localhost\n$db_user = 'your_mysql_username';\n$db_password = 'your_mysql_password';\n$db_name = 'your_database';\n\n// Create a unique identifier for this session to avoid port binding issues if script is run multiple times\n$unique_id = uniqid();\n$temp_filename = "/tmp/ssh-$unique_id.pid";\n\n// Command to establish SSH tunnel\n$ssh_command = "ssh -M -S $temp_filename -f -L $mysql_port:mysql.server.ip:3306 $ssh_user@$ssh_host sleep 10 && ";\n\n// Execute the command to create SSH tunnel\nexec($ssh_command);\n\n// Connect to MySQL using the now-local port forwarded from your remote machine\n$db = new mysqli($mysql_host, $db_user, $db_password, $db_name, $mysql_port);\n\nif ($db->connect_error) {\n    die("Connection failed: " . $db->connect_error);\n} else {\n    echo "Connection successful";\n}\n\n// To close the tunnel when you're done with your database operations\nfunction close_ssh_tunnel($pid_file) {\n    if (file_exists($pid_file)) {\n        $master_pid = (int) trim(file_get_contents($pid_file));\n        exec("kill -9 " . $master_pid);\n        unlink($pid_file);\n    }\n}\n\n// Clean up and close tunnel after script execution\nregister_shutdown_function(function() use ($temp_filename) {\n    close_ssh_tunnel($temp_filename);\n});\n?>