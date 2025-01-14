<?php\n   require 'vendor/autoload.php';\n\n   // Load the HTML\n   use Sunra\PhpSimple\HtmlDomParser;\n\n   $html = '<div>This is some <b>text';\n   $dom = HtmlDomParser::str_get_html($html);\n\n   // Correcting malformed HTML\n   $dom->load($dom->save());\n\n   // Manipulate the DOM\n   foreach($dom->find('div') as $element) {\n       $element->innertext .= " with added content";\n   }\n\n   // Output the modified HTML\n   echo $dom;\n   ?>