<?php\n    } else {\n        error_reporting(0);\n\n        if (mail($to, $subject, $msg, "From: $email\r\nReply-To: $email\r\nReturn-Path: $email\r\n")) {\n            //Message sent!\n            //It the message that will be displayed when the user click the submit button\n            //You can modify the text if you want\n            echo nl2br("\n            <div class=\"MsgSent\">\n                <h1>Congratulations!!</h1>\n                <p>Thank you <b>$name</b>, your message is sent!<br /> We will get back to you as soon as possible.</p>\n            </div>\n            ");\n        } else {\n            // Display error message if the message failed to send\n            echo "\n            <div class=\"MsgError\">\n                <h1>Error!!</h1>\n                <p>Sorry <b>$name</b>, your message failed to send. Try later!</p>\n            </div>";\n        }\n    }\n?>