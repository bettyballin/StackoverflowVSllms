<?php\nrequire 'vendor/autoload.php';\nuse SimpleHtmlDom\simple_html_dom;\n\n// Load the HTML document\n$html = file_get_html('your_file.html');\n\n// Find all elements with the class "example-class"\nforeach($html->find('.example-class') as $element) {\n    echo $element->plaintext . "\n";\n}\n?>