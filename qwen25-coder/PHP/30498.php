$protocol = isset($_SERVER['HTTPS']) && $_SERVER['HTTPS'] === 'on' ? "https" : "http";\n     $host = $_SERVER['HTTP_HOST'];\n     $rssFeedUrl = "$protocol://$host/feed/";\n     \n     // Use curl or file_get_contents\n     $content = file_get_contents($rssFeedUrl);