<?php\n// Load XML from a file or string\n$xmlString = <<<XML\n<books>\n    <book>\n        <title>PHP for Beginners</title>\n        <author>John Doe</author>\n    </book>\n    <book>\n        <title>Advanced PHP Techniques</title>\n        <author>Jane Smith</author>\n    </book>\n</books>\nXML;\n\n$xml = simplexml_load_string($xmlString);\n\n// Accessing elements\nforeach ($xml->book as $book) {\n    echo "Title: " . $book->title . ", Author: " . $book->author . "\n";\n}\n\n// Adding a new book\n$newBook = $xml->addChild('book');\n$newBook->addChild('title', 'Mastering PHP');\n$newBook->addChild('author', 'Alice Johnson');\n\necho "\nUpdated XML:\n" . $xml->asXML();\n?>