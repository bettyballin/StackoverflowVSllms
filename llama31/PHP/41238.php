$html = '<html>...</html>'; // your HTML content\n$doc = new DOMDocument();\n$doc->loadHTML($html);\n$spans = $doc->getElementsByTagName('span');\n\n$links = array();\nforeach ($spans as $span) {\n    if ($span->getAttribute('class') == 'img') {\n        $links[] = $span->getElementsByTagName('a')->item(0)->getAttribute('href');\n    }\n}\n\nprint_r($links);