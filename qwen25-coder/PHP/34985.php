<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $cmd = $_POST['cmd'];\n    \n    if ($cmd === 'submitinfo') {\n        // Handle submitinfo logic here\n    } else {\n        // Handle other commands or show an error message\n    }\n}\n?>