$pattern = "/<description>(.*?)<\/description>/is";\n$rawFeed = preg_replace_callback($pattern, function($matches) {\n    return '<description>' . htmlentities($matches[1]) . '</description>';\n}, $rawFeed);