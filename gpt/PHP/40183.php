<?php\n   session_start();\n\n   if (isset($_SESSION['userid'])) {\n       // Extend the session lifetime\n       session_regenerate_id(true);\n   }\n   ?>