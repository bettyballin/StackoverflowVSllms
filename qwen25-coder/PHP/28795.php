<?php\n$reply_subject = 'Re: Your Subject';\n$reply_message = 'Your Reply Content';\n$sender = 'SenderID';\n$originalMessageId = 'OriginalMessageID'; // ID of the message being replied to\n\n// Insert reply into tblpm and get the auto-incremented ID for it\n$insertResult = mysql_query("INSERT INTO `tblpm` (title, content, sender_id, date_sent) VALUES ('$reply_subject', '$reply_message', '$sender', NOW())");\nif ($insertResult) {\n    $reply_id = mysql_insert_id(); // Get the last inserted ID from tblpm\n\n    // Retrieve all recipients of the original message to send the reply to\n    $recipientsQuery = mysql_query("SELECT receiver_id FROM `tblpm_info` WHERE message_id = '$originalMessageId'");\n    while ($row = mysql_fetch_assoc($recipientsQuery)) {\n        mysql_query("INSERT INTO `tblpm_info` (message_id, sender_id, receiver_id) VALUES ('$reply_id', '$sender', '{$row['receiver_id']}')");\n    }\n}\n?>