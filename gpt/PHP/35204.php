foreach ($_GET as $key => $value) {\n    $key = str_replace('_', ' ', $key);\n    echo "Key: $key, Value: $value<br>";\n}