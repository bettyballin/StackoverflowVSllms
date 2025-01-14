<?php\n$html = '<table><tr><td>&nbsp;</td></tr></table>';\n\n$config = array(\n    'output-xhtml' => true,\n    'show-body-only' => false,\n    'drop-empty-elements' => false, // Prevents Tidy from removing empty elements like <td>\n);\n\n$tidy = new tidy();\n$repair_html = $tidy->parseString($html, $config, 'utf8');\n$tidy->cleanRepair();\n\necho $repair_html;\n?>