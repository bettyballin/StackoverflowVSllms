$postdata = file_get_contents("php://input");\n$postdata = urldecode($postdata);\n\n$options = array();\n$pairs = explode('&', $postdata);\nforeach($pairs as $pair) {\n    list($key, $value) = explode('=', $pair);\n    if ($key == 'option') {\n        $options[] = $value;\n    }\n}\n\n// $options now contains all the selected values