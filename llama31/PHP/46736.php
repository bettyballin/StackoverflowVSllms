$url = 'http://example.com/xml'; // change this to the URL of the website\n$filename = 'local_copy.xml'; // the local file to save the XML to\n\n$ch = curl_init($url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n$xml = curl_exec($ch);\ncurl_close($ch);\n\nfile_put_contents($filename, $xml);