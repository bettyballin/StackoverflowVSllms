$conn_id = ftp_connect($server);\nif (!$conn_id) {\n    die("Failed to connect to $server");\n}\n\n$login_result = ftp_login($conn_id, $ftp_user_name, $ftp_user_pass);\nif (!$login_result) {\n    die("FTP login has failed!");\n} else {\n    echo "Logged in successfully\n";\n}\n\nif (ftp_rename($conn_id, $old_file, $new_file)) {\n    echo "Successfully renamed $old_file to $new_file\n";\n} else {\n    $error_message = ftp_get_option($conn_id, FTP_LAST_ERROR);\n    echo "There was a problem while renaming $old_file to $new_file: the server says $error_message\n";\n}\n\nftp_close($conn_id);