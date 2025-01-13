<?php\nfunction categorizePost($post) {\n    $post = strtolower($post); // Convert the post to lowercase\n\n    // Define keywords for categorization\n    $buyKeywords = ['looking for', 'want to buy'];\n    $sellKeywords = ['looking to sell', 'get rid of'];\n\n    $categories = [];\n\n    // Check for "buy" keywords\n    foreach ($buyKeywords as $keyword) {\n        if (strpos($post, $keyword) !== false) {\n            $categories[] = 'buy';\n            break;\n        }\n    }\n\n    // Check for "sell" keywords\n    foreach ($sellKeywords as $keyword) {\n        if (strpos($post, $keyword) !== false) {\n            $categories[] = 'sell';\n            break;\n        }\n    }\n\n    // Identify the item in question\n    $items = ['house', 'car', 'bike']; // Add more items as needed\n    foreach ($items as $item) {\n        if (strpos($post, $item) !== false) {\n            $categories[] = $item;\n            break;\n        }\n    }\n\n    return $categories;\n}\n\n// Example usage\n$post = "I'm looking to get rid of my old house";\n$categories = categorizePost($post);\nprint_r($categories); // Output: Array ( [0] => sell [1] => house )\n?>