<?php\n$text = "* list item 1\n* list item 2\n";\n\n// Step 1: Replace each list item with <li> tags\n$text = preg_replace('/^\* (.*?)$/m', '<li>$1</li>', $text);\n\n// Step 2: Wrap the entire block with <ul> tags\n$text = '<ul>' . $text . '</ul>';\n\n// Step 3: Optionally, remove any potential newlines between <li> elements\n$text = str_replace("\n", "", $text);\n\necho $text;\n?>