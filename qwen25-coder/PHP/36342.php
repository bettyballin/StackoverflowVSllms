function create_excerpt($text, $limit = 20) {\n    // Remove HTML tags\n    $strippedText = strip_tags($text);\n    \n    // Split the string into an array using spaces as a delimiter\n    $wordsArray = explode(" ", $strippedText, $limit + 1);\n\n    // If we have more than $limit words, remove the extra ones and append '...'\n    if (count($wordsArray) > $limit) {\n        array_pop($wordsArray);\n        $textExcerpt = implode(" ", $wordsArray) . '...';\n    } else {\n        $textExcerpt = implode(" ", $wordsArray);\n    }\n\n    return $textExcerpt;\n}\n\n// Example usage\n$fullContent = "<p>This is a sample paragraph with HTML tags that needs to be stripped and shortened.</p>";\necho create_excerpt($fullContent, 10); // Adjust the limit as needed