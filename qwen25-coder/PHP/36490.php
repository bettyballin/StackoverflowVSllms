<?php\n\n// Assuming $result is your MySQL query result resource after fetching with mysql_query()\n$result = mysql_query("SELECT link_id, url, category FROM links_categories ORDER BY link_id");\n\n$links_with_categories = [];\n\nwhile ($row = mysql_fetch_assoc($result)) {\n    if (!array_key_exists($row['link_id'], $links_with_categories)) {\n        // Initialize the entry for this link_id\n        $links_with_categories[$row['link_id']] = [\n            'url' => $row['url'],\n            'categories' => []\n        ];\n    }\n    \n    // Append the category to the list of categories for this link_id\n    $links_with_categories[$row['link_id']]['categories'][] = $row['category'];\n}\n\n// Now output the results with combined categories\nforeach ($links_with_categories as $link) {\n    echo "link_id = 4   url= '{$link['url']}'   category = '" . implode(' ', $link['categories']) . "'\n";\n}\n\n?>