ob_start();\nphpinfo(INFO_ALL);\n$info = ob_get_contents();\nob_end_clean();\n\n$ini_settings = array();\n\n// Parse phpinfo() output\npreg_match_all('/^(.*?)[\s]+=>[\s]+(.*?)$/m', $info, $matches);\nforeach ($matches[1] as $key => $setting) {\n    $ini_settings[$setting] = $matches[2][$key];\n}\n\n// Filter out unwanted settings (e.g., paths)\n$unwanted_settings = array('PHP Version', 'System', 'Server API', 'PHP Extension', 'Zend Extension');\n$ini_settings = array_diff_key($ini_settings, array_flip($unwanted_settings));\n\n// Write to php.ini file\n$ini_content = '';\nforeach ($ini_settings as $setting => $value) {\n    $ini_content .= "$setting = $value\n";\n}\n\nfile_put_contents('php.ini', $ini_content);