<?php\n$server = 'Server=your_server_name;Driver={SQL Server};Trusted_Connection=yes;';\n$username = '';  // Leave blank for Windows Authentication\n$password = '';  // Leave blank for Windows Authentication\n\n$conn = odbc_connect($server, $username, $password);\nif (!$conn) {\n    exit("Connection Failed: " . odbc_errormsg());\n}\necho "Connected Successfully!";\n?>