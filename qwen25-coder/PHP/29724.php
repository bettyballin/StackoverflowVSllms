$html_content = <<<HTML\n<p>Some text <!--PLAYER=video1.flv--> more text <!--PLAYER=video2.flv--></p>\nHTML;\n\n$find_players = preg_match_all("/<!--PLAYER=(.*?)-->/si", $html_content, $matches);\n\nif ($find_players) {\n    foreach ($matches[1] as $filename) {\n        echo "Found filename: $filename\n";\n    }\n}