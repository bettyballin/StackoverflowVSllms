<?php\n$ip = $_SERVER['REMOTE_ADDR'];\necho "Your IP: $ip";\n\n// Try to connect to a service (e.g., FTP)\n$ftp = ftp_connect('your-ftp-server');\nif ($ftp) {\n    echo "FTP connection successful!";\n    ftp_close($ftp);\n} else {\n    echo "FTP connection failed!";\n}\n?>