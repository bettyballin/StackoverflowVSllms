if($count==1){\n    $_SESSION['username']  = $data['username'];\n    $_SESSION['client_id'] = $data['c_id'];\n    $_SESSION['loggedin']  = "1234";\n    $_SESSION['is_webmaster'] = ($data['role'] === 'webmaster'); // Set this based on your user table\n\n    echo $_SESSION['loggedin']; // This is just for debugging, remove in production\n    $var = array('valid' => 1);\n} else {\n    $var = array('valid' => 0);\n}\n\nprint php_json_encode($var);