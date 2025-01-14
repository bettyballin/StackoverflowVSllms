<?php\nerror_reporting(0);\n\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    $input_id = $_POST['id'];\n    $input_pass = $_POST['pass'];\n\n    $authenticated = false;\n    $handle = fopen("id.csv", "r");\n\n    while (($data = fgetcsv($handle)) !== FALSE) {\n        if ($data[0] === $input_id && password_verify($input_pass, $data[1])) {\n            $authenticated = true;\n            break;\n        }\n    }\n\n    fclose($handle);\n\n    if ($authenticated) {\n        echo "Login successful!";\n    } else {\n        echo "Invalid ID or password.";\n    }\n}\n?>