function cleanUlTags($input) {\n    // Use regex to find UL sections and remove newlines within them\n    return preg_replace_callback('/<ul>(.*?)<\/ul>/is', function($matches) {\n        return str_replace("\n", '', $matches[0]);\n    }, $input);\n}\n\n// Example usage\n$htmlContent = "<p>Some text.</p><ul>\n<li>item one</li>\n<li>item two</li>\n</ul><p>More text.</p>";\n$cleanContent = cleanUlTags($htmlContent);\n\necho htmlspecialchars($cleanContent, ENT_QUOTES);