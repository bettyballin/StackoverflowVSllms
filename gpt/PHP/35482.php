$user_list = array(\n    'john_doe' => 'password123',\n    'jane_smith' => 'qwerty',\n);\n\nforeach ($user_list as $user => $pass) {\n    echo "Username: $user, Password: $pass\n";\n}