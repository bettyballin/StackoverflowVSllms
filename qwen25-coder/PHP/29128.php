$connection = oci_connect($username, $password, $database);\nif (!$connection) {\n    $error = oci_error();\n    return $result = "Trouble connecting to the Oracle Database: " . $error['message'] . " (Error Code: " . $error['code'] . ")";\n}