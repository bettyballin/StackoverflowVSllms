function replaceTags($template, $newtext) {\n    return preg_replace_callback('/%MYTAG%/', function($match) use ($newtext) {\n        return $newtext;\n    }, $template);\n}