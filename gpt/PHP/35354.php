<?php\ninclude('simple_html_dom.php');\n\n// Load your HTML content\n$html = file_get_html('yourfile.html');\n\n// Search for a tag with specific content\n$searchText = 'your search text';\n$element = null;\n\n// Find the element with the specific text\nforeach ($html->find('*') as $el) {\n    if (trim($el->plaintext) == $searchText) {\n        $element = $el;\n        break;\n    }\n}\n\n// If the element is found, get the next sibling\nif ($element) {\n    $nextElement = $element->next_sibling();\n    if ($nextElement) {\n        echo $nextElement->outertext; // or any other operation you want to perform\n    } else {\n        echo "No next sibling found.";\n    }\n} else {\n    echo "Element with the specified text not found.";\n}\n?>