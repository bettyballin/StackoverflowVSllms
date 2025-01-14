function fetchInput($type, $name, $default = null) {\n    return filter_input($type, $name, FILTER_SANITIZE_FULL_SPECIAL_CHARS) ?? $default;\n}\n\n$my_id = fetchInput(INPUT_POST, 'my_id', '');\n$another_var = fetchInput(INPUT_POST, 'another_var', 42);