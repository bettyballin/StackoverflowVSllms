$text = preg_replace('!@([A-Za-z0-9_]+)(?!\.)!', '<a href="http://twitter.com/$1" target="_blank">@$1</a>', $text);