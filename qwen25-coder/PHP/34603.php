$string = "name=Shake & Bake&difficulty=easy";\npreg_match_all('/(\w+)=(.*?)(?=&\w+=|$)/', $string, $matches);\n\n$params = array_combine($matches[1], $matches[2]);\nprint_r($params);