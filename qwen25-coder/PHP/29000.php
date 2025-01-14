// Example of using Google reCAPTCHA v2 in PHP\n   $secret = "YOUR_SECRET_KEY";\n   $response = $_POST['g-recaptcha-response'];\n   $verify=file_get_contents("https://www.google.com/recaptcha/api/siteverify?secret=$secret&response=$response");\n   $captcha_success=json_decode($verify);\n   if ($captcha_success->success==false) {\n       echo "You are a bot! Go away!";\n   } else {\n       // Proceed with form submission\n   }