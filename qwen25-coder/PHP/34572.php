require_once 'path/to/phpQuery-onefile.php';\n\n$html = '<div>This is some <b>text</b></div>';\n$doc = phpQuery::newDocumentHTML($html);\n\n// Manipulate the DOM\n$bTags = pq('b');\n$bTags->after('<b>more text</b>');\n\necho $doc;