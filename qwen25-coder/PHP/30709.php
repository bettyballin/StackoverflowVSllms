function highlightSearchTerm($text, $searchTerm) {\n    // Escape special characters for regex\n    $escapedSearchTerm = preg_quote($searchTerm, '/');\n    \n    // Regular expression pattern to match the search term outside of HTML tags\n    $pattern = '/(?![^<]+>)(?![^<>]*<\/[^>]*>)(' . $escapedSearchTerm . ')/i';\n    \n    // Replacement string with span tags\n    $replacement = '<span style="background-color: yellow;">$1</span>';\n    \n    // Perform the replacement\n    return preg_replace($pattern, $replacement, $text);\n}\n\n// Example usage\n$resultText = "<p>This is a sample text with some words like example and Sample.</p>";\n$searchTerm = "sample";\necho highlightSearchTerm($resultText, $searchTerm);