$url = "http://" . $_SERVER["HTTP_HOST"] . $_SERVER["REQUEST_URI"];\n$domain = parse_url($url, PHP_URL_HOST);