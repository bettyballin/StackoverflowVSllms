$connection = oci_connect($username, $password, $conn_string, OCI_CONNECT_TIMEOUT);\n\nif (!$connection) {\n    $e = oci_error();\n    print("Oracle connection failed: " . $e['message']);\n    exit;\n}