$headers = array(\n    "MIME-Version: 1.0",\n    "Content-type: text/plain; charset=ISO-8859-1; format=flowed",\n    "Content-Transfer-Encoding: 8bit",\n    "Message-Id: <" . md5(uniqid(microtime())) . "@mysite.com>",\n    "Return-Path: <admin@mysite.com>",\n    "X-Mailer: PHP v" . phpversion(),\n    "From: admin@mysite.com",\n    "Date: " . date("r")\n);\n\nmail($to, $subject, $message, implode("\n", $headers));