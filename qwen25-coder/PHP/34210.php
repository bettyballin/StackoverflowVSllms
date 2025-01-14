function linkifyUrls($text) {\n    // Regular expression to match URLs\n    $pattern = '~(?:(https?|ftp)://[^\s]+|[a-z0-9.-]+\.[a-z]{2,6}[^\s]*)~i';\n\n    // Callback function to create the links\n    $callback = function ($matches) {\n        $url = $matches[0];\n        if (!preg_match('~^(https?|ftp)://~', $url)) {\n            $url = 'http://' . $url;\n        }\n        return '<a href="' . htmlspecialchars($url, ENT_QUOTES, 'UTF-8') . '" rel="noreferrer">' . htmlspecialchars($matches[0], ENT_QUOTES, 'UTF-8') . '</a>';\n    };\n\n    // Apply the pattern and callback to replace URLs with links\n    return preg_replace_callback($pattern, $callback, $text);\n}\n\n$inputText = "Look on http://www.google.com";\necho linkifyUrls($inputText);