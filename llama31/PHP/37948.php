$key = filter_input(INPUT_GET, 'key', FILTER_SANITIZE_STRING);\nif ($key) {\n    echo $key;\n} else {\n    // handle invalid input\n}