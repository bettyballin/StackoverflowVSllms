<?php\n\n$html = '<img src="/image/fluffybunny.jpg" title="Harvey the bunny" alt="a cute little fluffy bunny" />';\n\n$dom = new DOMDocument;\nlibxml_use_internal_errors(true); // Suppress warnings for invalid HTML\n$dom->loadHTML($html);\nlibxml_clear_errors();\n\n$images = $dom->getElementsByTagName('img');\n\nforeach ($images as $img) {\n    $src = $img->getAttribute('src');\n    $title = $img->getAttribute('title');\n    $alt = $img->getAttribute('alt');\n    \n    echo "Src: $src\n";\n    echo "Title: $title\n";\n    echo "Alt: $alt\n";\n}\n?>