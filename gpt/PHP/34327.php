<?php\n   $htmlString = '<html><body><p>Sample HTML</p></body></html>';\n   $dom = new DOMDocument();\n   @$dom->loadHTML($htmlString);\n   // Now you can manipulate the DOMDocument object\n   ?>