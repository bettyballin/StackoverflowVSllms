define('IN_PHPBB', true);\n$phpbb_root_path = './path_to_phpbb2/'; // Set the correct path to your PHPBB2 installation\n$phpEx = substr(strrchr(__FILE__, '.'), 1);\ninclude($phpbb_root_path . 'extension.inc');\ninclude($phpbb_root_path . 'common.'.$phpEx);\n\n// Start session management\n$userdata = session_pagestart($user_ip, PAGE_INDEX);\ninit_userprefs($userdata);