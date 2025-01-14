function convertUrlsToAnchors($string) {\n    // Regular expression pattern for URLs\n    $pattern = '/(https?:\/\/[^\s]+)/';\n    \n    // Replacement pattern adding <a> tag around the URL\n    $replacement = '<a href="$1">$1</a>';\n    \n    // Replace all occurrences of patterns with replacement\n    return preg_replace($pattern, $replacement, $string);\n}\n\n$string = "Check out this site: https://example.com and also visit http://another-example.org for more info.";\necho convertUrlsToAnchors($string);