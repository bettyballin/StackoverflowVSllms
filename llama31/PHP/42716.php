$string = 'word1#$word2#$word3';\n$pattern = '/^([^#\$]+)#\$(.*)#\$(.*)$/';\npreg_match($pattern, $string, $matches);\nprint_r($matches);