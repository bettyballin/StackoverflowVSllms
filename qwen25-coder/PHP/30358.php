<?php\n$data = array(\n    'title' => 'My Cool Title',\n    'content' => 'This is some content.'\n);\n\n$template = '<html>\n<title><% title %></title>\n<body><% content %></body>\n</html>';\n\n$endMarkup = preg_replace_callback('/<% ([a-z]+) %>/i', function($matches) use ($data) {\n    return isset($data[$matches[1]]) ? $data[$matches[1]] : $matches[0];\n}, $template);\n\necho htmlspecialchars($endMarkup);\n?>