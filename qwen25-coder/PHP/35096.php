$string = "I like: perl";\n\nif (preg_match('/[[:punct:]]/', $string)) {  \n    $new = preg_replace('/[[:punct:]]/', ' ', $string);\n}\necho $new;