require_once 'HTMLPurifier.auto.php';\n\n$html = $row2['ARTICLE_DESC'];\n$purifier = new HTMLPurifier();\n$clean_html = $purifier->purify($html);\n\n$html = json_encode($clean_html);