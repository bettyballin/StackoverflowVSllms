function truncateHTML($html, $length) {\n    $dom = new DOMDocument();\n    // Suppress errors due to malformed HTML\n    @$dom->loadHTML('<?xml encoding="utf-8" ?>' . $html, LIBXML_HTML_NOIMPLIED | LIBXML_HTML_NODEFDTD);\n    \n    $body = $dom->getElementsByTagName('body')->item(0);\n    $text = '';\n    $tagsToClose = [];\n\n    // Collect text and track tags\n    foreach ($body->childNodes as $node) {\n        if ($node instanceof DOMText) {\n            $text .= $node->nodeValue;\n        } elseif ($node instanceof DOMElement && $node->hasChildNodes()) {\n            array_push($tagsToClose, $node);\n            collectInnerText($node, $text, $tagsToClose);\n        }\n    }\n\n    // Truncate text\n    if (mb_strlen($text) > $length) {\n        $truncatedText = mb_substr($text, 0, $length);\n\n        // Close any open tags when truncating the HTML\n        while (!empty($tagsToClose)) {\n            $tag = array_pop($tagsToClose);\n            $dom->createTextNode('</' . $tag->tagName . '>')->insertBefore($tag);\n        }\n\n        return preg_replace('/<[^>]*$/', '', $truncatedText) . '</body></html>';\n    }\n\n    return $html;\n}\n\nfunction collectInnerText(DOMElement $element, &$text, &$tagsToClose) {\n    foreach ($element->childNodes as $node) {\n        if ($node instanceof DOMText) {\n            $text .= $node->nodeValue;\n        } elseif ($node instanceof DOMElement && $node->hasChildNodes()) {\n            array_push($tagsToClose, $node);\n            collectInnerText($node, $text, $tagsToClose);\n        }\n    }\n}\n\n$htmlContent = 'This is <b>my bold</b> text that will be trimmed to the first 50 characters without breaking HTML structure.';\n$truncatedHtml = truncateHTML($htmlContent, 50);\n\necho trim(preg_replace('/^<!DOCTYPE.+?>/', '', str_replace(array('<html>', '</html>', '<head></head>', '<body>', '</body>'), array('', '', '', '', ''), $dom->saveHTML())));