// Correctly define the base directory with double backslashes\n$baseDIR = 'I:\\Development\\wamp\\www\\mySite\\wp-content\\uploads\\slgallery\\';\n\n// Or use DIRECTORY_SEPARATOR for portability\n$baseDIR = 'I:' . DIRECTORY_SEPARATOR . 'Development' . DIRECTORY_SEPARATOR . 'wamp' . DIRECTORY_SEPARATOR . 'www' . DIRECTORY_SEPARATOR . 'mySite' . DIRECTORY_SEPARATOR . 'wp-content' . DIRECTORY_SEPARATOR . 'uploads' . DIRECTORY_SEPARATOR . 'slgallery' . DIRECTORY_SEPARATOR;\n\n// Check if the directory 'f' exists\nif (is_dir($baseDIR . 'f' . DIRECTORY_SEPARATOR)) {\n    echo 'DIR exists';\n} else {\n    echo 'DIR does not exist';\n}