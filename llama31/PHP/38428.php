function checkSyntax($file) {\n    $code = file_get_contents($file);\n    $tokens = token_get_all($code);\n    foreach ($tokens as $token) {\n        if (is_array($token) && $token[0] == T_ERROR) {\n            return false;\n        }\n    }\n    return true;\n}\n\n$file = 'path/to/your/file.php';\nif (!checkSyntax($file)) {\n    echo "Syntax error in $file";\n}