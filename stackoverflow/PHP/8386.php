session_start();\n\nif(!isset($_SESSION['db_key']))\n{\n    $_SESSION['db_key'] = // generate your database key\n}\nelse\n{\n    $db_key = $_SESSION['db_key'];\n}