<?php\nfunction emailHtml($from, $subject, $message, $to) {\n    require_once "Mail.php";\n\n    $headers = array (\n        'MIME-Version' => "1.0",\n        'Content-type' => "text/html; charset=utf-8",\n        'From' => $from,\n        'To' => $to,\n        'Subject' => '=?UTF-8?B?'.base64_encode($subject).'?='\n    );\n\n    $m = Mail::factory('mail');\n\n    // Ensure the message itself is UTF-8 encoded\n    $message = mb_convert_encoding($message, 'UTF-8', 'auto');\n\n    $mail = $m->send($to, $headers, $message);\n    if (PEAR::isError($mail)){\n        return 0;\n    } else {\n        return 1;\n    }\n}\n?>