$formHtml = <<<HTML\n<form action="%SCRIPT%" method="post">\n    <input type="password" name="user_password" />\n    <button type="submit">Login</button>\n    %STATUS%\n</form>\nHTML;\n\n// Replace placeholders\necho str_replace(['%SCRIPT%', '%STATUS%'], [$scriptName, $status], $formHtml);