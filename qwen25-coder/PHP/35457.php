$xmlData = <<<XML\n<links>\n    <image_link>http://img357.imageshack.us/img357/9606/48444016.jpg</image_link>\n    <thumb_link>http://img357.imageshack.us/img357/9606/48444016.th.jpg</thumb_link>\n    <ad_link>http://img357.imageshack.us/my.php?image=48444016.jpg</ad_link>\n    <thumb_exists>yes</thumb_exists>\n    <total_raters>0</total_raters>\n    <ave_rating>0.0</ave_rating>\n    <image_location>img357/9606/48444016.jpg</image_location>\n    <thumb_location>img357/9606/48444016.th.jpg</thumb_location>\n    <server>img357</server>\n    <image_name>48444016.jpg</image_name>\n    <done_page>http://img357.imageshack.us/content.php?page=done&l=img357/9606/48444016.jpg</done_page>\n    <resolution>800x600</resolution>\n    <filesize>38477</filesize>\n    <image_class>r</image_class>\n</links>\nXML;\n\n$startTag = '<image_link>';\n$endTag = '</image_link>';\n\n$startPos = strpos($xmlData, $startTag) + strlen($startTag);\n$endPos = strpos($xmlData, $endTag, $startPos);\n\n$imageLink = substr($xmlData, $startPos, $endPos - $startPos);\n\necho $imageLink;