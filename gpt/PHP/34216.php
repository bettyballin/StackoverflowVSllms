// testeur_classe.php\n   require_once '../classes/captcha.php';\n\n   $captcha = new Captcha(5, 200, 80, "255/255/255");\n   $captcha->generateRandomString();\n   $str = $captcha->getString();\n   \n   // Ensure no extra output\n   ob_clean();\n   $captcha->generatePictureFromString($str);