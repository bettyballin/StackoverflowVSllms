$myString = "This is some text, the email is here example@example.com, and another email foo@bar.com";\n$pattern = '/\b\w+[\w-.]*@\w+((-\w+)|(\w*)).[a-z]{2,3}\b/';\n\npreg_match_all($pattern, $myString, $matches);\nprint_r($matches[0]);\n// outputs: Array ( [0] => example@example.com [1] => foo@bar.com )