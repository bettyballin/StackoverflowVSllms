<?php\n@$doc = new DOMDocument();\n@$doc->loadHTMLFile('http://foo.com');\n$tags = $doc->getElementsByTagName('body');\nforeach ($tags as $tag) {\n    $index_text .= $doc->saveHTML($tag);\n    print $doc->saveHTML($tag).'<br />';\n}\n?>