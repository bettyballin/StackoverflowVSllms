$url = 'http://example.com/xmlfile.xml';\n\n$curl = curl_init($url);\ncurl_setopt($curl, CURLOPT_RETURNTRANSFER, true);\n$xmlContent = curl_exec($curl);\ncurl_close($curl);\n\nif ($xmlContent !== false) {\n    echo $xmlContent;\n} else {\n    echo 'Failed to retrieve XML content';\n}