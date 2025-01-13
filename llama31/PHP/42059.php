function format_string($value) {\n    // your formatting logic here\n    return strtoupper($value);\n}\n\n$obj = new stdClass();\n$obj->name = 'John';\n$obj->city = 'New York';\n\n$props = get_object_vars($obj);\n$props = array_map('format_string', $props);\n\nprint_r($props);