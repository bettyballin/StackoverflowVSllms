$ret = preg_replace('/(^|[^\w])(@[a-zA-Z0-9\-]+)/', '\\1<a href="http://twitter.com/$2" rel="nofollow noreferrer">\\2</a>', $ret);