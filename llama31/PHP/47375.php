// template.php\n$template = '\n<form action="%SCRIPT%" method="post">\n    <input type="password" name="password">\n    <span style="color: red">%STATUS%</span>\n</form>\n';\n\n// replace placeholders\n$template = str_replace('%SCRIPT%', $scriptName, $template);\n$template = str_replace('%STATUS%', $statusMessage, $template);