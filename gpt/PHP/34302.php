<?php\n   require 'path/to/simplehtmldom/simple_html_dom.php';\n   $html = file_get_html('path/to/yourfile.html');\n   foreach($html->find('p') as $element) {\n       echo $element->innertext;\n   }\n   ?>