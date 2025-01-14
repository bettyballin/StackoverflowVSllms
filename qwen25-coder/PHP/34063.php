<?php\n$newMessage = "new message starts here";\n$oldMessage = "old message here";\n\n// Construct the full message with new lines and separator\n$fullMessage = $newMessage . "\n\n--------------\n" . $oldMessage;\n\n// Display in a textarea\necho '<textarea rows="10" cols="50">' . htmlspecialchars($fullMessage) . '</textarea>';\n\n// When sending as an email, ensure you set the correct headers\n$headers = "Content-Type: text/plain; charset=utf-8\r\n";\nmail('recipient@example.com', 'Subject Here', $fullMessage, $headers);\n?>