$text = preg_replace('!(^|\s)@([A-Za-z0-9_]+)(?!\S*+@\S+)!', '$1<a href="http://twitter.com/$2" target="_blank">@$2</a>', $text);