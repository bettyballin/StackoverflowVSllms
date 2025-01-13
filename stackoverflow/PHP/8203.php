function foo($hex) {\n    $rv = '';\n    foreach(str_split($hex, 2) as $b) {\n        $rv .= chr(hexdec($b));\n    }\n    return $rv;\n}\n\n// Three 16 character long keys\n$key1 = '1234567890123456';\n$key2 = '6543210987654321';\n$key3 = '6549873210456123';\n\n$key = foo($key1.$key2.$key3);