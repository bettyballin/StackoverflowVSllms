if ($files = glob('photos/*.{jpg,jpeg,png,gif}', GLOB_BRACE)) {\n    sort($files);\n    foreach ($files as $file) {\n        echo "<li><img src=\"$file\" alt=\"" . basename($file) . "\" title=\"\"></li>\n";\n    }\n}