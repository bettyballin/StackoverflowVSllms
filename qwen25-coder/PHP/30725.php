function send_html($from, $email, $subject = "AUCUN", $message, $cc = "", $bcc ="", $priority = "3") {\n    $headers = "";\n    $headers .= "MIME-Version: 1.0\r\n"; \n    $headers .= "Content-type: text/html; charset=utf-8\r\n";\n\n    if (strpos($from, "@ourwebsite.com") !== false || strpos($from, "@rencontresportive.com") !== false) {\n        $headers .= "From: Ourwebsite.com <$from>\r\n";\n    } else {\n        $headers .= "From: $from\r\n";  // Corrected\n    }\n\n    $headers .= "X-Sender: <$from>\r\n";\n    $headers .= "X-Priority: $priority\r\n";\n    $headers .= "X-Mailer: PHP\r\n";\n    $headers .= "Return-Path: <admin@ourwebsite.com>\r\n";\n\n    if (!empty($cc)) {\n        $headers .= "Cc: $cc\r\n";\n    }\n    if (!empty($bcc)) {\n        $headers .= "Bcc: $bcc\r\n";\n    }\n\n    return mail($email, $subject, $message, $headers);\n}