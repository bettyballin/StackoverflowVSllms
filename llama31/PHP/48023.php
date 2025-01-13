$content = strip_tags($content, '<b><i><ul><ol><li>');\n\n// Remove attributes from allowed tags\n$content = preg_replace('/<(b|i|ul|ol|li)[^>]*>/', '<$1>', $content);\n\n// Encode special characters in text content\n$content = preg_replace_callback('/>([^<]+)</', function($match) {\n    return '>' . htmlspecialchars($match[1]) . '<';\n}, $content);\n\necho $content;