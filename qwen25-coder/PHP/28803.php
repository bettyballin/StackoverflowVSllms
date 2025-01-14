<?php\n// Start output buffering in case anything outputs before session_start()\nob_start();\n\n// Start the session at the very beginning\nsession_start();\n\nrequire './classes/DBInterface.php';\n$db = new DBInterface();\n\nif ($_SERVER['REQUEST_METHOD'] === 'POST' && $_POST['submit'] == 'Login') {\n    $username = filter_input(INPUT_POST, 'username', FILTER_SANITIZE_STRING);\n    $password = filter_input(INPUT_POST, 'password', FILTER_SANITIZE_STRING);\n\n    echo '-- login -- '.$username;\n    $rs = $db->verify($username,$password,"admin",0);\n    $admin = $rs->current();\n    \n    if ($rs->valid() && is_array($admin)) {\n        // Set session variables\n        $_SESSION['username'] = $username;\n        // Optionally, set other necessary session vars here\n    }\n}\n\necho ' -- session id -- ';\nvar_dump(session_id());\necho ' -- session var -- ';\nvar_dump($_SESSION);\n\n// Flush the output buffer to ensure no data is sent before headers\nob_end_flush();\n?>