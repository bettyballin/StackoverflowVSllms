<?php\n// Read the contents of the file\n$text = '[b]Some bold text[/b]\n[i]Italic[/i]\n- List item 1\n- List item 2\n- List item 3\n# List item 1\n# List item 2\n# List item 3';\n\n// Convert [b] and [/b] to <b> and </b>\n$text = preg_replace('/\[b\](.*?)\[\/b\]/is', '<b>$1</b>', $text);\n// Convert [i] and [/i] to <i> and </i>\n$text = preg_replace('/\[i\](.*?)\[\/i\]/is', '<i>$1</i>', $text);\n\n// Split the text into lines\n$lines = explode("\n", $text);\n\n// Initialize output HTML\n$outputHTML = '';\n\n// Prepare for list generation\n$currentListType = '';\n$listContent = [];\n\nforeach ($lines as $line) {\n    trim($line); // Trim whitespace\n\n    if (strpos($line, '-') === 0) { // Check for unordered list item\n        if ($currentListType !== 'ul') {\n            outputCurrentList($listContent, $currentListType);\n            $listContent = [];\n            $currentListType = 'ul';\n        }\n        array_push($listContent, substr(trim($line), 1));\n    } elseif (strpos($line, '#') === 0) { // Check for ordered list item\n        if ($currentListType !== 'ol') {\n            outputCurrentList($listContent, $currentListType);\n            $listContent = [];\n            $currentListType = 'ol';\n        }\n        array_push($listContent, substr(trim($line), 1));\n    } else { // Regular line not part of a list\n        outputCurrentList($listContent, $currentListType);\n        $outputHTML .= htmlspecialchars($line) . "\n";\n        $currentListType = '';\n        $listContent = [];\n    }\n}\n\n// Output any remaining list items after the loop\noutputCurrentList($listContent, $currentListType);\n\necho $outputHTML;\n\n/**\n * Outputs a list based on the type and content provided.\n *\n * @param array $content The list item contents to output as HTML <li> elements.\n * @param string $type The type of list: 'ul', 'ol', or empty for no list.\n */\nfunction outputCurrentList(&$content, &$type) {\n    global $outputHTML;\n    if ($currentListType !== '') {\n        $outputHTML .= "<$type>\n";\n        foreach ($content as $item) {\n            $outputHTML .= "\t<li>" . htmlspecialchars($item) . "</li>\n";\n        }\n        $outputHTML .= "</$type>\n";\n        $content = [];\n        $type = '';\n    }\n}\n?>