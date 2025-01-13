<?php\n\n$files = ['file1.html', 'file2.html']; // Add your HTML files here\n\nforeach ($files as $file) {\n    $html = file_get_contents($file);\n    \n    $dom = new DOMDocument;\n    libxml_use_internal_errors(true);\n    $dom->loadHTML($html);\n    libxml_clear_errors();\n\n    $images = $dom->getElementsByTagName('img');\n\n    foreach ($images as $img) {\n        $src = $img->getAttribute('src');\n        $title = $img->getAttribute('title');\n        $alt = $img->getAttribute('alt');\n        \n        echo "File: $file\n";\n        echo "Src: $src\n";\n        echo "Title: $title\n";\n        echo "Alt: $alt\n";\n    }\n}\n?>