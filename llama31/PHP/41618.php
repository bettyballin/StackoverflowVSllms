$username = 'twitter';\n$xml = simplexml_load_file("http://twitter.com/users/".$username.".xml");\necho $xml->profile_image_url;