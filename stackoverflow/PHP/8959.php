$string = preg_replace('/[\x00-\x1F\x7F-\xFF]/', '', $string);