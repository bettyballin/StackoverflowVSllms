$string = '123abc456def';\npreg_match_all('/./', $string, $array);\n\n// Output the result\nprint_r($array);