// Assuming you are using a custom token parameter\nif (isset($_POST['token'])) {\n    session_id($_POST['token']);\n} elseif (isset($_GET['token'])) {\n    session_id($_GET['token']);\n}\nsession_start();