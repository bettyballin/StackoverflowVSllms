<?php\n   require_once 'vendor/autoload.php';\n\n   use Twilio\Rest\Client;\n\n   // Your Account SID and Auth Token from twilio.com/console\n   $sid = 'your_account_sid';\n   $token = 'your_auth_token';\n   $twilio = new Client($sid, $token);\n\n   // The phone number you want to send the SMS to\n   $to = '+1234567890';\n\n   // Your Twilio phone number\n   $from = '+0987654321';\n\n   // The SMS message content\n   $message = 'Hello, this is a test message from your PHP application!';\n\n   try {\n       $twilio->messages->create(\n           $to,\n           [\n               'from' => $from,\n               'body' => $message\n           ]\n       );\n       echo "Message sent successfully!";\n   } catch (Exception $e) {\n       echo "Error: " . $e->getMessage();\n   }\n   ?>