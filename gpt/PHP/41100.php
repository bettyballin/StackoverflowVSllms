<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    if (isset($_POST['button1'])) {\n        // Button 1 was clicked\n        echo "Button 1 was clicked.";\n    } elseif (isset($_POST['button2'])) {\n        // Button 2 was clicked\n        echo "Button 2 was clicked.";\n    }\n}\n?>