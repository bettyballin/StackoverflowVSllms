preg_match_all("/(<%(?=(?:[^>]*>|>$))|&amp;lt;%(?=(?:[^&gt;]*&amp;gt;|$)))\s*(.*?)\s*((?<!&amp;)%(?!gt;)|(?<=&)gt;&amp;)/i", $markup, $matches);\n\n// The captured content will be in $matches[2]\nforeach ($matches[2] as $match) {\n    echo htmlspecialchars($match) . "\n";\n}