$ftp_server = 'ftp.blah.com.au';\n$ftp_username = 'your_username';\n$ftp_password = 'your_password';\n\n$conn_id = ftp_connect($ftp_server);\nif ($conn_id) {\n    ftp_login($conn_id, $ftp_username, $ftp_password);\n    $file = 'artwork/'.$OrderID.'/'.$ItemID.'/Final/Final.pdf';\n    $local_file = '/path/to/local/file.pdf';\n    ftp_get($conn_id, $local_file, $file, FTP_BINARY);\n    ftp_close($conn_id);\n}