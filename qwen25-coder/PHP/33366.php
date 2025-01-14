function parse_tweet($description, $colour='', $external=false) {\n    if ($external == true) $pre = 'http://politwitter.ca'; else $pre = '';\n    \n    // Links starting with http\n    $description = preg_replace("/(https?:\/\/[^\s]+)/", "<a href=\"$1\" target=\"_blank\">$1</a>", $description);\n    \n    // Links without http but starting with www or ftp\n    $description = preg_replace("#(^|[\n ])((www|ftp)\.[^\s]+)#", "\\1<a href=\"http://\\2\" target=\"_blank\">\\2</a>", $description);\n    \n    // @replies: match until a non-alphanumeric character is found\n    $description = preg_replace("#(^|[\n ])[@]([a-zA-Z0-9_]+)#", "\\1<a href=\"".$pre."/user/\\2\" rel=\"nofollow\">@\\2</a>", $description);\n    \n    // Hashtags: match until a non-alphanumeric character is found\n    $description = preg_replace("#(^|[\n ])[#]([a-zA-Z0-9_]+)#", "\\1<a href=\"".$pre."/hash/\\2\" rel=\"nofollow\" class=\"hash ".$colour."\">#\\2</a>", $description);\n    \n    return $description;\n}