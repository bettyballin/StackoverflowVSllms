<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $userInput = $_POST['textarea_field'];\n    // Directly echo the input into a textarea\n    echo '<textarea>' . htmlspecialchars($userInput, ENT_NOQUOTES) . '</textarea>';\n}\n?>