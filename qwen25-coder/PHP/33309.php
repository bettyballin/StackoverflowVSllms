<?php\n   session_start(); // Start the session\n\n   if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['info'])) {\n       $_SESSION['var'] = $_POST['info']; // Set session variable\n       echo "Session variable has been set.";\n   } else {\n       http_response_code(400);\n       echo "Invalid request.";\n   }\n   ?>