$conn = oci_connect('myusername', 'mypassword', 'localhost/mydatabase');\n\nif (!$conn) {\n    $e = oci_error();\n    die('Connection failed: ' . $e['message']);\n}