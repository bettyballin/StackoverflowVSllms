$input_array = array('type' => 'text',\n                     'class' => 'input',\n                     'name' => 'username',\n                     'id' => 'username',\n                     'value' => '',\n                     'size' => '30',\n                     'rows' => '',\n                     'cols' => '');\n\n$input = '<input ';\nforeach ($input_array as $key => $value) {\n    if (isset($key) && !empty($value)) { // Only add attributes with non-empty values\n        $input .= $key . '="' . htmlspecialchars($value, ENT_QUOTES, 'UTF-8') . '" ';\n    }\n}\n$input .= '/>';\n\necho $input;