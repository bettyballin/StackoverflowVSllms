function convert_to_eastern_arabic_numerals($number) {\n    $western_digits = array('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');\n    $eastern_arabic_digits = array('٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩');\n    return str_replace($western_digits, $eastern_arabic_digits, $number);\n}