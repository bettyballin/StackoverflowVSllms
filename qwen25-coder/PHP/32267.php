<?php\n\n$jsonArrayString = '[{"name":"John", "age":30}, {"name":"Anna", "age":22}]';\n$users = json_decode($jsonArrayString, true);\n\nforeach ($users as $user) {\n    echo 'Name: ' . $user['name'] . "\n";\n    echo 'Age: ' . $user['age'] . "\n";\n}\n?>