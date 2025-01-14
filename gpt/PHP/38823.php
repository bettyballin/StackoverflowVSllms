<?php\nrequire_once 'path/to/vendor/autoload.php';\n\nuse Twilio\Rest\Client;\n\n// Your Account SID and Auth Token from twilio.com/console\n$sid = 'your_account_sid';\n$token = 'your_auth_token';\n$twilio = new Client($sid, $token);\n\n// Send SMS\n$message = $twilio->messages\n                  ->create(\n                      '+1234567890', // to\n                      [\n                          'from' => '+0987654321', // from (local number)\n                          'body' => 'Hello, this is a test message!'\n                      ]\n                  );\n\necho "Message sent: " . $message->sid;\n?>