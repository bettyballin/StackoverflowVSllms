<?php\n   if (isset($_GET['user'])) {\n       $username = $_GET['user'];\n       // Here, add code to fetch user data or redirect as needed\n       echo "User page for: " . htmlspecialchars($username);\n   } else {\n       echo "Welcome to the home page!";\n   }\n   ?>