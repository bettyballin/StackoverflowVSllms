require_once 'HTMLPurifier.auto.php';\n$config = HTMLPurifier_Config::createDefault();\n$purifier = new HTMLPurifier($config);\n$cleanInput = $purifier->purify($_POST['input']);