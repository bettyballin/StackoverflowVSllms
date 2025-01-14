require_once 'path/to/HTMLPurifier.auto.php';\n\n$config = HTMLPurifier_Config::createDefault();\n$purifier = new HTMLPurifier($config);\n$dirty_html = "<script>alert('xss');</script><b>Hello World</b>";\n$clean_html = $purifier->purify($dirty_html);\n\necho "Cleaned: ", htmlspecialchars($clean_html, ENT_QUOTES, 'UTF-8');