require_once('phpQuery/phpQuery.php');\n$xmlString = <<<XML\n<books>\n    <book>\n        <title>PHP Programming</title>\n        <author>John Doe</author>\n    </book>\n    <book>\n        <title>Advanced PHP</title>\n        <author>Jane Smith</author>\n    </book>\n</books>\nXML;\n\n$doc = phpQuery::newDocument($xmlString);\n$titles = pq('book > title');\nforeach ($titles as $title) {\n    echo pq($title)->text() . "\n";\n}