<?php\ndefined('IN_PHPBB') or exit;\n\n// Include necessary files\nrequire($phpbb_root_path . 'includes/functions_user.' . $php_ext);\n\n$user_row = array(\n    'username'          => 'newuser',\n    'user_password'     => phpbb_hashing::password_hash('newuserpassword'),\n    'group_id'          => 2, // Registered users group\n    'email'             => 'newuser@example.com',\n    'user_timezone'     => 'UTC',\n);\n\n$user->add_user($user_row);\n?>