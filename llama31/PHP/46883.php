function emailHtml($from, $subject, $message, $to) {\n    require_once "Mail.php";\n\n    $subject = mb_encode_mimeheader($subject, 'UTF-8', 'B');\n\n    $headers = array (\n        'MIME-Version' => "1.0",\n        'Content-type' => "text/html; charset=utf-8;",\n        'Content-Transfer-Encoding' => 'base64',\n        'From' => $from,\n        'To' => $to,\n        'Subject' => $subject\n    );\n\n    $m = Mail::factory('mail');\n\n    $mail = $m->send($to, $headers, $message);\n    if (PEAR::isError($mail)){\n        return 0;\n    }else{\n        return 1;\n    }\n}