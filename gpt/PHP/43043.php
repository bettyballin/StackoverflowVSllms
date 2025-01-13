<?php\n$ftp_server = "ftp.example.com"; // Replace with your FTP server\n$ftp_user = "username"; // Replace with your FTP username\n$ftp_pass = "password"; // Replace with your FTP password\n$ftp_dir = "/path/to/directory"; // Replace with the directory you want to check\n\n// Set up a connection or return an error\n$conn_id = ftp_connect($ftp_server);\n\nif (!$conn_id) {\n    die("Could not connect to FTP server.");\n}\n\n// Try to login\nif (@ftp_login($conn_id, $ftp_user, $ftp_pass)) {\n    echo "Connected as $ftp_user@$ftp_server\n";\n    \n    // Check if the specified directory exists\n    if (ftp_chdir($conn_id, $ftp_dir)) {\n        echo "Directory exists: $ftp_dir\n";\n    } else {\n        echo "Directory does not exist or insufficient permissions: $ftp_dir\n";\n    }\n} else {\n    echo "Could not connect as $ftp_user\n";\n}\n\n// Close the connection\nftp_close($conn_id);\n?>