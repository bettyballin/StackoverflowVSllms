$ret = preg_replace_callback('/(^|[^\w])(@[a-zA-Z0-9\-]+)/', function($matches) {\n    return $matches[1] . '<a href="http://twitter.com/' . substr($matches[2], 1) . '" rel="nofollow noreferrer">' . $matches[2] . '</a>';\n}, $ret);