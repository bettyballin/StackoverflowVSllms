function toBeCalled( &$parameter ) {\n    $parameter = 'modified'; // Modify the parameter\n}\n\n$changingVar = 'passThis';\n$parameters = [&$changingVar]; // Pass by reference\ncall_user_func_array('toBeCalled', $parameters);\n\necho $changingVar; // This will output: modified