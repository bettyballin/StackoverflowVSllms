<?php\n// testeur_classe.php\nrequire_once '../classes/captcha.php';\n\n$captcha = new Captcha(5,200,80,"255/255/255");\n$captcha->generateRandomString();\n$str  = $captcha->getString();\n$captcha->generatePictureFromString($str);