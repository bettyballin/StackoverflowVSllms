<?php\n   $allowed_referer = 'http://yourdomain.com/index.htm';\n\n   if (isset($_SERVER['HTTP_REFERER']) && $_SERVER['HTTP_REFERER'] === $allowed_referer) {\n       // Proceed with the request\n   } else {\n       // Deny access\n       header('HTTP/1.1 403 Forbidden');\n       echo 'Access denied';\n       exit;\n   }\n   ?>