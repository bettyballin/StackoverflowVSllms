<?php\n$_GET['tags'] = "apples, oranges, bananas, grapes, cherries";\n\n// Split the string into an array using comma as delimiter\n$rawTags = explode(',', $_GET['tags']);\n\n// Trim whitespace, strip HTML tags, and convert special characters for each tag\n$tags = array_map(function($tag) {\n    return htmlspecialchars(strip_tags(trim($tag)));\n}, $rawTags);\n\nprint_r($tags);\n?>