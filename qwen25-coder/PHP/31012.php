<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $userInput = $_POST['userInput'];\n    echo "You entered: " . htmlspecialchars($userInput);\n}\n?>