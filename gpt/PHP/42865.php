define('IN_PHPBB', true);\n// Path to your phpBB installation\n$phpbb_root_path = '../forum/';\n$phpEx = substr(strrchr(__FILE__, '.'), 1);\n\n// Include necessary phpBB files\ninclude($phpbb_root_path . 'config.' . $phpEx);\ninclude($phpbb_root_path . 'includes/functions.' . $phpEx);\ninclude($phpbb_root_path . 'includes/session.' . $phpEx);\n\n// Start phpBB session\n$phpbb_container = new phpbb\di\container_builder($phpbb_root_path, $phpEx);\n$phpbb_container->get('session')->session_begin();\n$user = $phpbb_container->get('user');\n$auth = $phpbb_container->get('auth');\n\n// Check if the user is logged in\nif ($user->data['user_id'] != ANONYMOUS) {\n    // User is logged in, extract the session data\n    $user_data = array(\n        'user_id' => $user->data['user_id'],\n        'username' => $user->data['username'],\n        'user_email' => $user->data['user_email'],\n        // Add other data as needed\n    );\n\n    // Save user data to CodeIgniter session\n    $this->session->set_userdata('phpbb_user', $user_data);\n} else {\n    // User is not logged in\n    echo "User is not logged in.";\n}\n\n// Now you can use $this->session->userdata('phpbb_user') in your CodeIgniter applicatio