// Assuming $db is your database connection object\n$inbox = $db->Query("SELECT * FROM mail_inbox");\n$outbox = $db->Query("SELECT * FROM mail_outbox");\n\n$output = array(\n    'Inbox' => array('id' => array()),\n    'Outbox' => array('id' => array())\n);\n\n// Process inbox results\nforeach($inbox as $array) {\n    $output['Inbox']['id'][] = $array['msg_seq'];\n}\n\n// Process outbox results\nforeach($outbox as $array) {\n    $output['Outbox']['id'][] = $array['msg_seq'];\n}\n\nprint_r($output);