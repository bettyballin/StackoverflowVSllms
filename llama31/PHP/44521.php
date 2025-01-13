function executeQuery($sql) {\n    $conn = oci_connect('username', 'password', 'localhost/orcl');\n    if (!$conn) {\n        $e = oci_error();\n        die("Error connecting to Oracle: " . $e['message']);\n    }\n\n    $stid = oci_parse($conn, $sql);\n    if (!$stid) {\n        $e = oci_error($conn);\n        die("Error parsing query: " . $e['message']);\n    }\n\n    oci_execute($stid);\n    $result = array();\n    while ($row = oci_fetch_array($stid, OCI_ASSOC + OCI_RETURN_NULLS)) {\n        $result[] = $row;\n    }\n\n    oci_free_statement($stid);\n    oci_close($conn);\n\n    return $result;\n}