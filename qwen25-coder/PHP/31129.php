session_start();\n\nif(isset($_SESSION['name'])) {\n    $name = $_SESSION['name'];\n} else {\n    echo 'Name is not set';\n    exit;\n}\n\n// Bunch of code here\n\necho 'Name is ', $name;