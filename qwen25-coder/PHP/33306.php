<?php\n   function getPostParam($param) {\n       return isset($_POST[$param]) && !empty($_POST[$param]) ? $_POST[$param] : null;\n   }\n\n   $action = getPostParam('action');\n\n   if ($action) {\n       echo htmlspecialchars($action);\n   } else { \n       echo 'No variable';\n   }\n   ?>