<?php\nif ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['html'])) {\n    $htmlContent = $_POST['html'];\n\n    // Save the HTML content to a file or process it as needed\n    $file = 'user_content.html';\n    file_put_contents($file, $htmlContent);\n\n    echo 'HTML content saved successfully.';\n} else {\n    echo 'No HTML content received.';\n}\n?>