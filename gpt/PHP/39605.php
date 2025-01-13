function custom_htmlentities($string) {\n    return htmlentities($string, ENT_QUOTES); // Change ENT_QUOTES to your preferred quote style\n}\n\n$array = ['string1', 'string2', 'string3'];\n$encodedArray = array_map('custom_htmlentities', $array);\n\nprint_r($encodedArray);