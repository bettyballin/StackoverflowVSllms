<?php\ndate_default_timezone_set('Asia/Singapore'); // +8 GMT\n\n$myemail = "****@myemail.com"; \n$ccx = ""; \n\nif(!$visitormail == "" && (!strstr($visitormail,"@") || !strstr($visitormail,"."))) \n{\n    echo "<h2>Use Back - Enter valid e-mail</h2>\n"; \n    $badinput = "<h2>Feedback was NOT submitted</h2>\n";\n}\nif(empty($visitor) || empty($visitormail) || empty($notes )) {\n    echo "<h2>Use Back - fill in all fields</h2>\n";\n}\necho $badinput;\n\n$todayis = date("l, F j, Y, g:i a") ;\n\n$attn = $attn . "(" . $ccopy . ")" ; \n$subject = $attn; \n\n$notes = stripcslashes($notes); \n\n$message = " $todayis \n\nFrom: $visitor ($visitormail)\n\nWebsite URL: $weburl \n\nMessage: $notes \n \nAdditional Info : IP = $ip \n\nBrowser Info: $httpagent \n\nReferral : $httpref \n\n";\n\n$thankYouMessage = "Thank you for your feedback. This is the message you wrote:\n\n" . $notes;\n\n$from = "From: $visitormail\r\n";\n\nif (($ccopy == "ccyes") && ($visitormail != "")) \n    mail($visitormail, $subject, $thankYouMessage, $from);\n\nif ($myemail != "") \n    mail($myemail, $subject, $message, $from);\n\nif ($ccx != "") \n    mail($ccx, $subject, $message, $from);\n\n?>