if (!isset($_SESSION['regenerated'])) {\n       session_regenerate_id();\n       $_SESSION['regenerated'] = true;\n   }