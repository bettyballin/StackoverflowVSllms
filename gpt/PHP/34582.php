<?php\nrequire_once("db_pers.inc");\n\n// Secure the input using prepared statements\n$sid = $_GET['sid'];\n$hdb = pg_connect("your_connection_string_here");\n\nif ($hdb) {\n    $ssql = "SELECT saffil, sfirst FROM contacts_mview WHERE sempid = $1";\n    $result = pg_prepare($hdb, "my_query", $ssql);\n    $rres = pg_execute($hdb, "my_query", array($sid));\n\n    if ($rres) {\n        $ares = pg_fetch_assoc($rres);\n        $json = array(\n            array('field' => 'saffil', 'value' => $ares['saffil']),\n            array('field' => 'sfirst', 'value' => $ares['sfirst'])\n        );\n        echo json_encode($json);\n    }\n\n    pg_close($hdb);\n} else {\n    echo json_encode(array('error' => 'Database connection failed.'));\n}\n?>