$url = "http://example.com/data.xml";\n   $xmlContent = file_get_contents($url);\n   file_put_contents('data.xml', $xmlContent);