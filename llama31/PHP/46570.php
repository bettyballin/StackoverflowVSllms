ob_start();\ninclude 'template.html';\n$template = ob_get_clean();\n\n$page = htmlspecialchars("Hello! " . $template);