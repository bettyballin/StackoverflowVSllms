<?php\nsession_start();\n\nrequire './classes/DBInterface.php';\n$db = new DBInterface();\n\nif($_REQUEST['submit']  ==  'Login') {\n    $username=$_POST['username'];\n    $password=$_POST['password'];\n\n    echo '-- login -- '.$username;\n    $rs = $db->verify($username,$password,"admin",0);\n    $admin = $rs->current();\n    if ($rs->valid()) {\n        session_regenerate_id(true); // regenerate session ID\n        $_SESSION['username'] = $username;\n    }\n}\n\necho ' -- session id -- ';\nvar_dump(session_id());\necho ' -- session var -- ';\nvar_dump($_SESSION);