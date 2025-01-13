function replace_urls_with_links($text) {\n    $url_pattern = '/(https?:\/\/[^\s]+)/';\n    $replacement = '<a href="$1">$1</a>';\n    return preg_replace($url_pattern, $replacement, $text);\n}\n\n// Test the function\n$text = 'Hello, visit http://example.com for more information.';\necho replace_urls_with_links($text);\n\n// Output: Hello, visit <a href="http://example.com">http://example.com</a> for more information.