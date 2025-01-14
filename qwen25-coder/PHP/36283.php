$content = new DOMDocument();\n// Disable output of original document formatting ('as loaded')\n$content->preserveWhiteSpace = false;\n// Format the output nicely (optional, if you want pretty printing)\n$content->formatOutput = false;\n$content->loadHTMLFile(CONTENT.html);\n$story = simplexml_import_dom($content->getElementById('story'));\n$topics = $story->xpath('div[@class="topic"]');\nforeach ($topics as $topic) {\n    $topicContents = $topic->xpath('div/child::node()'); // Array of elements within 'content'.\n    foreach ($topicContents as $contentElement) {\n        echo $contentElement->asXML();\n    }\n}