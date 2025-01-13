$actions = [\n    'save_user' => 'saveUser',\n    'delete_user' => 'deleteUser',\n];\n\n$action = filter_input(INPUT_POST, 'action', FILTER_SANITIZE_STRING);\n\nif (isset($actions[$action])) {\n    call_user_func($actions[$action]);\n} else {\n    // Handle invalid action\n}