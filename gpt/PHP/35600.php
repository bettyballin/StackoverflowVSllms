<?php\n    require 'vendor/autoload.php';\n\n    use phpseclib3\Net\SFTP;\n\n    // SFTP server details\n    $sftp_server = 'remote.server.com';\n    $sftp_port = 22; // Default SFTP port\n    $sftp_username = 'your_username';\n    $sftp_password = 'your_password';\n    \n    // File paths\n    $local_file = '/path/to/local/file.xml';\n    $remote_file = '/path/to/remote/file.xml';\n\n    // Create SFTP connection\n    $sftp = new SFTP($sftp_server, $sftp_port);\n    if (!$sftp->login($sftp_username, $sftp_password)) {\n        exit('Login Failed');\n    }\n\n    // Upload the file\n    if ($sftp->put($remote_file, $local_file, SFTP::SOURCE_LOCAL_FILE)) {\n        echo "File successfully uploaded.\n";\n    } else {\n        echo "File upload failed.\n";\n    }\n    ?>