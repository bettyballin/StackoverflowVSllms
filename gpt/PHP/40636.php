<?php\n   if (isset($_POST['session_id'])) {\n       session_id($_POST['session_id']);\n   }\n   session_start();\n   \n   // Continue with your upload handling code\n   ?>