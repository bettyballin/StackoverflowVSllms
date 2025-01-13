<?php\nrequire_once 'vendor/autoload.php';\n\n$config = HTMLPurifier_Config::createDefault();\n$config->set('HTML.Allowed', 'strong,em,blockquote,a[href]');\n\n$purifier = new HTMLPurifier($config);\n\n$userInput = $_POST['comment'];\n$sanitizedInput = $purifier->purify($userInput);\n\n// Convert newlines to <br />\n$sanitizedInput = nl2br($sanitizedInput);\n\n// Save $sanitizedInput to MySQL database\n// Example: $db->query("INSERT INTO comments (comment) VALUES ('$sanitizedInput')");\n?>\n\n<form method="post">\n    <textarea name="comment" placeholder="Enter your comment"></textarea>\n    <button type="submit">Submit</button>\n</form>