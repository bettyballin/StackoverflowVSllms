$handle = fopen("php://stdin", "r");\nwhile (($char = fgetc($handle)) !== false) {\n    echo $char;\n}\nfclose($handle);