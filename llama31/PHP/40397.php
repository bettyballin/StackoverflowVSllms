preg_replace("#\[url=(.*?)\](.*?)\[/url\]#is", '<a href="$1">$2</a>', $text);