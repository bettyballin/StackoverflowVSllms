<?php\n$html = '<span lang="en">English Content</span><span lang="fr">French content</span>';\n\nfunction extractSpanContentDOM($html, $lang) {\n    $dom = new DOMDocument;\n    @$dom->loadHTML($html);\n    $spans = $dom->getElementsByTagName('span');\n    foreach ($spans as $span) {\n        if ($span->getAttribute('lang') === $lang) {\n            return $span->textContent;\n        }\n    }\n    return null;\n}\n\n$lang = 'fr';\n$content = extractSpanContentDOM($html, $lang);\n\nif ($content !== null) {\n    echo "Content for lang '$lang': $content\n";\n} else {\n    echo "No content found for lang '$lang'\n";\n}\n?>