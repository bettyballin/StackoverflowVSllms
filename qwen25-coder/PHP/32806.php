require_once 'path/to/HTMLPurifier.auto.php';\n   $config = HTMLPurifier_Config::createDefault();\n   // Optionally, adjust the config for allowed elements/tags\n   $purifier = new HTMLPurifier($config);\n   $cleanHtmlContent = $purifier->purify($userInput);\n\n   // Use prepared statements as before when saving to the database.