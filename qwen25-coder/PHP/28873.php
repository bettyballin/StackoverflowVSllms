<?php\n$html = '<td><b>Title</td>';\n\n// Create a new Tidy object\n$tidy = new tidy();\n\n// Clean and repair the HTML\n$config = array(\n    'output-xhtml' => true,\n    'indent' => true,\n    'show-body-only' => true,\n);\n$tidy->parseString($html, $config, 'utf8');\n$tidy->cleanRepair();\n\necho $tidy;\n?>