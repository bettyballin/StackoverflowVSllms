$userIP = $_SERVER['REMOTE_ADDR'];\n   $timeLimit = 60; // Minimum seconds between downloads\n\n   if (!isset($_SESSION[$userIP])) {\n       $_SESSION[$userIP] = time();\n       // Increment your download counter here\n   } elseif (time() - $_SESSION[$userIP] > $timeLimit) {\n       $_SESSION[$userIP] = time();\n       // Increment your download counter here\n   }