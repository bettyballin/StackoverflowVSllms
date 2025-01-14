<?php\n// Example of sanitizing input to prevent XSS attacks\n$userInput = $_GET['input'];\n$safeOutput = htmlspecialchars($userInput, ENT_QUOTES, 'UTF-8');\necho $safeOutput;\n?>