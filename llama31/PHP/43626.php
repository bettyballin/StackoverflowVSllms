$url = 'http://en.wikipedia.org/w/api.php?';\n$url .= 'format=json';\n$url .= '&action=parse';\n$url .= '&page=' . $article;\n$url .= '&prop=text';\n$url .= '&origin=*';\n\ncurl_setopt($s, CURLOPT_URL, $url);\ncurl_setopt($s, CURLOPT_HEADER, false);\ncurl_setopt($s, CURLOPT_RETURNTRANSFER, 1);\n\n$rs = curl_exec($s);\n$rs = Zend_Json::decode($rs);\n\n$html = $rs['parse']['text']['*'];