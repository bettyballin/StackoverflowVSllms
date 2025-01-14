<?php\n\nfunction generateMetaDescription($content, $maxLength = 160) {\n    // Strip tags and trim spaces\n    $text = strip_tags(html_entity_decode($content));\n    \n    // Get the first sentence or up to maxLength characters\n    if (strpos($text, '.') !== false) {\n        $firstSentence = substr($text, 0, strpos($text, '.') + 1);\n        return mb_strimwidth($firstSentence, 0, $maxLength);\n    }\n    \n    return mb_strimwidth($text, 0, $maxLength);\n}\n\nfunction generateMetaKeywords($content) {\n    // Define common words to ignore\n    $commonWords = ['the', 'and', 'but', 'or', 'an', 'a', 'to', 'in', 'is', 'you', 'it', 'he', 'she', 'they', 'we'];\n\n    // Strip tags and convert to lowercase\n    $text = strtolower(strip_tags($content));\n\n    // Replace punctuation with spaces and split into words\n    $words = preg_split('/\W+/', $text, -1, PREG_SPLIT_NO_EMPTY);\n\n    // Count word frequency\n    $wordFrequency = array_count_values($words);\n\n    // Filter out common words and sort by frequency\n    $filteredWords = array_diff_key($wordFrequency, array_flip($commonWords));\n    arsort($filteredWords);\n\n    // Get top 5 keywords (based on frequency)\n    $keywords = array_slice(array_keys($filteredWords), 0, 5);\n\n    return implode(', ', $keywords);\n}\n\n// Example usage\n$content = "<p>This is an example content about PHP and how to generate META tags. It's quite useful for SEO purposes.</p>";\necho '<meta name="description" content="' . htmlspecialchars(generateMetaDescription($content)) . '">';\necho "\n";\necho '<meta name="keywords" content="' . htmlspecialchars(generateMetaKeywords($content)) . '">';\n\n?>