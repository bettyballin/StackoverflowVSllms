// Explicitly use _GET, _POST, or _COOKIE\nif (isset($_GET['foo'])) {\n    $foo = $_GET['foo'];\n} elseif (isset($_POST['foo'])) {\n    $foo = $_POST['foo'];\n} elseif (isset($_COOKIE['foo'])) {\n    $foo = $_COOKIE['foo'];\n} else {\n    $foo = null; // or handle the missing variable case\n}