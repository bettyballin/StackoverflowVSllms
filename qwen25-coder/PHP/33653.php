<?php\nif(isset($_GET['filename'])) {\n    $myVariable = $_GET['filename'];\n    // Use htmlspecialchars() or other methods to safely output these variables in HTML context\n    echo htmlspecialchars($myVariable);\n} else {\n    echo "No filename provided.";\n}\n?>