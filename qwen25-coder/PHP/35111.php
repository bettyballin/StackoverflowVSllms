<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") { // Ensure the form method is POST\n    if (isset($_REQUEST['history12'])) {\n        $history12 = $_REQUEST['history12'];\n        echo htmlspecialchars($history12, ENT_QUOTES, 'UTF-8'); // Use htmlspecialchars to prevent XSS\n    } else {\n        echo "Value not set.";\n    }\n} else {\n    echo "Form was not submitted via POST method.";\n}\n?>