<?php\n   if (isset($_SESSION['auth_user']) && !empty($_SERVER['PHP_AUTH_USER'])) {\n       // Set the environment variable for .htaccess to recognize\n       putenv('REMOTE_USER='.$_SESSION['auth_user']);\n   }