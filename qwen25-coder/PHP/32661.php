include 'simple_html_dom.php';\n\n$html = new simple_html_dom();\n$html->load('<html><body><p>First paragraph</p><span>Search Text</span><p>Second paragraph</p></body></html>');\n\n// Searching for a tag with specific text content\n$foundTag = null;\nforeach ($html->find('*') as $element) {\n    if (trim($element->text()) === 'Search Text') {\n        $foundTag = $element;\n        break;\n    }\n}\n\nif ($foundTag !== null) {\n    // Getting the next sibling tag\n    $nextTag = $foundTag->next_sibling();\n    if ($nextTag) {\n        echo "Next sibling tag: " . $nextTag->tag;\n        echo "\nContents of next sibling tag: " . trim($nextTag->text());\n    } else {\n        echo "No next sibling tag found.";\n    }\n} else {\n    echo "Desired tag not found.";\n}