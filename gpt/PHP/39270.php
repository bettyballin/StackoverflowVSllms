print_r($_POST);\n\nrequire_once('inc/recaptchalib.php');\n$privatekey = "MY_PRIVATE_KEY";\n$resp = recaptcha_check_answer($privatekey,\n                               $_SERVER["REMOTE_ADDR"],\n                               $_POST["recaptcha_challenge_field"],\n                               $_POST["recaptcha_response_field"]);\n\nprint_r($resp);\n\nif (!$resp->is_valid) {\n    die("The reCAPTCHA wasn't entered correctly. Go back and try it again." .\n        "(reCAPTCHA said: " . $resp->error . ")");\n}