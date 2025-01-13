$email = '...'; // your email string\n\n$mailparse_msg = mailparse_msg_create();\nmailparse_msg_parse($mailparse_msg, $email);\n\n$attachments = array();\nforeach (mailparse_msg_get_structure($mailparse_msg) as $part_id) {\n    $part = mailparse_msg_get_part($mailparse_msg, $part_id);\n    $disposition = mailparse_msg_get_part_data($part);\n    if (isset($disposition['disposition']) && $disposition['disposition'] == 'attachment') {\n        $attachment = array(\n            'filename' => $disposition['filename'],\n            'data' => mailparse_msg_get_part_body($part)\n        );\n        $attachments[] = $attachment;\n    }\n}\n\nmailparse_msg_free($mailparse_msg);\n\n// $attachments now holds an array of attachments with filename and data