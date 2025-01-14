function replace_ms_quotes($text) {\n    $replace_pairs = array(\n        '“' => '"',\n        '”' => '"',\n        '‘' => "'",\n        '’' => "'"\n    );\n    return strtr($text, $replace_pairs);\n}\n\n// Example usage\n$input_text = '“Hello”, she said. ‘It’s nice to meet you.’';\n$clean_text = replace_ms_quotes($input_text);\necho $clean_text; // Outputs: "Hello", she said. 'It's nice to meet you.'