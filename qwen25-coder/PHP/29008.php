<?php\nrequire_once 'vendor/autoload.php';\n\nuse \simplehtmldom\HtmlWeb;\n\n$html = '<div><p>Hello, World!</p></div>';\n$dom = str_get_html($html);\n\nforeach ($dom->find('p') as $element) {\n    echo $element->plaintext . "<br>";\n}\n?>