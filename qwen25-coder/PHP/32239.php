<?php\nheader('Content-Type: application/json');\n$data = array(\n    "message" => "Hello from PHP",\n    "success" => true\n);\necho json_encode($data);\n?>