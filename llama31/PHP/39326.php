$urlInfo = parse_url($_SERVER['REQUEST_URI']);\n$url = 'http://' . $_SERVER['HTTP_HOST'] . dirname($urlInfo['path']);