<?php\n    ob_start();\n    session_start();\n    \n    $response = array(\n        'status' => 'abc',\n        'a' => 'abc',\n        'b' => 'abc',\n        'c' => 'abc'\n    );\n\n    header('Content-Type: application/json');\n    echo json_encode($response);\n    ob_end_flush();\n    exit;\n?>