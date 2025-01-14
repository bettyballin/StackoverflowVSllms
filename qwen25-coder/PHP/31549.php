echo '<ul>';\n$prev_depth = 0;\n\nforeach ($table->fetchTree() as $row) {\n    if ($row->tree_depth > $prev_depth) {\n        // Open new sublist when depth increases\n        echo str_repeat('<ul>', $row->tree_depth - $prev_depth);\n    } elseif ($row->tree_depth < $prev_depth) {\n        // Close sublists when depth decreases\n        echo str_repeat('</li></ul>', $prev_depth - $row->tree_depth);\n        echo '</li>'; // Close the last li before changing depth\n    } else {\n        // Close previous list item if on same level\n        echo '</li>';\n    }\n    \n    // Start a new list item\n    echo '<li>' . htmlspecialchars($row->name);\n    \n    // Update previous depth\n    $prev_depth = $row->tree_depth;\n}\n\n// Close remaining ul tags\necho str_repeat('</li></ul>', $prev_depth);\n\n// Final closing tag for the outermost ul\necho '</li></ul>';