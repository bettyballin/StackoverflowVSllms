$template = preg_replace('/\{a\}(.+?)\{\/a\}/s', 'X', $template, -1, $count);\necho $count; // Should now reflect matches found