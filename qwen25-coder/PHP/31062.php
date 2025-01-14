// Allow specific tags: <b><i><ul><ol><li>\n$allowedTags = '<b><i><ul><ol><li>';\n\n// Strip unwanted tags but keep allowed ones\n$content = strip_tags($content, $allowedTags);\n\n// Encode special characters to prevent XSS\n$safeContent = htmlspecialchars($content, ENT_QUOTES, 'UTF-8');\n\n// Output the sanitized content\necho $safeContent;