require_once 'HTMLPurifier.auto.php';\n\n$config = HTMLPurifier_Config::createDefault();\n$purifier = new HTMLPurifier($config);\n\n$input = $_POST['user_input']; // assume this is the input from the user\n$clean_input = $purifier->purify($input);